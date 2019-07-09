package com.example.mvvmlibrary.base;

import com.example.networkrequest.base.BaseObserver;
import com.example.networkrequest.base.BaseResponse;
import com.example.networkrequest.base.BaseSubscriber;
import com.example.networkrequest.callback.RequestCallback;
import com.example.networkrequest.http.HttpRequest;
import org.reactivestreams.Subscriber;
import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;


public abstract class BaseRepository{

    public CompositeDisposable compositeDisposable;
    private BaseViewModel baseViewModel;
    public BaseRepository(BaseViewModel baseViewModel) {
        this.compositeDisposable = new CompositeDisposable();
        this.baseViewModel = baseViewModel;
    }


    public <T> T getApi(Class<T> clz) {
        return HttpRequest.getInstance().getRetrofitService(clz,HttpRequest.BASE_URL);
    }

    /**
     * Observable方式 有进度条网络请求
     * @param observable
     * @param callback
     */
    protected <T> void execute(Observable observable, RequestCallback<T> callback) {
        execute(observable, new BaseObserver<>(callback),true);
    }

    /**
     * Observable方式 无进度条网络请求
     * @param observable
     * @param callback
     * @param <T>
     */
    public <T> void executeQuietly(Observable observable, RequestCallback<T> callback) {
        executeQuietly(observable, new BaseObserver<>(callback));
    }

    /**
     * Flowable方式 有进度条网络请求
     * @param flowable
     * @param callback
     * @param <T>
     */
    protected <T> void executeFlowable(Flowable flowable, RequestCallback<T> callback) {
        executeFlowable(flowable, new BaseSubscriber<>(callback),true);
    }

    /**
     * Flowable方式 无进度条网络请求
     * @param flowable
     * @param callback
     * @param <T>
     */
    protected <T> void executeFlowableQuietly(Flowable flowable, RequestCallback<T> callback) {
        executeFlowableQuietly(flowable, new BaseSubscriber<>(callback));
    }

    /**
     * Observable 含有对话框的请求
     * @param observable
     * @param observer
     * @param isDismiss
     */
    private void execute(Observable observable, Observer observer, boolean isDismiss) {
        Disposable disposable = (Disposable) observable
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(applyObservableSchedulers())
                .compose(loadingTransformer(isDismiss))
                .subscribeWith(observer);
        addDisposable(disposable);
    }

    /**
     * Observable 没有对话框的请求
     * @param observable
     * @param observer
     */
    private void executeQuietly(Observable observable, Observer observer) {
        Disposable disposable = (Disposable)
                observable
                        .throttleFirst(500, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(applyObservableSchedulers())
                        .subscribeWith(observer);
        addDisposable(disposable);
    }

    /**
     * Flowable 含有对话框的请求
     * @param flowable
     * @param subscriber
     * @param isDismiss
     */
    private void executeFlowable(Flowable flowable, Subscriber subscriber, boolean isDismiss) {
        Disposable disposable = (Disposable) flowable
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(applyFlowableSchedulers())
                .compose(loadingFlowableTransformer(isDismiss))
                .subscribeWith(subscriber);
        addDisposable(disposable);
    }

    /**
     * Flowable 没有对话框的请求
     * @param flowable
     * @param subscriber
     */
    private void executeFlowableQuietly(Flowable flowable, Subscriber subscriber) {
        Disposable disposable = (Disposable)
                flowable.throttleFirst(500, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(applyFlowableSchedulers())
                        .subscribeWith(subscriber);
        addDisposable(disposable);
    }

    private <T> ObservableTransformer<T, T> loadingTransformer(boolean isDismiss) {
        return observable -> observable
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> showLoading())
                .doFinally((Action) () -> {
                    if (isDismiss) {
                        dismissLoading();
                    }
                });
    }

    private <T> FlowableTransformer<T, T> loadingFlowableTransformer(boolean isDismiss) {
        return flowable -> flowable
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> showLoading())
                .doFinally((Action) () -> {
                    if (isDismiss) {
                        dismissLoading();
                    }
                });
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }


    private void showLoading() {
        if (baseViewModel != null){
            baseViewModel.showLoading();
        }
    }

    private void dismissLoading() {
        if (baseViewModel != null) {
            baseViewModel.dismissLoading();
        }
    }

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    private <T> ObservableTransformer<BaseResponse<T>, T> applyObservableSchedulers() {
        return  HttpRequest.getInstance().handleObservableResult();
    }

    private <T> FlowableTransformer<BaseResponse<T>, T> applyFlowableSchedulers() {
        return  HttpRequest.getInstance().handleFlowableResult();
    }

}
