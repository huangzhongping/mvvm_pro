package com.example.login.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.login.model.LoginEntity;
import com.example.login.repository.LoginRepository;
import com.example.login.repository.RegisterRepository;
import com.example.mvvmlibrary.base.BaseViewModel;
import com.example.networkrequest.arouter.Constance;
import com.example.networkrequest.cache.ACache;
import com.example.networkrequest.cache.EnumKey;
import com.example.networkrequest.callback.RequestMultiplyCallback;
import com.example.networkrequest.exception.BaseException;
import com.example.networkrequest.utils.Utils;

import okhttp3.RequestBody;

public class RegisterViewModel extends BaseViewModel<RegisterRepository> {

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected RegisterRepository getRepository(){
        return new RegisterRepository(this);
    }

}
