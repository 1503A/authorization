package com.jcc.sqs.model.data;

import com.jcc.sqs.model.bean.CommitBean;
import com.jcc.sqs.model.bean.LoginBean;
import com.jcc.sqs.model.bean.MsgBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public interface DataFromService {

    @FormUrlEncoded
    @POST("appapi/verify/getVerifyCode")
    Observable<MsgBean> getMsg(@FieldMap Map<String, String> options);

    @FormUrlEncoded
    @POST("appapi/verify/login")
    Observable<LoginBean> getLogin(@FieldMap Map<String, String> options);

    @FormUrlEncoded
    @POST("appapi/apply/getList")
    Observable<CommitBean> getState(@FieldMap Map<String, String> options);

}
