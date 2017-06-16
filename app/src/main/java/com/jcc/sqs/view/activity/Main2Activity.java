package com.jcc.sqs.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcc.sqs.R;
import com.jcc.sqs.model.bean.LoginBean;
import com.jcc.sqs.model.bean.MsgBean;
import com.jcc.sqs.presenter.LoginPresenter;
import com.jcc.sqs.presenter.MsgPresenter;
import com.jcc.sqs.view.iview.LoginView;
import com.jcc.sqs.view.iview.MsgView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener,MsgView<MsgBean>,LoginView<LoginBean> {

    private EditText edit_phone;
    private EditText edit_yzm;
    private Button bt_yzm;
    private MsgPresenter mPresenter;
    private Button bt_login;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        intiData();
    }

    private void intiData() {
        mPresenter = new MsgPresenter();
        mPresenter.attachView(this);
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.attachView(this);
    }

    private void initView() {
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        edit_yzm = (EditText) findViewById(R.id.edit_yzm);
        bt_yzm = (Button) findViewById(R.id.bt_yzm);
        bt_login = (Button) findViewById(R.id.bt_login);


        bt_yzm.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_yzm:
                mPresenter.getMsgData(edit_phone.getText().toString().trim());
                break;
            case R.id.bt_login:
                mLoginPresenter.getLoginData(edit_phone.getText().toString().trim(),"123456");
                break;
        }
    }



    @Override
    public void getLoginViewSuc(LoginBean o) {
        String token = o.getData().getUserinfo().getToken();
      // int status = o.getStatus();
        Toast.makeText(Main2Activity.this, "登录成功"+token, Toast.LENGTH_SHORT).show();
        Log.d("zzz",token);
    }

    @Override
    public void getLoginViewErr(String string, int code) {

    }

    @Override
    public void getMsgSuc(MsgBean o) {
        String value = o.getMsg().toString();
        Toast.makeText(Main2Activity.this, "获取成功"+value, Toast.LENGTH_SHORT).show();
        edit_yzm.setText(value+"");
    }

    @Override
    public void getMsgErr(String str, int code) {

    }
}
