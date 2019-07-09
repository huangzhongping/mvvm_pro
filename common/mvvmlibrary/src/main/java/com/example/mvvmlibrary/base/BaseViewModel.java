package com.example.mvvmlibrary.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.networkrequest.base.BaseActionEvent;


public  class BaseViewModel<T extends BaseRepository> extends AndroidViewModel implements IViewModelAction{


    private MutableLiveData<BaseActionEvent> actionLiveData;
    protected T mRepository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mRepository = getRepository();
        actionLiveData = new MutableLiveData<>();
    }

    protected T getRepository() {
        return mRepository;
    }

    @Override
    public void showLoading() {
        BaseActionEvent baseActionEvent = new BaseActionEvent(BaseActionEvent.SHOW_LOADING_DIALOG);
        actionLiveData.setValue(baseActionEvent);
    }

    @Override
    public void dismissLoading() {
        actionLiveData.setValue(new BaseActionEvent(BaseActionEvent.DISMISS_LOADING_DIALOG));
    }

    @Override
    public void showToast(String message) {
        BaseActionEvent baseActionEvent = new BaseActionEvent(BaseActionEvent.SHOW_TOAST);
        baseActionEvent.setMessage(message);
        actionLiveData.setValue(baseActionEvent);
    }

    @Override
    public void finish() {
        actionLiveData.setValue(new BaseActionEvent(BaseActionEvent.FINISH));
    }

    @Override
    public void finishWithResultOk() {
        actionLiveData.setValue(new BaseActionEvent(BaseActionEvent.FINISH_WITH_RESULT_OK));
    }

    @Override
    public MutableLiveData<BaseActionEvent> getActionLiveData() {
        return actionLiveData;
    }
}
