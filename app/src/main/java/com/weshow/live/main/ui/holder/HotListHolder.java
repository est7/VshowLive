package com.weshow.live.main.ui.holder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.weshow.live.R;
import com.weshow.live.basemodule.base.BaseApplication;
import com.weshow.live.basemodule.base.BaseHolder;
import com.weshow.live.basemodule.widget.imageloader.ImageLoader;
import com.weshow.live.basemodule.widget.imageloader.glide.GlideImageConfig;
import com.weshow.live.bean.HotListBean;

import butterknife.BindView;
import rx.Observable;

/**
 * Created by jess on 9/4/16 12:56
 * Contact with jess.yan.effort@gmail.com
 */
public class HotListHolder extends BaseHolder<HotListBean.SubjectsBean> {

    @Nullable
    @BindView(R.id.iv_avatar)
    ImageView mAvater;
    @Nullable
    @BindView(R.id.tv_name)
    TextView mName;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    private final BaseApplication mApplication;

    public HotListHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到Application的地方,拿到AppComponent,从而得到用Dagger管理的单例对象
        mApplication = (BaseApplication) itemView.getContext().getApplicationContext();
        mImageLoader = mApplication.getAppComponent().imageLoader();
    }

    @Override
    public void setData(HotListBean.SubjectsBean data, int position) {
        Observable.just(data.getTitle())
                .subscribe(RxTextView.text(mName));

        mImageLoader.loadImage(mApplication, GlideImageConfig
                .builder()
                .url(data.getImages().getLarge())
                .imageView(mAvater)
                .build());
    }


    @Override
    protected void onRelease() {
        mImageLoader.clear(mApplication,GlideImageConfig.builder()
                .imageViews(mAvater)
                .build());
    }
}
