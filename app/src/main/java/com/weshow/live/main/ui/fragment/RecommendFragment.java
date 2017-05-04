package com.weshow.live.main.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseFragment;
import com.weshow.live.basemodule.di.component.AppComponent;

public class RecommendFragment extends BaseFragment {

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
    }

    @Override
    protected void onFragmentFirstVisible() {
/*
        //去服务器下载数据
        mRefreshState = STATE_REFRESHING;
        mCategoryController.loadBaseData();
*/


    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {



    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    protected void initData() {

    }
}
