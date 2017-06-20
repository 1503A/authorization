package com.jcc.sqs.model.bean;

import java.util.List;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class CommitBean {
    /**
     * code : 0
     * data : {"count":1,"list":[{"IdCard":"身份证号","applyId":"申请ID","customerName":"申请人姓名","reason":"驳回申请的原因","status":"申请状态"},{"IdCard":"身份证号","applyId":"申请ID","customerName":"申请人姓名","reason":"驳回申请的原因","status":"申请状态"}],"pageid":-1}
     * msg : success
     * status : 1
     */

    private int code;
    private DataBean data;
    private String msg;
    private int status;

    @Override
    public String toString() {
        return "FieldListBean{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * count : 1
         * list : [{"IdCard":"身份证号","applyId":"申请ID","customerName":"申请人姓名","reason":"驳回申请的原因","status":"申请状态"},{"IdCard":"身份证号","applyId":"申请ID","customerName":"申请人姓名","reason":"驳回申请的原因","status":"申请状态"}]
         * pageid : -1
         */

        private int count;
        private int pageid;
        private List<ListBean> list;

        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", pageid=" + pageid +
                    ", list=" + list +
                    '}';
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPageid() {
            return pageid;
        }

        public void setPageid(int pageid) {
            this.pageid = pageid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * IdCard : 身份证号
             * applyId : 申请ID
             * customerName : 申请人姓名
             * reason : 驳回申请的原因
             * status : 申请状态
             */

            private String IdCard;
            private String applyId;
            private String customerName;
            private String reason;
            private String status;

            @Override
            public String toString() {
                return "ListBean{" +
                        "IdCard='" + IdCard + '\'' +
                        ", applyId='" + applyId + '\'' +
                        ", customerName='" + customerName + '\'' +
                        ", reason='" + reason + '\'' +
                        ", status='" + status + '\'' +
                        '}';
            }

            public String getIdCard() {
                return IdCard;
            }

            public void setIdCard(String IdCard) {
                this.IdCard = IdCard;
            }

            public String getApplyId() {
                return applyId;
            }

            public void setApplyId(String applyId) {
                this.applyId = applyId;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
