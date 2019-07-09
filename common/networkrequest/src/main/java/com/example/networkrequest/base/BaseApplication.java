package com.example.networkrequest.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.networkrequest.liveeventbus.LiveEventBus;
import com.example.networkrequest.utils.ClassUtils;
import com.example.networkrequest.utils.Utils;

import java.util.List;


/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 * @name BaseApplication
 */
public class BaseApplication extends Application {

    public static final String ROOT_PACKAGE = "com.example.networkrequest";
    private static BaseApplication sInstance;

    private List<ApplicationDelegate> mAppDelegateList;


    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Utils.init(this);
        LiveEventBus.get()
                .config()
                .supportBroadcast(this)
                .lifecycleObserverAlwaysActive(true)
                .autoClear(false);

        if (Utils.isAppDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, ApplicationDelegate.class, ROOT_PACKAGE);
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
        ARouter.getInstance().destroy();
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (ApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}
