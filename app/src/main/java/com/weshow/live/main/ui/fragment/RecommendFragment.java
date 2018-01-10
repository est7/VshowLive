package com.weshow.live.main.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseFragment;
import com.weshow.live.basemodule.base.DefaultAdapter;
import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.di.component.DaggerRecommendComponent;
import com.weshow.live.di.module.RecommendModule;
import com.weshow.live.main.contract.RecommendContract;
import com.weshow.live.main.presenter.RecommendPresenter;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {


    @BindView(R.id.rev_recommend_content)
    XRecyclerView mXRecyclerView;
    private XRecyclerView.LoadingListener mLoadingListener = new XRecyclerView.LoadingListener() {
        @Override
        public void onRefresh() {
            mPresenter.requestHotlist(true);
        }

        @Override
        public void onLoadMore() {
            mPresenter.requestHotlist(false);
        }
    };

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
/*
        if (isVisible) {
            //更新界面数据，如果数据还在下载中，就显示加载框
            notifyDataSetChanged();
            if (mRefreshState == STATE_REFRESHING) {
                mRefreshListener.onRefreshing();
            }
        } else {
            //关闭加载框
            mRefreshListener.onRefreshFinish();
        }
*/


        if (isVisible) {

        } else {
            //取消加载,取消loading
            mPresenter.cancelRequest();
            mXRecyclerView.refreshComplete();
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
/*
        //去服务器下载数据
        mRefreshState = STATE_REFRESHING;
        mCategoryController.loadBaseData();
*/

        if (mPresenter != null) {
            mPresenter.requestHotlist(true);
        }


    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder()
                .appComponent(appComponent)
                .recommendModule(new RecommendModule(this, getActivity()))
                .build()
                .inject(this);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    protected void initData() {
        //empty
    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    @Override
    public void showLoading() {
        mXRecyclerView.refresh();
    }

    @Override
    public void hideLoading() {
        mXRecyclerView.refreshComplete();

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setAdapter(DefaultAdapter adapter) {
        mXRecyclerView.setAdapter(adapter);
        initRecycleView();
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void endloadMore() {
        mXRecyclerView.loadMoreComplete();
    }


    private void initRecycleView() {
//        UiUtils.configRecycleView(mXRecyclerView, new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mXRecyclerView.setLoadingListener(mLoadingListener);

    }


}
