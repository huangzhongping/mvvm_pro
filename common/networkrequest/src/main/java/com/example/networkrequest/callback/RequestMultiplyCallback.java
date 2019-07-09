package com.example.networkrequest.callback;


import com.example.networkrequest.exception.ApiException;

/**
 * 失败回调
 */
public interface RequestMultiplyCallback<T> extends RequestCallback<T> {

    void onError(ApiException e);

}