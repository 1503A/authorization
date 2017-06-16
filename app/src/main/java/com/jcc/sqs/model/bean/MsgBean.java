package com.jcc.sqs.model.bean;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public class MsgBean {


    /**
     * errMessage :
     * msg : success
     * traceAsString :
     * code : 0
     * status : 1
     * data : null
     */

    private String errMessage;
    private String msg;
    private String traceAsString;
    private int code;
    private int status;
    private Object data;

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTraceAsString() {
        return traceAsString;
    }

    public void setTraceAsString(String traceAsString) {
        this.traceAsString = traceAsString;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
