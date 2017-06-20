package com.jcc.sqs.presenter;

import com.jcc.sqs.model.bean.CommitBean;
import com.jcc.sqs.model.utils.HttpUtils;
import com.jcc.sqs.view.iview.CommitView;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class CommitPresenter extends BasePresenter<CommitView> {

    public <T> void getData(String token,String cuid,String pageid) {
        HttpUtils.getState(token,cuid,pageid, new HttpUtils.CallBackDataF<CommitBean>() {
            @Override
            public void callbackF(CommitBean commitBean) {
                getIView().getListViewData(commitBean);
            }
        });
    }
}
