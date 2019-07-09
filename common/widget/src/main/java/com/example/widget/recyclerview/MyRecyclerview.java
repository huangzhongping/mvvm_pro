package com.example.widget.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MyRecyclerview extends RecyclerView {
    public MyRecyclerview(Context context) {
        super(context);
    }

    public MyRecyclerview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerview(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int h = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, h);
    }
}