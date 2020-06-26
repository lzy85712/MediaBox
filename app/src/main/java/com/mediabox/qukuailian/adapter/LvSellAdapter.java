package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mediabox.qukuailian.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 */
public class LvSellAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    private LayoutInflater mInflater;

    public LvSellAdapter(ArrayList<String> datas, Context context) {
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


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_lv_sell, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    static class ViewHolder {

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
