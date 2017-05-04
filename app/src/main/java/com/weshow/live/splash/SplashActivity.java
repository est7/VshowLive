package com.weshow.live.splash;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;

import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseActivity;
import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.basemodule.utils.UiUtils;
import com.weshow.live.main.ui.activity.MainActivity;
import com.weshow.live.user.ui.activity.UserActivity;

import butterknife.OnClick;

public class SplashActivity extends BaseActivity {


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_splash, null, false);
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.splash_btn)
    public void goMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        UiUtils.startActivity(intent);
    }

    @OnClick(R.id.user_btn)
    public void goUserPage() {
        Intent intent = new Intent(this, UserActivity.class);
        UiUtils.startActivity(intent);
    }
}