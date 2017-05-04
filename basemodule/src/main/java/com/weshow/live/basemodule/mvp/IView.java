package com.weshow.live.basemodule.mvp;

import android.content.Intent;

/**
 * Created by jess on 16/4/22.
 */
public interface IView {

    /**
     * 跳转activity
     */
    void launchActivity(Intent intent);
    /**
     * 杀死自己
     */
    void killMyself();
}
