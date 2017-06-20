package com.jcc.sqs.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcc.sqs.R;
import com.jcc.sqs.model.commitbean.CommitBean;

import java.util.ArrayList;
import java.util.List;

/**
 * autohor:谢兴张(asus)
 * date:2017/6/20
 * effect:
 */

public class CommitAdapter extends BaseAdapter {
    private Context context;
    private List<CommitBean.ListBean> list = new ArrayList<>();


    public CommitAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.activity_message_reject, null);
            holder = new viewHolder();
            holder.idText = (TextView) convertView.findViewById(R.id.idCardText_Message_reject);
            holder.nameText = (TextView) convertView.findViewById(R.id.nameText_Message_reject);
            holder.stateText = (TextView) convertView.findViewById(R.id.stateText_Message_reject);
            holder.rejecText_rejec = (TextView) convertView.findViewById(R.id.rejectText_Message_reject);
            holder.stateImage = (ImageView) convertView.findViewById(R.id.Image_Message_reject);
            convertView.setTag(holder);

        } else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.nameText.setText(list.get(position).getCustomerName());
        holder.idText.setText(list.get(position).getIdCard());
        int status = list.get(position).getStatus();
        if (status == 0) {
            holder.stateImage.setVisibility(View.VISIBLE);
            holder.stateText.setText("等待");
        } else if (status == 1) {
            holder.stateText.setText("审核中");
        } else if (status == 2) {
            holder.stateText.setText("成功");
        } else if (status == 3) {
            holder.stateText.setText("驳回");
            holder.stateImage.setVisibility(View.VISIBLE);
            holder.rejecText_rejec.setVisibility(View.VISIBLE);
            holder.rejecText_rejec.setText(list.get(position).getReason());
            holder.stateText.setTextColor(Color.RED);
        }

        return convertView;
    }

    public void Getdata(List<CommitBean.ListBean> list) {
        if (list != null) {
            this.list = list;
//            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }


}

class viewHolder {
    TextView nameText;
    TextView idText;
    TextView stateText;
    TextView rejecText_rejec;
    ImageView stateImage;
}

