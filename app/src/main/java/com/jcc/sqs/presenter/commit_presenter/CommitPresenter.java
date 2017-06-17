package com.jcc.sqs.presenter.commit_presenter;

import com.jcc.sqs.model.commit_utils.CommitHttpUtils;
import com.jcc.sqs.model.commitbean.CommitBean;
import com.jcc.sqs.view.iview.cview.CommitView;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class CommitPresenter extends BaseCommitPresenter<CommitView> {

    public <T> void getData(String token) {
        CommitHttpUtils.getState(token, new CommitHttpUtils.CallBackState<CommitBean>() {
            @Override
            public void callState(CommitBean o) {
                getView().getListViewData(o);
            }
        });
    }
}
