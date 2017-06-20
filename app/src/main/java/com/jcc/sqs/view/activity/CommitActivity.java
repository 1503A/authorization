package com.jcc.sqs.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jcc.sqs.R;
import com.jcc.sqs.model.bean.CommitBean;
import com.jcc.sqs.presenter.CommitPresenter;
import com.jcc.sqs.view.iview.CommitView;

import java.util.List;

public class CommitActivity extends AppCompatActivity implements CommitView<CommitBean> {

    private ListView uploading2_lv;
    private List<CommitBean.DataBean.ListBean> list;
    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading2);
        initData();
        initView();
        //拿到登录页传过来的token,
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
    }

    private void initData() {
        CommitPresenter commit = new CommitPresenter();
        commit.attachView(this);
        commit.getData("84dda5c04a588f57c852a4db5b939871","3","");
    }

    private void initView() {
        uploading2_lv = (ListView) findViewById(R.id.uploading2_lv);

    }

    @Override
    public void getListViewData(CommitBean commitBean) {
        list = commitBean.getData().getList();
        CommitAdapter adapter = new CommitAdapter(this);
        adapter.Getdata(list);
        uploading2_lv.setAdapter(adapter);
    }
}
