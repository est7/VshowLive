package com.weshow.live.main.presenter;

import com.weshow.live.basemodule.mvp.BasePresenter;
import com.weshow.live.bean.HotListBean;
import com.weshow.live.main.contract.RecommendContract;

import javax.inject.Inject;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/4/26 15:07.
 * <p>
 * Description : File in com.weshow.live.main.presenter , Project in VshowLive
 * <p>
 * Content:
 */

public class RecommendPresenter extends BasePresenter<RecommendContract.Model,RecommendContract.View<HotListBean>> {

    private final RecommendContract.Model mModel;
    private final RecommendContract.View mRootView;
    private int startindex;

    @Inject
    public RecommendPresenter(RecommendContract.Model model, RecommendContract.View rootView) {
        super(model, rootView);
        mModel = model;
        mRootView = rootView;
    }


    public void requestHotlist(boolean pullToRefresh) {

        if (pullToRefresh) startindex = 0;

        boolean isEvictCache = pullToRefresh;//是否驱逐缓存,为ture即不使用缓存,每次上拉刷新即需要最新数据,则不使用缓存

        mModel.getHotList(startindex, isEvictCache);
    }
}
