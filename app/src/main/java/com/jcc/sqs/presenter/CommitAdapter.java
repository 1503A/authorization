package com.jcc.sqs.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcc.sqs.R;
import com.jcc.sqs.model.commitbean.CommitBean;

import java.util.List;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/16
 * effect:
 */

public class CommitAdapter extends BaseAdapter {
    private List<CommitBean.DataBean.InfoBean> stateArr;
    private Context context;



    public CommitAdapter(List<CommitBean.DataBean.InfoBean> stateArr, Context context) {
        this.stateArr = stateArr;
        this.context = context;
    }

    private final int STATE_AIDIT = 1;//审核
    private final int STATE_REJECT = 3;//驳回
    private final int STATE_WAIT = 0;//等待提交
    private final int STATE_DONE = 2;//成功


    @Override
    public int getCount() {
        return stateArr.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int i = getItemViewType(position);
        ViewHodlerWait hodlerWait = null;
        ViewHodlerAidit hodlerAidit = null;
        ViewHodlerDone hodlerDone = null;
        ViewHoderReject hoderReject = null;
        if (convertView == null) {
            switch (i) {
                case 0:
                    convertView = View.inflate(context, R.layout.uploading_lv_item_wait, null);
                    hodlerWait = new ViewHodlerWait();
                    hodlerWait.wait_name = (TextView) convertView.findViewById(R.id.uploading2_item_lv_wait_name);
                    hodlerWait.wait_IDcode = (TextView) convertView.findViewById(R.id.uploading2_item_lv_wait_IDcode);
                    hodlerWait.wait_state = (TextView) convertView.findViewById(R.id.uploading2_item_lv_wait_state);
                    hodlerWait.wait_next = (ImageView) convertView.findViewById(R.id.uploading2_item_lv_wait_next);
                    convertView.setTag(hodlerWait);
                    break;
                case 1:
                    convertView = View.inflate(context, R.layout.uploading_lv_item_audit, null);
                    hodlerAidit = new ViewHodlerAidit();
                    hodlerAidit.audit_name = (TextView) convertView.findViewById(R.id.uploading2_item_lv_audit_name);
                    hodlerAidit.audit_IDcode = (TextView) convertView.findViewById(R.id.uploading2_item_lv_audit_IDcode);
                    hodlerAidit.audit_state = (TextView) convertView.findViewById(R.id.uploading2_item_lv_audit_state);
                    convertView.setTag(hodlerAidit);
                    break;
                case 2:
                    convertView = View.inflate(context, R.layout.uploading_lv_item_done, null);
                    hodlerDone = new ViewHodlerDone();
                    hodlerDone.done_name = (TextView) convertView.findViewById(R.id.uploading2_item_lv_done_name);
                    hodlerDone.done_IDdoce = (TextView) convertView.findViewById(R.id.uploading2_item_lv_done_IDdoce);
                    hodlerDone.done_state = (TextView) convertView.findViewById(R.id.uploading2_item_lv_done_state);
                    convertView.setTag(hodlerDone);
                    break;
                case 3:
                    convertView = View.inflate(context, R.layout.uploading_lv_item_reject, null);
                    hoderReject = new ViewHoderReject();
                    hoderReject.lv_name = (TextView) convertView.findViewById(R.id.uploading2_item_lv_name);
                    hoderReject.lv_IDcode = (TextView) convertView.findViewById(R.id.uploading2_item_lv_IDcode);
                    hoderReject.lv_state = (TextView) convertView.findViewById(R.id.uploading2_item_lv_state);
                    hoderReject.lv_next = (ImageView) convertView.findViewById(R.id.uploading2_item_lv_next);
                    hoderReject.lv_error = (TextView) convertView.findViewById(R.id.uploading2_item_lv_error);
                    convertView.setTag(hoderReject);
                    break;
            }
        } else {
            switch (i) {
                case 0:
                    hodlerWait = (ViewHodlerWait) convertView.getTag();
                    break;
                case 1:
                    hodlerAidit = (ViewHodlerAidit) convertView.getTag();
                    break;
                case 2:
                    hodlerDone = (ViewHodlerDone) convertView.getTag();
                    break;
                case 3:
                    hoderReject = (ViewHoderReject) convertView.getTag();
                    break;
            }

        }

        switch (i) {
            case 0:
                hodlerWait.wait_name.setText(stateArr.get(position).getCustomerName());
                hodlerWait.wait_IDcode.setText(stateArr.get(position).getIdCard());
//                hodlerWait.wait_state.setText(infoBean.getStatus()+"");
//                hodlerWait.wait_next.setText(infoBean.getStatus()+"");

                break;
            case 1:
                hodlerAidit.audit_name.setText(stateArr.get(position).getCustomerName());
                hodlerAidit.audit_IDcode.setText(stateArr.get(position).getIdCard());
//                hodlerAidit.audit_state.setText(infoBean.getCustomerName());

                break;
            case 2:
                hodlerDone.done_name.setText(stateArr.get(position).getCustomerName());
                hodlerDone.done_IDdoce.setText(stateArr.get(position).getIdCard());
                break;
            case 3:
                hoderReject.lv_name.setText(stateArr.get(position).getCustomerName());
                hoderReject.lv_IDcode.setText(stateArr.get(position).getIdCard());
                hoderReject.lv_error.setText(stateArr.get(position).getReason());
        }

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        int stateArrSelect = stateArr.get(position).getStatus();
        switch (stateArrSelect) {
            case 0:
                return STATE_WAIT;
            case 1:
                return STATE_AIDIT;
            case 2:
                return STATE_DONE;
            case 3:
                return STATE_REJECT;
        }
        return super.getItemViewType(position);
    }

    class ViewHodlerWait {
        TextView wait_name, wait_IDcode, wait_state;
        ImageView wait_next;
    }

    class ViewHodlerAidit {
        TextView audit_name, audit_IDcode, audit_state;
    }

    class ViewHodlerDone {
        TextView done_name, done_IDdoce, done_state;
    }

    class ViewHoderReject {
        TextView lv_name, lv_IDcode, lv_state, lv_error;
        ImageView lv_next;
    }
}
