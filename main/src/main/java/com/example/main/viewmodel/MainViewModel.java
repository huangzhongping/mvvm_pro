package com.example.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.main.repository.MainRepository;
import com.example.mvvmlibrary.base.BaseViewModel;
import com.example.networkrequest.callback.RequestMultiplyCallback;
import com.example.networkrequest.exception.ApiException;
import com.example.networkrequest.exception.BaseException;

import java.util.Optional;


public class MainViewModel extends BaseViewModel<MainRepository> {

    private MutableLiveData<Boolean> booleanLiveData = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected MainRepository getRepository() {
        return new MainRepository(this);
    }


    //接口的请求数据以及回调
    public void getUserInfo(String mobile) {
        mRepository.requestData(mobile,new RequestMultiplyCallback<Boolean>() {

            @Override
            public void onError(ApiException e) {
                Log.e("aaa", "aaa");
            }

            @Override
            public void onSuccess(Boolean bean) {
                Log.e("aaa", "bbb");
                booleanLiveData.setValue(bean);
            }
        });
    }


    public MutableLiveData<Boolean> getBooleanMutableLiveData() {
        return booleanLiveData;
    }

}
