package com.weshow.live.main.ui.activity;

import android.view.LayoutInflater;
import android.view.View;

import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseActivity;
import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> {


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {


    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_main, null, false);
    }

    @Override
    protected void initData() {



    }

}
