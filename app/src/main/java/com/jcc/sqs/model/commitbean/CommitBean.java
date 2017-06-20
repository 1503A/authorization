package com.jcc.sqs.model.commitbean;

import java.util.List;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class CommitBean {

    /**
     * pageid : -1
     * count : 1
     * list : [{"applyId":1,"customerName":"1","IdCard":"1","status":1,"reason":""}]
     */

    private int pageid;
    private int count;
    private List<ListBean> list;

    public int getPageid() {
        return pageid;
    }

    public void setPageid(int pageid) {
        this.pageid = pageid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * applyId : 1
         * customerName : 1
         * IdCard : 1
         * status : 1
         * reason :
         */

        private int applyId;
        private String customerName;
        private String IdCard;
        private int status;
        private String reason;

        public int getApplyId() {
            return applyId;
        }

        public void setApplyId(int applyId) {
            this.applyId = applyId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getIdCard() {
            return IdCard;
        }

        public void setIdCard(String IdCard) {
            this.IdCard = IdCard;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

}
