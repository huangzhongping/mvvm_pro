package com.example.widget.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


/**
 * 作者：wangzhihao
 * 主要功能:图片请求控件
 * 创建时间：2016/7/20 09:28
 */
public class RequestImageView extends ImageView {

    public RequestImageView(Context context) {
        super(context);
    }

    public RequestImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RequestImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RequestImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 设置错误图片
     *
     * @param url 路径
     */
    public void setError(Integer url) {
        setImageResource(url);
    }

    /**
     * 加载数据
     *
     * @param url 路径
     */
    public void setImageUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            url = "There is no picture";
        }
        if (null == this || null == this.getContext()) {
            return;
        }
        try {
            Glide.with(this.getContext()).load(url)
                    .into(this);
        } catch (Exception e) {
            Log.e("bipolite", "图片加载=" + e.getMessage());
        }
    }

}
