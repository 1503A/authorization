package com.jcc.sqs.model.commit_utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jcc.sqs.BuildConfig;
import com.jcc.sqs.model.commitbean.CommitBean;
import com.jcc.sqs.model.commitdata.CommitDataFromService;

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
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class CommitHttpUtils {
    /**
     * 创建Retrofit
     */
    public static Retrofit create(String commiturl) {
        //创建okhttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //读取超时
        builder.readTimeout(10, TimeUnit.SECONDS);
        //链接超时
        builder.connectTimeout(10, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            //创建拦截器
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        /*
        * 返回retrofit
        * */
        return new Retrofit.Builder()
                .baseUrl(commiturl)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static void getState(String token, final CallBackState callstate) {
        //获得Retrofit的对象
        Retrofit retrofit = create(CommitUrlUtils.COMMITURL);
        //代理者模式获得对象
        CommitDataFromService service = retrofit.create(CommitDataFromService.class);
        //实例化map
        Map map = new HashMap<String, String>();
        map.put("token","token");
        map.put("pageid",1);
        map.put("cuide",4);
        service.getState(map).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CommitBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommitBean value) {
                        callstate.callState(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public interface CallBackState<T> {
        void callState(T t);
    }

}
