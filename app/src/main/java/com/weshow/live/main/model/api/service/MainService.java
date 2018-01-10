package com.weshow.live.main.model.api.service;

import com.weshow.live.bean.HotListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/5/3 17:07.
 * <p>
 * Description : File in com.weshow.live.main.model.api.service , Project in VshowLive
 * <p>
 * Content:
 */

public interface MainService {
    @GET("http://api.douban.com/v2/movie/top250")
    Observable<HotListBean> getHotList(@Query("start") int numStart, @Query("count") int numOffset);


}
