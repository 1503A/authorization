package com.jcc.sqs.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jcc.sqs.R;
import com.jcc.sqs.model.commitbean.CommitBean;
import com.jcc.sqs.presenter.CommitAdapter;
import com.jcc.sqs.presenter.commit_presenter.CommitPresenter;
import com.jcc.sqs.view.iview.cview.CommitView;

import java.util.ArrayList;
import java.util.List;

public class CommitActivity extends AppCompatActivity implements CommitView<CommitBean> {

    private ListView uploading2_lv;

    private List<CommitBean.DataBean.InfoBean> list;
    private List textlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading2);
//        initData();
        //测试数据
        textlist = new ArrayList<CommitBean.DataBean.InfoBean>();
        initView();

        for (int i = 0; i < 10; i++) {
            textlist.add(new CommitBean.DataBean.InfoBean(1, "张张" + i, "123456789" + i, 2, ""));

        }
    }

    private void initData() {
        CommitPresenter commit = new CommitPresenter();
        commit.attachView(this);
    }

    private void initView() {
        uploading2_lv = (ListView) findViewById(R.id.uploading2_lv);
        CommitAdapter adapter = new CommitAdapter(textlist, this);
        uploading2_lv.setAdapter(adapter);
    }

    @Override
    public void getListViewData(CommitBean o) {
        list = o.getData().getList();
    }


}
