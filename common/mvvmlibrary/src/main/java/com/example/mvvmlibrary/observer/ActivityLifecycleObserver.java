package com.example.mvvmlibrary.observer;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;

/**
 * 观察Activity的生命周期变化
 */
public class ActivityLifecycleObserver implements LifecycleObserver {

    private static final String TAG = "ActivityObserver";

    private Context context;

    public ActivityLifecycleObserver(Context context) {
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.d(TAG, "onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.d(TAG, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.d(TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.d(TAG, "onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.d(TAG, "onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

    //任意回调都会调用它，比如调用完onCreate()后会回调这里的onCreate(),然后会回调onAny();
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        Log.d(TAG, "onAny");
    }

}
