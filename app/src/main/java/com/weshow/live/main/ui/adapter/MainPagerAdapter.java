package com.weshow.live.main.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.weshow.live.basemodule.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/4/28 14:20.
 * <p>
 * Description : File in com.weshow.live.main.ui.adapter , Project in VshowLive
 * <p>
 * Content:
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final FragmentManager mFragmentManager;
    private List<Fragment> mFragments;
    private BaseFragment mCurrentFragment;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragmentManager = fm;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        return mFragments.get(arg0);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentFragment=(BaseFragment) object;

    }

    public BaseFragment getCurrentFragment() {
        return mCurrentFragment;
    }

}