package com.weshow.live.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.weshow.live.R;
import com.weshow.live.basemodule.utils.UiUtils;
import com.weshow.live.main.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {


    @BindView(R.id.splash_btn)
    Button mSplashBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @OnClick(R.id.splash_btn)
    private void goMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        UiUtils.startActivity(intent);
    }
}