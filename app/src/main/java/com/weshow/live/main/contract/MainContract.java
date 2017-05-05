package com.weshow.live.main.contract;

import com.weshow.live.basemodule.mvp.IModel;
import com.weshow.live.basemodule.mvp.IView;

import rx.Observable;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/4/26 15:08.
 * <p>
 * Description : File in com.weshow.live.main.contract , Project in VshowLive
 * <p>
 * Content:
 */

public class MainContract {
    public interface View extends IView {


    }

    public interface Model extends IModel {


        Observable getAttentionList(int startindex, int countsize, boolean update);

        Observable geRecommendtList(int startindex, int countsize, boolean update);

        Observable getHotList(int startindex, boolean update);
    }
}
