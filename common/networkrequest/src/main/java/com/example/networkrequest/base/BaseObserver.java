package com.example.networkrequest.base;

import android.text.TextUtils;

import com.example.networkrequest.callback.RequestCallback;
import com.example.networkrequest.callback.RequestMultiplyCallback;
import com.example.networkrequest.exception.ApiException;
import com.example.networkrequest.exception.BaseException;
import com.example.networkrequest.exception.NetworkConnectionException;
import com.example.networkrequest.utils.CommonUtils;
import com.example.networkrequest.utils.ToastUtil;
import com.example.networkrequest.utils.Utils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;

/**
 *
 */
public class BaseObserver<T> extends DisposableObserver<T> {

    private RequestCallback<T> requestCallback;

    public BaseObserver(RequestCallback<T> requestCallback) {
        this.requestCallback = requestCallback;
    }

    @Override
    public void onNext(T t) {
        if (requestCallback != null) {
            requestCallback.onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (requestCallback instanceof RequestMultiplyCallback) {
            RequestMultiplyCallback callback = (RequestMultiplyCallback) requestCallback;

            if (e instanceof SocketTimeoutException) {
                CommonUtils.showShortToast(Utils.getContext(), "网络状态不佳，请稍后重试");
            } else if (e instanceof ConnectException) {
                CommonUtils.showShortToast(Utils.getContext(), "网络状态不佳，请稍后重试");
            } else if (e instanceof NetworkConnectionException) {
                CommonUtils.showShortToast(Utils.getContext(), "网络状态不佳，请稍后重试");
            } else if (e instanceof ApiException) {
                if(TextUtils.isEmpty(((ApiException) e).getErrmsg())){
                    callback.onError((ApiException) e);
                }else{
                    ToastUtil.showToast(((ApiException) e).getErrmsg());
                }
            }

        }
    }

    @Override
    public void onComplete() {

    }

}