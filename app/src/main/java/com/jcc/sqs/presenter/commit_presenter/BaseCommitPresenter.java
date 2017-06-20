package com.jcc.sqs.presenter.commit_presenter;

import com.jcc.sqs.view.iview.cview.Cview;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class BaseCommitPresenter<T extends Cview> {
        private T Cview;
    public T getView(){
        return Cview;
    }
    public void attachView(T cview){
        this.Cview=cview;
    }
}
