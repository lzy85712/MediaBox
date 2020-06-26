package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/9.
 */
public class GvSearchResultAdapter extends BaseAdapter {
    private ArrayList<String> al_datas;
    private Context context;
    private LayoutInflater mInflater;

    public GvSearchResultAdapter(ArrayList<String> al_datas, Context context) {
        super();
        this.al_datas = al_datas;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return al_datas.size();
    }

    @Override
    public Object getItem(int position) {
        return al_datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_lv_prod_type_one, null);
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
