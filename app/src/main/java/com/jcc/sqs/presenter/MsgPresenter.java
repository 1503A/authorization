package com.jcc.sqs.presenter;

import com.jcc.sqs.model.bean.MsgBean;
import com.jcc.sqs.model.utils.HttpUtils;
import com.jcc.sqs.view.iview.MsgView;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public class MsgPresenter extends  BasePresenter<MsgView> {

    public <T> void  getMsgData(String phone){
        HttpUtils.getMsgData(phone, new HttpUtils.CallBackDataF<MsgBean>() {
            @Override
            public void callbackF(MsgBean o) {
                if (o.getCode()==0){
                    getIView().getMsgSuc(o);
                }else {
                    getIView().getMsgErr("获取失败",400);
                }
            }
        });
    }
}
