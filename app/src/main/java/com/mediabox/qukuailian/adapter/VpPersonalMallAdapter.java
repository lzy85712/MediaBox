package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VpPersonalMallAdapter extends PagerAdapter {
	public Context context;
	public ArrayList<View> webViews;

	public VpPersonalMallAdapter(ArrayList<View> webViews, Context context) {
		super();
		this.context = context;
		this.webViews = webViews;
	}

	@Override
	public int getCount() {
		return webViews.size();
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
		container.addView(webViews.get(position));
		return webViews.get(position);
	}
}
