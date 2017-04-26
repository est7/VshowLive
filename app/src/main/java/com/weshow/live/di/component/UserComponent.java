package com.weshow.live.di.component;


import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.basemodule.di.scope.ActivityScope;
import com.weshow.live.di.module.UserModule;
import com.weshow.live.user.ui.activity.UserActivity;

import dagger.Component;


/**
 * Created by jess on 9/4/16 11:17
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
@Component(modules = UserModule.class,dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity activity);
}
