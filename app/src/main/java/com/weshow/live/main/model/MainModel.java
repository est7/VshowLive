package com.weshow.live.main.model;


import com.weshow.live.basemodule.di.scope.ActivityScope;
import com.weshow.live.basemodule.integration.IRepositoryManager;
import com.weshow.live.basemodule.mvp.BaseModel;
import com.weshow.live.main.contract.MainContract;
import com.weshow.live.main.model.api.cache.MainCache;
import com.weshow.live.main.model.api.service.MainService;
import com.weshow.live.main.model.entity.HotList;

import java.util.List;

import javax.inject.Inject;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by jess on 9/4/16 10:56
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    public static final int USERS_PER_PAGE = 10;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }


    @Override
    public Observable getAttentionList(long token, int id, int startindex, int endindex, boolean update) {
        return null;
    }

    @Override
    public Observable geRecommendtList(long token, int id, int startindex, int endindex, boolean update) {
        return null;
    }

    @Override
    public Observable geHotList(long token, int id, int startindex, int endindex, boolean update) {
        Observable<List<HotList>> hotList = mRepositoryManager.obtainRetrofitService(MainService.class).getHotList(startindex, endindex);

        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return mRepositoryManager.obtainCacheService(MainCache.class).getHotList(hotList
                , new DynamicKey(hotList)
                , new EvictDynamicKey(update))
                .flatMap(new Func1<Reply<List<HotList>>, Observable<List<HotList>>>() {
                    @Override
                    public Observable<List<HotList>> call(Reply<List<HotList>> listReply) {
                        return Observable.just(listReply.getData());
                    }
                });
    }
}
