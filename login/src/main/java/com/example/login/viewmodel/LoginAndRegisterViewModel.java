package com.example.login.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.login.repository.LoginAndRegisterRepository;
import com.example.login.repository.RegisterRepository;
import com.example.mvvmlibrary.base.BaseViewModel;

public class LoginAndRegisterViewModel extends BaseViewModel<LoginAndRegisterRepository> {

    public LoginAndRegisterViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected LoginAndRegisterRepository getRepository(){
        return new LoginAndRegisterRepository(this);
    }

}
