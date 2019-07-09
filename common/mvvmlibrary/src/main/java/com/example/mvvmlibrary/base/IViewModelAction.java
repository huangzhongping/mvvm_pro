package com.example.mvvmlibrary.base;

import android.arch.lifecycle.MutableLiveData;

import com.example.networkrequest.base.BaseActionEvent;


/**
 *
 */
public interface IViewModelAction {

    void showLoading();

    void dismissLoading();

    void showToast(String message);

    void finish();

    void finishWithResultOk();

    MutableLiveData<BaseActionEvent> getActionLiveData();

}