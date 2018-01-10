package com.weshow.live.basemodule.base;

import android.app.Application;
import android.content.Context;

import com.weshow.live.basemodule.di.component.AppComponent;
import com.weshow.live.basemodule.di.component.DaggerAppComponent;
import com.weshow.live.basemodule.di.module.AppModule;
import com.weshow.live.basemodule.di.module.ClientModule;
import com.weshow.live.basemodule.di.module.GlobeConfigModule;
import com.weshow.live.basemodule.di.module.ImageModule;
import com.weshow.live.basemodule.integration.ActivityLifecycle;
import com.weshow.live.basemodule.integration.ConfigModule;
import com.weshow.live.basemodule.integration.ManifestParser;

import java.util.List;

import javax.inject.Inject;

public abstract class BaseApplication extends Application {
    static private BaseApplication mApplication;
    private AppComponent mAppComponent;
    @Inject
    protected ActivityLifecycle mActivityLifecycle;
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        List<ConfigModule> modules = new ManifestParser(this).parse();

        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))////提供application
                .clientModule(new ClientModule())//用于提供okhttp和retrofit的单例
                .imageModule(new ImageModule())//图片加载框架默认使用glide
                .globeConfigModule(getGlobeConfigModule(this,modules))//全局配置
                .build();
        mAppComponent.inject(this);

        for (ConfigModule module : modules) {
            module.registerComponents(this, mAppComponent.repositoryManager());
        }

        registerActivityLifecycleCallbacks(mActivityLifecycle);
    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mActivityLifecycle != null) {
            unregisterActivityLifecycleCallbacks(mActivityLifecycle);
        }
        this.mAppComponent = null;
        this.mActivityLifecycle = null;
        this.mApplication = null;
    }



    /**
     * 将app的全局配置信息封装进module(使用Dagger注入到需要配置信息的地方)
     * 需要在AndroidManifest中声明{@link ConfigModule}的实现类,和Glide的配置方式相似
     *
     * @return
     */
    private GlobeConfigModule getGlobeConfigModule(Application context, List<ConfigModule> modules) {

        GlobeConfigModule.Builder builder = GlobeConfigModule
                .builder()
                .baseurl("https://api.github.com");//为了防止用户没有通过GlobeConfigModule配置baseurl,而导致报错,所以提前配置个默认baseurl

        for (ConfigModule module : modules) {
            module.applyOptions(context, builder);
        }

        return builder.build();
    }


    /**
     * 将AppComponent返回出去,供其它地方使用, AppComponent接口中声明的方法返回的实例,在getAppComponent()拿到对象后都可以直接使用
     *
     * @return
     */
    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    /**
     * 返回上下文
     *
     * @return
     */
    public static Context getContext() {
        return mApplication;
    }

}
