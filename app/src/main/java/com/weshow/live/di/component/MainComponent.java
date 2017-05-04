package com.weshow.live.di.component;

import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.basemodule.di.scope.ActivityScope;
import com.weshow.live.di.module.MainModule;
import com.weshow.live.main.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/5/3 16:04.
 * <p>
 * Description : File in com.weshow.live.di.component , Project in VshowLive
 * <p>
 * Content:
 */
@ActivityScope
@Component(modules = MainModule.class,dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
