package com.jcc.sqs.model.commitdata;

import com.jcc.sqs.model.commitbean.CommitBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public interface CommitDataFromService {
    @FormUrlEncoded
    @POST("appapi/apply/getList")
    Observable<CommitBean> getState(@FieldMap Map<String, String> options);
}
