package com.weshow.live.basemodule.mvp;

import android.support.annotation.UiThread;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/5/4 14:00.
 * <p>
 * Description : File in com.weshow.live.basemodule.mvp , Project in VshowLive
 * <p>
 * Content:
 */

public interface BaseView extends IView {
    /**
     * 显示加载
     */
    @UiThread
    void showLoading();

    /**
     * 隐藏加载
     */
    @UiThread
    void hideLoading();

    /**
     * 显示信息
     */
    @UiThread
    void showMessage(String message);


    /*@UiThread
    public void showContent(M data);

    @UiThread
    public void showError(Throwable e);

    @UiThread
    public void showEmpty();*/
}
