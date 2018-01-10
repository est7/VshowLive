package com.weshow.live.main.presenter;

import com.weshow.live.basemodule.di.scope.FragmentScope;
import com.weshow.live.basemodule.mvp.BasePresenter;
import com.weshow.live.basemodule.utils.RxUtils;
import com.weshow.live.bean.HotListBean;
import com.weshow.live.main.contract.RecommendContract;
import com.weshow.live.main.ui.adapter.RecommendHotListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/4/26 15:07.
 * <p>
 * Description : File in com.weshow.live.main.presenter , Project in VshowLive
 * <p>
 * Content:
 */
@FragmentScope
public class RecommendPresenter extends BasePresenter<RecommendContract.Model, RecommendContract.View<HotListBean>> {

    private RecommendContract.Model mModel;
    private RecommendContract.View mRootView;
    private RecommendHotListAdapter mAdapter;
    private List<HotListBean.SubjectsBean> mHotList = new ArrayList<>();
    private int startindex;
    private RxErrorHandler mErrorHandler;
    private boolean isFirst = true;
    private int preEndIndex;

    @Inject
    public RecommendPresenter(RecommendContract.Model model, RecommendContract.View rootView, RxErrorHandler handler) {
        super(model, rootView);
        mModel = model;
        mRootView = rootView;
        this.mErrorHandler = handler;
        mAdapter = new RecommendHotListAdapter(mHotList);
        mRootView.setAdapter(mAdapter);
    }


    public void requestHotlist(boolean pullToRefresh) {

        if (pullToRefresh) startindex = 0;
        boolean isEvictCache = pullToRefresh;//是否驱逐缓存,为ture即不使用缓存,每次上拉刷新即需要最新数据,则不使用缓存
        if (pullToRefresh && isFirst) {//默认在第一次上拉刷新时使用缓存
            isFirst = false;
            isEvictCache = false;
        }

        mModel.getHotList(startindex, isEvictCache)
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(Schedulers.io())//表示前面操作符的操作线程
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(() -> {
                    if (pullToRefresh) {
                        mRootView.hideLoading();
                    } else {
                        mRootView.endloadMore();
                    }
                })
                .compose(RxUtils.<HotListBean>bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<HotListBean>(mErrorHandler) {

                    @Override
                    public void onNext(HotListBean hotListBean) {
                        startindex = hotListBean.getStart();//记录最后一个id,用于下一次请求
                        if (pullToRefresh) mHotList.clear();//如果是上拉刷新则清空列表
                        preEndIndex = mHotList.size();//更新之前列表总长度,用于确定加载更多的起始位置
                        mHotList = hotListBean.getSubjects();
                        if (pullToRefresh)
                            mAdapter.notifyDataSetChanged();
                        else
                            mAdapter.notifyItemRangeInserted(preEndIndex, mHotList.size());
                    }
                });


    }

    public void cancelRequest() {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mAdapter = null;
        this.mHotList = null;
        this.mErrorHandler = null;

    }
}
