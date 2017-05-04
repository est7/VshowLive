package com.weshow.live.basemodule.di.component;

import android.app.Application;

import com.google.gson.Gson;
import com.weshow.live.basemodule.base.BaseApplication;
import com.weshow.live.basemodule.di.module.AppModule;
import com.weshow.live.basemodule.di.module.ClientModule;
import com.weshow.live.basemodule.di.module.GlobeConfigModule;
import com.weshow.live.basemodule.di.module.ImageModule;
import com.weshow.live.basemodule.integration.AppManager;
import com.weshow.live.basemodule.integration.IRepositoryManager;
import com.weshow.live.basemodule.widget.imageloader.ImageLoader;

import java.io.File;

import javax.inject.Singleton;

import dagger.Component;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import okhttp3.OkHttpClient;

/**
 * Created by jess on 8/4/16.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, ImageModule.class, GlobeConfigModule.class})
public interface AppComponent {
    Application Application();

    //用于管理网络请求层,以及数据缓存层
    IRepositoryManager repositoryManager();

    //Rxjava错误处理管理类
    RxErrorHandler rxErrorHandler();


    OkHttpClient okHttpClient();

    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoader();

    //gson
    Gson gson();

    //缓存文件根目录(RxCache和Glide的的缓存都已经作为子文件夹在这个目录里),应该将所有缓存放到这个根目录里,便于管理和清理,可在GlobeConfigModule里配置
    File cacheFile();

    //用于管理所有activity
    AppManager appManager();


    void inject(BaseApplication application);
}
