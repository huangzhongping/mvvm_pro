package com.example.livedatademo.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.networkrequest.base.BaseApplication;
import com.example.networkrequest.liveeventbus.LiveEventBus;
import com.example.networkrequest.utils.Utils;

public class MyApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (Utils.isAppDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }

}
