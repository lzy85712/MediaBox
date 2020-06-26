package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.ForwardActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 */
public class LvMessageAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    private LayoutInflater mInflater;
    // 是否显示选中框
    private boolean isEdit = false;
    // 是否全部选中的标识
    private boolean isCheckAll = false;
    //为四种布局定义一个标识
    private final int TYPE1 = 0;
    private final int TYPE2 = 1;
    private final int TYPE3 = 2;
    private final int TYPE4 = 3;



    public LvMessageAdapter(ArrayList<String> datas, Context context, boolean isEdit, boolean isCheckAll) {
        this.mDatas = datas;
        this.mContext = context;
        this.isEdit = isEdit;
        this.isCheckAll = isCheckAll;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 默认4种布局
    @Override
    public int getViewTypeCount() {
        return 4;
    }


    @Override
    public int getItemViewType(int position) {
        String type = mDatas.get(position);
        if (type.equals("type1")) {
            return TYPE1;
        } else if (type.equals("type2")) {
            return TYPE2;
        } else if (type.equals("type3")) {
            return TYPE3;
        } else if (type.equals("type4")) {
            return TYPE4;
        }
        // 都没有默认布局1
        return TYPE1;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;
        ViewHolder4 holder4 = null;

        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE1:
                    convertView = mInflater.inflate(R.layout.item_lv_message_type_one, null, false);
                    holder1 = new ViewHolder1(convertView);
                    convertView.setTag(holder1);
                    break;
                case TYPE2:
                    convertView = mInflater.inflate(R.layout.item_lv_message_type_two, null, false);
                    holder2 = new ViewHolder2(convertView);
                    convertView.setTag(holder2);
                    break;
                case TYPE3:
                    convertView = mInflater.inflate(R.layout.item_lv_message_type_three, null, false);
                    holder3 = new ViewHolder3(convertView);
                    convertView.setTag(holder3);
                    break;
                case TYPE4:
                    convertView = mInflater.inflate(R.layout.item_lv_message_type_four, null, false);
                    holder4 = new ViewHolder4(convertView);
                    convertView.setTag(holder4);
                    break;
            }
        } else {
            switch (type) {
                case TYPE1:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE2:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
                case TYPE3:
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
                case TYPE4:
                    holder4 = (ViewHolder4) convertView.getTag();
                    break;
            }
        }

        //为布局设置数据
        switch (type) {
            case TYPE1:
                if (isEdit) {
                    holder1.cb_check.setVisibility(View.VISIBLE);
                    if (isCheckAll) {
                        holder1.cb_check.setChecked(true);
                    } else {
                        holder1.cb_check.setChecked(false);
                    }
                }
                break;
            case TYPE2:
                if (isEdit) {
                    holder2.cb_check.setVisibility(View.VISIBLE);
                    if (isCheckAll) {
                        holder2.cb_check.setChecked(true);
                    } else {
                        holder2.cb_check.setChecked(false);
                    }
                }
                break;
            case TYPE3:
                if (isEdit) {
                    holder3.cb_check.setVisibility(View.VISIBLE);
                    if (isCheckAll) {
                        holder3.cb_check.setChecked(true);
                    } else {
                        holder3.cb_check.setChecked(false);
                    }
                }
                break;
            case TYPE4:
                if (isEdit) {
                    holder4.cb_check.setVisibility(View.VISIBLE);
                    if (isCheckAll) {
                        holder4.cb_check.setChecked(true);
                    } else {
                        holder4.cb_check.setChecked(false);
                    }
                }
        }


        return convertView;
    }

    static class ViewHolder1 {
        @BindView(R.id.cb_check)
        CheckBox cb_check;

        public ViewHolder1(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder2 {
        @BindView(R.id.cb_check)
        CheckBox cb_check;

        public ViewHolder2(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder3 {
        @BindView(R.id.cb_check)
        CheckBox cb_check;

        public ViewHolder3(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder4 {
        @BindView(R.id.cb_check)
        CheckBox cb_check;

        public ViewHolder4(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
