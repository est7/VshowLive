package com.weshow.live.di.module;

import com.weshow.live.basemodule.di.scope.ActivityScope;
import com.weshow.live.main.contract.MainContract;
import com.weshow.live.main.model.MainModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/5/3 16:06.
 * <p>
 * Description : File in com.weshow.live.di.module , Project in VshowLive
 * <p>
 * Content:
 */
@Module
public class MainModule {

    private final MainContract.View mView;

    public MainModule(MainContract.View view) {
        mView = view;
    }

    @ActivityScope
    @Provides
    MainContract.View provideMainView(){
        return mView;
    }

    @ActivityScope
    @Provides
    MainContract.Model provideMainModel(MainModel model){
        return model;
    }
}
