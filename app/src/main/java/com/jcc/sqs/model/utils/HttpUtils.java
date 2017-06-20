package com.jcc.sqs.model.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jcc.sqs.BuildConfig;
import com.jcc.sqs.model.bean.CommitBean;
import com.jcc.sqs.model.bean.LoginBean;
import com.jcc.sqs.model.bean.MsgBean;
import com.jcc.sqs.model.data.DataFromService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public class HttpUtils {

    public static Retrofit create(String url) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(9, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }

    public static void getMsgData(String phone, final CallBackDataF callBackDataF) {
        Retrofit retrofit = create(UrLUtils.path);
        DataFromService service = retrofit.create(DataFromService.class);
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        service.getMsg(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MsgBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MsgBean value) {
                        callBackDataF.callbackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public static void getLoginData(String phone, String msg, final CallBackDataF callBackDataF) {
        Retrofit retrofit = create(UrLUtils.path);
        DataFromService service = retrofit.create(DataFromService.class);
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("verifyCode", msg);
        service.getLogin(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
                        callBackDataF.callbackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                })
        ;
    }

    public static void getState(String token, String cuid, String pageid, final CallBackDataF callBackDataF) {
        //获得Retrofit的对象
        Retrofit retrofit = create(UrLUtils.path);
        //代理者模式获得对象
        DataFromService service = retrofit.create(DataFromService.class);
//        Log.d("service",service.toString());
        //实例化map
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("cuid", cuid);
        map.put("pageid", pageid);
        service.getState(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CommitBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommitBean value) {
//                        Log.d("CommitHttpUtils", value.toString());
                        callBackDataF.callbackF(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public interface CallBackDataF<T> {
        void callbackF(T t);
    }
}
