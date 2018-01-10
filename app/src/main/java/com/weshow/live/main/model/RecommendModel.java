package com.weshow.live.main.model;


import com.weshow.live.basemodule.di.scope.FragmentScope;
import com.weshow.live.basemodule.integration.IRepositoryManager;
import com.weshow.live.basemodule.mvp.BaseModel;
import com.weshow.live.bean.HotListBean;
import com.weshow.live.main.contract.RecommendContract;
import com.weshow.live.main.model.api.cache.MainCache;
import com.weshow.live.main.model.api.service.MainService;

import javax.inject.Inject;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import rx.Observable;

@FragmentScope
public class RecommendModel extends BaseModel implements RecommendContract.Model {
    public static final int PAGE_SIZE = 20;

    @Inject
    public RecommendModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }


    @Override
    public Observable<HotListBean> getHotList(int startindex, boolean update) {
        Observable<HotListBean> hotList = mRepositoryManager.obtainRetrofitService(MainService.class).getHotList(startindex, PAGE_SIZE);

        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return mRepositoryManager.obtainCacheService(MainCache.class).getHotList(
                hotList
                , new DynamicKey(startindex)
                , new EvictDynamicKey(update))
                .flatMap(listReply -> Observable.just(listReply.getData()));
    }
}
