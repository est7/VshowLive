package com.weshow.live.basemodule.utils;


import com.trello.rxlifecycle.LifecycleTransformer;
import com.weshow.live.basemodule.base.BaseActivity;
import com.weshow.live.basemodule.base.BaseFragment;
import com.weshow.live.basemodule.mvp.BaseView;
import com.weshow.live.basemodule.mvp.IView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by jess on 11/10/2016 16:39
 * Contact with jess.yan.effort@gmail.com
 */

public class RxUtils {

    public static <T> Observable.Transformer<T, T> applySchedulers(final BaseView view) {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {//显示进度条
                                view.showLoading();
                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doAfterTerminate(new Action0() {
                            @Override
                            public void call() {
                                view.hideLoading();//隐藏进度条
                            }
                        }).compose(RxUtils.<T>bindToLifecycle(view));
            }
        };
    }


    public static <T> LifecycleTransformer<T> bindToLifecycle(IView view) {
        if (view instanceof BaseActivity) {
            return ((BaseActivity) view).<T>bindToLifecycle();
        } else if (view instanceof BaseFragment) {
            return ((BaseFragment) view).<T>bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't activity or fragment");
        }

    }

}
