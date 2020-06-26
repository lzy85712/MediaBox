package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 */
public class LvBuyAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    private LayoutInflater mInflater;

    public LvBuyAdapter(ArrayList<String> datas, Context context) {
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
        String type = mDatas.get(position);

        if (convertView == null) {
            if (type.equals("")) {
                convertView = mInflater.inflate(R.layout.item_lv_buy_prod_type_one, parent, false);
            } else if (type.equals("type")) {
                convertView = mInflater.inflate(R.layout.item_lv_buy_prod_type_two, parent, false);
                ListView lv_sell = (ListView) convertView.findViewById(R.id.lv_sell);
                ArrayList<String> al_test = new ArrayList<>();
                al_test.add("");
                al_test.add("");
                al_test.add("");
                al_test.add("");
                lv_sell.setAdapter(new LvSellAdapter(al_test, mContext));
                MyUtils.setListViewHeightBasedOnChildren(lv_sell, mContext, null);
            }

            // convertView = mInflater.inflate(R.layout.item_lv_prod_type_one, parent, false);

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
