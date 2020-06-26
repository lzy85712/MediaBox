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
import android.widget.TextView;

import com.mediabox.qukuailian.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 */
public class LvBuyProdAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    private LayoutInflater mInflater;

    public LvBuyProdAdapter(ArrayList<String> datas, Context context) {
        this.mDatas = datas;
        this.mContext = context;

        mInflater = LayoutInflater.from(context);
    }


    private String str = "待我签发";

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
            convertView = mInflater.inflate(R.layout.item_lv_buy_prod, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 指定位置字符串设置颜色
        String content = holder.tv_detail.getText().toString();
        if (content.contains(str)) {
            SpannableStringBuilder spannable = new SpannableStringBuilder(content);
            int index = content.indexOf(str);
            spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#DA364A")), index, content.length()
                    , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.tv_detail.setText(spannable);
        }


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_detail)
        TextView tv_detail;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
