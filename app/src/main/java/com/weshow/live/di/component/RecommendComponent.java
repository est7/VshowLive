package com.weshow.live.di.component;

import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.basemodule.di.scope.FragmentScope;
import com.weshow.live.di.module.RecommendModule;
import com.weshow.live.main.ui.fragment.RecommendFragment;

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
@FragmentScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {
    void inject(RecommendFragment fragment);
}
