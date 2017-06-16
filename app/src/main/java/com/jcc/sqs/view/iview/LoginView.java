package com.jcc.sqs.view.iview;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public interface LoginView<T> extends IView {
    void getLoginViewSuc(T t);
    void getLoginViewErr(String string, int code);
}
