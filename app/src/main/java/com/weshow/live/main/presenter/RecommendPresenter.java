package com.weshow.live.main.presenter;

import com.weshow.live.basemodule.mvp.BasePresenter;
import com.weshow.live.main.contract.RecommendContract;
import com.weshow.live.main.model.entity.HotList;

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

public class RecommendPresenter extends BasePresenter<RecommendContract.Model,RecommendContract.View<HotList>> {

    private final RecommendContract.Model mModel;
    private final RecommendContract.View mRootView;

    @Inject
    public RecommendPresenter(RecommendContract.Model model, RecommendContract.View rootView) {
        super(model, rootView);
        mModel = model;
        mRootView = rootView;
    }


    /*public void requestRecommendList(token,) {

        mModel.geRecommendtList(token,startindex,endindex,)
    }*/
}
