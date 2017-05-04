package com.weshow.live.main.model.api.service;

import com.weshow.live.main.model.entity.HotList;

import java.util.List;

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
    @GET("room!getRoomListForMobile")
    Observable<List<HotList>> getHotList(@Query("numStart") int numStart, @Query("numOffset") int numOffset);

}
