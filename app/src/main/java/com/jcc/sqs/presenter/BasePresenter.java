package com.jcc.sqs.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.jcc.sqs.view.iview.IView;

/**
 * @ Description:
 * @ Date:2017/6/15
 * @ Author:刘刚
 */

public class BasePresenter <T extends IView> {
    private T IView;
    public  T getIView(){
        return IView;
    }
    public void attachView(T IView){
        this.IView=IView;
    }
    public void  getImageFromServer(Context context, String uri, ImageView imageView){

    }
}
