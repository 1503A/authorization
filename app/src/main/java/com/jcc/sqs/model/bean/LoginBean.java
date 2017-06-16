package com.jcc.sqs.model.bean;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public class LoginBean {


    /**
     * errMessage :
     * msg : success
     * traceAsString :
     * code : 0
     * status : 1
     * data : {"userinfo":{"token":"7168393d47abcd7d510696dc099471c6","cuid":1}}
     */

    private String errMessage;
    private String msg;
    private String traceAsString;
    private int code;
    private int status;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userinfo : {"token":"7168393d47abcd7d510696dc099471c6","cuid":1}
         */

        private UserinfoBean userinfo;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public static class UserinfoBean {
            /**
             * token : 7168393d47abcd7d510696dc099471c6
             * cuid : 1
             */

            private String token;
            private int cuid;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public int getCuid() {
                return cuid;
            }

            public void setCuid(int cuid) {
                this.cuid = cuid;
            }
        }
    }
}
