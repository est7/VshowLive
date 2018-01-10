package com.weshow.live.main.contract;

import android.support.annotation.UiThread;

import com.weshow.live.basemodule.base.DefaultAdapter;
import com.weshow.live.basemodule.mvp.BaseView;
import com.weshow.live.basemodule.mvp.IModel;
import com.weshow.live.bean.HotListBean;

import rx.Observable;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/5/4 13:58.
 * <p>
 * Description : File in com.weshow.live.main.contract , Project in VshowLive
 * <p>
 * Content:
 */

public interface RecommendContract {

    public interface View<M> extends BaseView {

        void setAdapter(DefaultAdapter adapter);

        @UiThread
        public void showError(Throwable e);

        @UiThread
        public void showEmpty();

        void endloadMore();

    }

    public interface Model extends IModel {
        Observable<HotListBean> getHotList(int startindex, boolean update);
    }

}
