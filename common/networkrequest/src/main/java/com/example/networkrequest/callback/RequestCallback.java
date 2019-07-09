package com.example.networkrequest.callback;

/**
 * 成功回调
 */
public interface RequestCallback<T> {

    void onSuccess(T t);

}
