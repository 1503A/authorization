package com.jcc.sqs.view.iview;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public interface MsgView <T>extends IView {
    void  getMsgSuc(T t);
    void  getMsgErr(String str, int code);
}
