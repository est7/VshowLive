package com.weshow.live.main.model.api.cache;

import com.weshow.live.main.model.entity.HotList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import rx.Observable;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2017/5/3 17:13.
 * <p>
 * Description : File in com.weshow.live.main.model.api.cache , Project in VshowLive
 * <p>
 * Content:
 */

public interface MainCache {

    //EvictProvider为true时,通过这个Retrofit接口重新请求最新的数据,并且将服务器返回的结果包装成Reply返回,返回之前会向内存缓存和磁盘缓存中各保存一份
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<HotList>>> getHotList(Observable<List<HotList>> oHots, DynamicKey idLastUserQueried, EvictProvider evictProvider);
}
