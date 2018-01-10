package com.weshow.live.di.module;

import android.app.Activity;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.weshow.live.basemodule.di.scope.ActivityScope;
import com.weshow.live.user.contract.UserContract;
import com.weshow.live.user.model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jess on 9/4/16 11:10
 * Contact with jess.yan.effort@gmail.com
 */
@Module
public class UserModule {
    private UserContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public UserModule(UserContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UserContract.View provideUserView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    UserContract.Model provideUserModel(UserModel model) {
        return model;
    }


    @ActivityScope
    @Provides
    RxPermissions provideRxPermissions() {
        return new RxPermissions((Activity) view);
    }



}
