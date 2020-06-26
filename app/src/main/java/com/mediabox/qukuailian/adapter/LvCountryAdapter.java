package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.SelectCountryActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/3.
 */
public class LvCountryAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private int[] country_icons;
    private Context mContext;
    private int myposition;
    private SelectCountryActivity sca;

    private LayoutInflater mInflater;

    public LvCountryAdapter(ArrayList<String> datas, int[] country_icons, Context context, int position, SelectCountryActivity sca) {
        this.mDatas = datas;
        this.mContext = context;
        this.country_icons = country_icons;
        this.myposition = position;
        this.sca = sca;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_lv_country, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.tv_country.setText(mDatas.get(position));
        holder.iv_country.setImageResource(country_icons[position]);

        // 选中后返回上级页面
        holder.rb_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sca.back(position);
            }
        });

        // 显示选中的状态
        if (myposition == position) {
            holder.rb_check.setChecked(true);
        } else {
            holder.rb_check.setChecked(false);
        }

        return convertView;
    }


    static class ViewHolder {


        @BindView(R.id.tv_country)
        TextView tv_country;
        @BindView(R.id.iv_country)
        ImageView iv_country;
        @BindView(R.id.rb_check)
        RadioButton rb_check;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
