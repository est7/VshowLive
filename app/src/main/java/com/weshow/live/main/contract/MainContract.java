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


        Observable getAttentionList(long token, int id, int startindex, int endindex, boolean update);

        Observable geRecommendtList(long token, int id, int startindex, int endindex, boolean update);

        Observable geHotList(long token, int id, int startindex, int endindex, boolean update);
    }
}
