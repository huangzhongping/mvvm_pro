package com.example.widget.selfdefinedtextview;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class DefinedTextView extends TextView {
    public DefinedTextView(Context context) {
        super(context);
    }

    public DefinedTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DefinedTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLeftDrawable(@DrawableRes int leftRes){
        setCompoundDrawablesWithIntrinsicBounds(leftRes,0,0,0);
    }

    public void setRightDrawable(@DrawableRes int rightRes){
        setCompoundDrawablesWithIntrinsicBounds(0,0,rightRes,0);
    }

    public void setTopDrawable(@DrawableRes int topRes){
        setCompoundDrawablesWithIntrinsicBounds(0,topRes,0,0);
    }

    public void setBottomDrawable(@DrawableRes int bottomRes){
        setCompoundDrawablesWithIntrinsicBounds(0,0,0,bottomRes);
    }
}
