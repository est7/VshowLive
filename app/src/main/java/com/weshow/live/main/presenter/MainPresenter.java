package com.weshow.live.main.presenter;

import com.weshow.live.basemodule.mvp.BasePresenter;
import com.weshow.live.main.contract.MainContract;

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

public class MainPresenter extends BasePresenter<MainContract.Model,MainContract.View> {

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);


    }
}
