package com.example.main.api;

import com.example.networkrequest.base.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApiService {

    @GET("dukang-user/users/mobile_check")
    Observable<BaseResponse<Boolean>> getUserMobileCheck(
            @Query("country_code") String country_code,
            @Query("mobile_number") String mobile_number
    );

}
