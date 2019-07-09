package com.example.networkrequest.http;

import com.example.networkrequest.BuildConfig;
import com.example.networkrequest.base.BaseResponse;
import com.example.networkrequest.exception.ApiException;
import com.example.networkrequest.exception.BaseException;
import com.example.networkrequest.interceptor.HeaderInterceptor;
import com.example.networkrequest.interceptor.SSLSocketClient;

import org.reactivestreams.Publisher;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*  网络请求
 */
public class HttpRequest {

    public static final String BASE_URL =  "https://dkdev-api.bipocloud.com/services/";

    private final Map<String, Object> serviceMap = new ConcurrentHashMap<>();
    private static final int DEFAULT_TIMEOUT = 300;

    public static HttpRequest getInstance() {
        return RetrofitHolder.httpRequest;
    }

    private static class RetrofitHolder {
        private static final HttpRequest httpRequest = new HttpRequest();
    }

    /**
     * 传入BaseUrl 创建retrofit
     * @param baseUrl
     * @return
     */
    public Retrofit createRetrofit(String baseUrl){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.addInterceptor(new HeaderInterceptor());
        //忽略证书
        builder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory());
        builder.hostnameVerifier(SSLSocketClient.getHostnameVerifier());
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }


    /**
     * 使用Observable方式，处理接口返回的结果以及code处理
     * @param <T>
     * @return
     */
    public <T> ObservableTransformer<BaseResponse<T>,T> handleObservableResult(){
        return  new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseResponse<T> result){
                        if ("0".equals(result.getErrcode())){
                            return createData(result.getData());
                        } else {
                            throw new ApiException(result.getErrcode(),result.getErrmsg());
                        }
                    }
                });
            }
        };
    }

    /**
     *  Observable方式返回的数据即是BaseRespose中的T部分
     * @param t
     * @param <T>
     * @return
     */
    private <T> Observable<T> createData(T t){
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter){
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }

    /**
     * 使用Flowable方式，处理接口返回的结果以及code处理
     * @param <T>
     * @return
     */
    public  <T> FlowableTransformer<BaseResponse<T>, T> handleFlowableResult() {
        return new FlowableTransformer<BaseResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(BaseResponse<T> result) {
                        if (result.getErrcode().equals("0")){
                            return createFlowableData(result.getData());
                        } else {
                            throw new ApiException(result.getErrcode(),result.getErrmsg());
                        }
                    }
                });
            }
        };
    }

    /**
     *  Flowable方式返回的数据即是BaseRespose中的T部分
     * @param t
     * @param <T>
     * @return
     */
    private  <T> Flowable<T> createFlowableData(T t){
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter){
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    /**
     * 动态改变BaseUrl，接口分类
     * @param clz
     * @param host
     * @param <T>
     * @return
     */
    public <T> T getRetrofitService(Class<T> clz, String host) {
        T value;
        if (serviceMap.containsKey(host)) {
            Object obj = serviceMap.get(host);
            if (obj == null) {
                value = createRetrofit(host).create(clz);
                serviceMap.put(host, value);
            } else {
                value = (T) obj;
            }
        } else {
            value = createRetrofit(host).create(clz);
            serviceMap.put(host, value);
        }
        return value;
    }

}