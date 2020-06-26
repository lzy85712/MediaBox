package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by lizhaoyong on 2018/7/9.
 */
public class MarketVpAdapter extends PagerAdapter{
    public Context context;
    public ArrayList<View> Views;

    public MarketVpAdapter(ArrayList<View> Views, Context context) {
        super();
        this.context = context;
        this.Views = Views;
    }

    @Override
    public int getCount() {
        return Views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(Views.get(position));
        return Views.get(position);
    }
}
