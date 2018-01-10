package com.weshow.live.main.ui.adapter;

import android.view.View;

import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseHolder;
import com.weshow.live.basemodule.base.DefaultAdapter;
import com.weshow.live.bean.HotListBean;
import com.weshow.live.main.ui.holder.HotListHolder;

import java.util.List;

/**
 * Created by jess on 9/4/16 12:57
 * Contact with jess.yan.effort@gmail.com
 */
public class RecommendHotListAdapter extends DefaultAdapter<HotListBean.SubjectsBean> {
    public RecommendHotListAdapter(List<HotListBean.SubjectsBean> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<HotListBean.SubjectsBean> getHolder(View v, int viewType) {
        return new HotListHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list;
    }
}
