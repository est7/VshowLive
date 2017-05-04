package com.weshow.live.main.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseActivity;
import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.main.contract.MainContract;
import com.weshow.live.main.presenter.MainPresenter;
import com.weshow.live.main.ui.adapter.MainPagerAdapter;
import com.weshow.live.main.ui.fragment.RecommendFragment;
import com.weshow.live.view.ScaleTransitionPagerTitleView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{


    @BindView(R.id.vp_content)
    ViewPager mViewPager;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.magic_indicator)
    MagicIndicator mViewPagerIndicator;
    private List<String> mTitleList = Arrays.asList("关注", "推荐", "全部");
    private List<Fragment> mFragmentList = Arrays.asList(new RecommendFragment(), new RecommendFragment(), new RecommendFragment());


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {



    }


    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_main, null, false);
    }

    @Override
    protected void initData() {
        initViewPager();
        initMagicIndicator();
    }

    private void initMagicIndicator() {
        mViewPagerIndicator.setBackgroundColor(Color.parseColor("#ffffff"));
        CommonNavigator commonNavigator = new CommonNavigator(getApplicationContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleList == null ? 0 : mTitleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ScaleTransitionPagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mTitleList.get(index));
                simplePagerTitleView.setMinScale(0.9f);
                simplePagerTitleView.setTextSize(18);
                simplePagerTitleView.setNormalColor(Color.parseColor("#4d4d4d"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#f3595b"));
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(Color.parseColor("#f3595b"));
                return indicator;
            }
        });
        mViewPagerIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mViewPagerIndicator, mViewPager);
    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(2);
        MainPagerAdapter mAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mAdapter);

    }


    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }
}
