package com.example.login.repository;

import com.example.login.api.LoginApi;
import com.example.login.model.RegisterCompanyEntity;
import com.example.mvvmlibrary.base.BaseRepository;
import com.example.mvvmlibrary.base.BaseViewModel;
import com.example.networkrequest.callback.RequestCallback;

import java.util.List;

public class ChooseCompanyRepository extends BaseRepository {
    public ChooseCompanyRepository(BaseViewModel baseViewModel) {
        super(baseViewModel);
    }

    /**
     * 获取公司列表
     */
    public void getCompanyList(RequestCallback<List<RegisterCompanyEntity>> callback) {
        execute(getApi(LoginApi.class).getCompanyList(),callback);
    }
}
