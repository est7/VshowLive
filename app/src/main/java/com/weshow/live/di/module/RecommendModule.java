package com.weshow.live.di.module;

import com.weshow.live.basemodule.di.scope.FragmentScope;
import com.weshow.live.main.contract.RecommendContract;
import com.weshow.live.main.model.RecommendModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/5/5 2:14.
 * <p>
 * Description : File in com.weshow.live.main.model , Project in VshowLive
 * <p>
 * Content:
 */
@Module
public class RecommendModule {

    private final RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }

    @FragmentScope
    @Provides
    RecommendContract.View provideRecommendView() {
        return mView;
    }

    @FragmentScope
    @Provides
    RecommendContract.Model provideRecommendModel(RecommendModel model) {
    return model;
}
}
