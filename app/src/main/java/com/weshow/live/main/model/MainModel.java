package com.weshow.live.main.model;


import com.weshow.live.basemodule.di.scope.ActivityScope;
import com.weshow.live.basemodule.integration.IRepositoryManager;
import com.weshow.live.basemodule.mvp.BaseModel;
import com.weshow.live.main.contract.MainContract;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jess on 9/4/16 10:56
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    public static final int PAGE_SIZE = 20;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }


    @Override
    public Observable getAttentionList(int startindex, int countsize, boolean update) {
        return null;
    }

    @Override
    public Observable geRecommendtList(int startindex, int countsize, boolean update) {
        return null;
    }

    @Override
    public Observable getHotList(int startindex, boolean update) {
        return null;
    }
}
