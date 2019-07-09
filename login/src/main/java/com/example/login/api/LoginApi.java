package com.example.login.api;

import com.example.login.model.LoginEntity;
import com.example.login.model.RegisterCompanyEntity;
import com.example.networkrequest.base.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("dukang-user/login")
    Observable<BaseResponse<LoginEntity>> postLogin(
            @Body RequestBody requestBody
    );

    //已注册公司列表
    @GET("muscat/my_companies")
    Observable<BaseResponse<List<RegisterCompanyEntity>>> getCompanyList();

}
