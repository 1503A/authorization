package com.jcc.sqs.model.commitbean;

import java.util.List;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class CommitBean {

    /**
     * errMessage : Undefined index: cuid
     * msg : 未知错误
     * traceAsString : Undefined index: cuid traceAsString:#0 /home/www/app/creditReportServer/app/Http/Controllers/AppApi/ApplyController.php(97): Laravel\Lumen\Application->Laravel\Lumen\Concerns\{closure}(8, 'Undefined index...', '/home/www/app/c...', 97, Array)
     * #1 /home/www/app/creditReportServer/app/Http/Controllers/AppApi/ApplyController.php(64): App\Http\Controllers\AppApi\ApplyController->check_token()
     * #2 /home/www/app/creditReportServer/app/Http/Controllers/Controller.php(86): App\Http\Controllers\AppApi\ApplyController->getList('getList')
     * #3 [internal function]: App\Http\Controllers\Controller->processMethod('getList')
     * #4 /home/www/app/creditReportServer/vendor/illuminate/container/Container.php(507): call_user_func_array(Array, Array)
     * #5 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(603): Illuminate\Container\Container->call(Array, Array)
     * #6 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(570): Laravel\Lumen\Application->callControllerCallable(Array, Array)
     * #7 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(543): Laravel\Lumen\Application->callLumenController(Object(App\Http\Controllers\AppApi\ApplyController), 'processMethod', Array)
     * #8 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(511): Laravel\Lumen\Application->callControllerAction(Array)
     * #9 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(496): Laravel\Lumen\Application->callActionOnArrayBasedRoute(Array)
     * #10 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(466): Laravel\Lumen\Application->handleFoundRoute(Array)
     * #11 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(398): Laravel\Lumen\Application->handleDispatcherResponse(Array)
     * #12 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(643): Laravel\Lumen\Application->Laravel\Lumen\Concerns\{closure}()
     * #13 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(399): Laravel\Lumen\Application->sendThroughPipeline(Array, Object(Closure))
     * #14 /home/www/app/creditReportServer/vendor/laravel/lumen-framework/src/Concerns/RoutesRequests.php(340): Laravel\Lumen\Application->dispatch(NULL)
     * #15 /home/www/app/creditReportServer/public/index.php(29): Laravel\Lumen\Application->run()
     * #16 {main}
     * code : 901
     * status : 0
     * data : {}
     */

    private String errMessage;
    private String msg;
    private String traceAsString;
    private String code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
        private List<InfoBean> list;

        public DataBean(List<InfoBean> list) {
            this.list = list;
        }

        public List<InfoBean> getList() {
            return list;
        }

        public void setList(List<InfoBean> list) {
            this.list = list;
        }

        public static class InfoBean {
            private int applyId;
            private String customerName;
            private String IdCard;
            private int status;
            private String reason;

            public InfoBean(int applyId, String customerName, String idCard, int status, String reason) {
                this.applyId = applyId;
                this.customerName = customerName;
                IdCard = idCard;
                this.status = status;
                this.reason = reason;
            }

            public int getApplyId() {
                return applyId;
            }

            public String getCustomerName() {
                return customerName;
            }

            public String getIdCard() {
                return IdCard;
            }

            public int getStatus() {
                return status;
            }

            public String getReason() {
                return reason;
            }

            public void setApplyId(int applyId) {
                this.applyId = applyId;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public void setIdCard(String idCard) {
                IdCard = idCard;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }
        }

    }
}
