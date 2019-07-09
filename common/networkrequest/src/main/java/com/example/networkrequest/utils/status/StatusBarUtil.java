package com.example.networkrequest.utils.status;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.networkrequest.R;

import java.util.concurrent.atomic.AtomicInteger;

public class StatusBarUtil {
    //设置Activity对应的顶部状态栏的颜色
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
                View fakeStatusBarView = decorView.findViewById(R.id.statusbar);
                if (fakeStatusBarView != null) {
                    if (fakeStatusBarView.getVisibility() == View.GONE) {
                        fakeStatusBarView.setVisibility(View.VISIBLE);
                    }
                    fakeStatusBarView.setBackgroundColor(ContextCompat.getColor(activity, colorResId));
                } else {
                    decorView.addView(createStatusBarView(activity, ContextCompat.getColor(activity, colorResId)));
                }
//                setRootView(activity,ContextCompat.getColor(activity, colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDialogWindowStatusBarColor(Dialog activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getContext().getResources().getColor(colorResId));
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
                View fakeStatusBarView = decorView.findViewById(R.id.statusbar);
                if (fakeStatusBarView != null) {
                    if (fakeStatusBarView.getVisibility() == View.GONE) {
                        fakeStatusBarView.setVisibility(View.VISIBLE);
                    }
                    fakeStatusBarView.setBackgroundColor(ContextCompat.getColor(activity.getContext(), colorResId));
                } else {
                    decorView.addView(createStatusBarView(activity.getOwnerActivity(), ContextCompat.getColor(activity.getContext(), colorResId)));
                }
//                setRootView(activity,ContextCompat.getColor(activity, colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void setRootView(Activity activity, int color) {
        ViewGroup decorViewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View statusBarView = new View(activity.getWindow().getContext());
        int statusBarHeight = getStatusBarHeight(activity.getWindow().getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, statusBarHeight);
        params.gravity = Gravity.TOP;
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(color);
        decorViewGroup.addView(statusBarView);
    }

    private static View createStatusBarView(Activity activity, @ColorInt int color/*, int alpha*/) {
        // 绘制一个和状态栏一样高的矩形
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(color);
        statusBarView.setId(/*generateViewId()*/R.id.statusbar);
        return statusBarView;
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }

        transparentStatusBar(activity);
    }

    private static void transparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
    private static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    //设置Dialog对应的顶部状态栏的颜色
    public static void setWindowStatusBarColor(Dialog dialog, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = dialog.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(dialog.getContext().getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
