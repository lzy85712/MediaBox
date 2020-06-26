package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 */
public class LvNoSignAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    private LayoutInflater mInflater;

    public LvNoSignAdapter(ArrayList<String> datas, Context context) {
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
            convertView = mInflater.inflate(R.layout.item_lv_no_sign, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        ArrayList<String> al_test = new ArrayList<>();
        al_test.add("");
        al_test.add("");
        al_test.add("");
        holder.lv_no_sign_detail.setAdapter(new LvNoSignDetailAdapter(al_test, mContext));
        MyUtils.setListViewHeightBasedOnChildren(holder.lv_no_sign_detail, mContext, null);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.lv_no_sign_detail)
        ListView lv_no_sign_detail;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
