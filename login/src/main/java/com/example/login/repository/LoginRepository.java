package com.example.login.repository;

import com.example.login.api.LoginApi;
import com.example.login.model.LoginEntity;
import com.example.mvvmlibrary.base.BaseRepository;
import com.example.mvvmlibrary.base.BaseViewModel;
import com.example.networkrequest.callback.RequestCallback;

import okhttp3.RequestBody;

public class LoginRepository extends BaseRepository {
    public LoginRepository(BaseViewModel baseViewModel) {
        super(baseViewModel);
    }

    /**
     * 请求接口-登录
     */
    public void postLogin(RequestBody body, RequestCallback<LoginEntity> callback) {
        executeQuietly(getApi(LoginApi.class).postLogin(body),callback);
    }
}
