package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 */
public class LvProdAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    //为四种布局定义一个标识
    private final int TYPE1 = 0;
    private final int TYPE2 = 1;

    private LayoutInflater mInflater;

    public LvProdAdapter(ArrayList<String> datas, Context context) {
        this.mDatas = datas;
        this.mContext = context;

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

    // 默认2种布局
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
        }
        // 都没有默认布局1
        return TYPE1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;

        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE1:
                    convertView = mInflater.inflate(R.layout.item_lv_prod_type_one, null, false);
                    holder1 = new ViewHolder1(convertView);
                    convertView.setTag(holder1);
                    break;
                case TYPE2:
                    convertView = mInflater.inflate(R.layout.item_lv_prod_type_two, null, false);
                    holder2 = new ViewHolder2(convertView);
                    convertView.setTag(holder2);
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
            }
        }
        return convertView;
    }

    static class ViewHolder1 {


        public ViewHolder1(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder2 {


        public ViewHolder2(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
