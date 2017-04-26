package com.weshow.live.user.ui.adapter;

import android.view.View;

import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseHolder;
import com.weshow.live.basemodule.base.DefaultAdapter;
import com.weshow.live.user.model.entity.User;
import com.weshow.live.user.ui.holder.UserItemHolder;

import java.util.List;

/**
 * Created by jess on 9/4/16 12:57
 * Contact with jess.yan.effort@gmail.com
 */
public class UserAdapter extends DefaultAdapter<User> {
    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<User> getHolder(View v, int viewType) {
        return new UserItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list;
    }
}
