package com.weshow.live.di.module;

import android.content.Context;

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

    private final Context mContext;


    public RecommendModule(RecommendContract.View view, Context context) {
        mView = view;
        mContext = context;
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

    @FragmentScope
    @Provides
    Context provideActivityContext() {
        return mContext;
    }

}
