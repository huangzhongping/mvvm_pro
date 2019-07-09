package com.example.login.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.login.R;
import com.example.login.viewmodel.LoginAndRegisterViewModel;
import com.example.mvvmlibrary.base.BaseActivity;
import com.example.networkrequest.arouter.Constance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

@Route(path = Constance.ACTIVITY_URL_LOGIN_REGISTER)
public class LoginAndRegisterActivity extends BaseActivity<LoginAndRegisterViewModel> {

    @Override
    protected LoginAndRegisterViewModel getViewModel() {
        return ViewModelProviders.of(this).get(LoginAndRegisterViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);

        /**
         * RxJava2 操作符
         * 1:创建操作符
         * 1.1create
         */
        //创建一个被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try{
                    emitter.onNext("Hello");
                    emitter.onComplete();
                }catch (Exception e){
                   emitter.onError(e);
                }

            }
        });

        //创建一个观察者
        Observer observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e("Rxjava", s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e("Rxjava", "onComplete");
            }
        };

        //订阅
        observable.subscribe(observer);

        /**
         * 1.2 just
         */
        Observable
                .just(1,2,3)
                .subscribe(new Observer<Integer>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        /**
         * 1.3 from操作符
         * 1.3.1 fromArray
         */
        Integer array[] = {1,2,3};
        Observable.fromArray(array).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //1.3.2 fromCallable
        Observable.fromCallable(new Callable<Integer>(){

            @Override
            public Integer call() throws Exception {
                return null;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });

        //1.3.3 fromFuture
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        });
        Observable.fromFuture(futureTask).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                futureTask.run();
            }
        }).subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {

            }
        });
        //1.3.4fromIterable
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Observable.fromIterable(list).subscribe(new Observer<Integer>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Integer i = 100;
        Integer finalI = i;
        Observable<Integer> observable1 = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(finalI);
            }
        });
        i = 200;
        Observer observer1 = new Observer<Integer>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable1.subscribe(observer1);
        i = 300;
        observable1.subscribe(observer1);


        Observable.timer(1, TimeUnit.SECONDS).subscribe(new Observer<Long>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.interval(4, TimeUnit.SECONDS).subscribe(new Observer<Long>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable
                .intervalRange(1, 5, 1, 10, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Observable.range(1, 5).subscribe(new Observer<Integer>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Observable.rangeLong(1, 5).subscribe(new Observer<Long>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        //empty()直接发送onComplete事件
        Observable.empty().subscribe(new Observer<Object>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //never()不发送任何事件
        Observable.never().subscribe(new Observer<Object>(){
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //error()直接发送onError()事件
        Observable.error(new Callable<Throwable>() {
            @Override
            public Throwable call() throws Exception {
                return null;
            }
        }).subscribe(new Observer<Object>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        /**
         * 转换操作符
         */
        Observable.just(1,2,3)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "" + integer;
                    }
                })
                .subscribe(new Observer<String>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("RxJava", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Observable.just(1,2,3).groupBy(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return null;
            }
        }).subscribe(new Observer<GroupedObservable<Integer,Integer>>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                integerIntegerGroupedObservable.subscribe(new Observer<Integer>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        /**
         * 看到当在 onNext() 方法进行取消订阅操作后，doOnDispose() 和 doOnLifecycle() 都会被回调。
         * 使用 doOnLifecycle 进行取消订阅, doOnDispose Action 和 doOnLifecycle Action 都没有被回调。
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

            }
        }).doOnLifecycle(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                //使用 doOnLifecycle 进行取消订阅, doOnDispose Action 和 doOnLifecycle Action 都没有被回调。
                disposable.dispose();

            }
        }, new Action() {
            @Override
            public void run() throws Exception {

            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {

            }
        }).subscribe(new Observer<Integer>(){

            private Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                this.disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                //看到当在 onNext() 方法进行取消订阅操作后，doOnDispose() 和 doOnLifecycle() 都会被回调。
                disposable.dispose();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        /**
         * subscribeOn():指定被观察者的线程，多次调用此方法，只有第一次有效
         * observeOn():指定观察者的线程，每指定一次就会生效一次
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.computation())
          .observeOn(Schedulers.newThread())  //新线程
          .observeOn(Schedulers.io()) //用于IO密集型任务
          .observeOn(Schedulers.computation()) //使用计算任务
          .observeOn(AndroidSchedulers.mainThread())//Android 的UI线程，用于操作UI
          .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }
}
