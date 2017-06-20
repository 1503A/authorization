package com.jcc.sqs.presenter;

import com.jcc.sqs.model.bean.LoginBean;
import com.jcc.sqs.model.utils.HttpUtils;
import com.jcc.sqs.view.iview.LoginView;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public class LoginPresenter extends BasePresenter<LoginView>{
    public <T>  void getLoginData(String phone,String msg){
        HttpUtils.getLoginData(phone, msg, new HttpUtils.CallBackDataF<LoginBean>() {
            @Override
            public void callbackF(LoginBean o) {
                if (o.getCode()==0){
                    getIView().getLoginViewSuc(o);
                }else {
                    getIView().getLoginViewErr("登录失败",400);
                }
            }
        });
    }
}
