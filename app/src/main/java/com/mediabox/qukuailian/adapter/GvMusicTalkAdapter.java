package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mediabox.qukuailian.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/9.
 */
public class GvMusicTalkAdapter extends BaseAdapter {
    private ArrayList<String> al_datas;
    private int[] arr_test_pic;
    private Context context;
    private LayoutInflater mInflater;

    public GvMusicTalkAdapter(ArrayList<String> al_datas, Context context,int[] arr_test_pic) {
        super();
        this.al_datas = al_datas;
        this.arr_test_pic = arr_test_pic;
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
            convertView = mInflater.inflate(R.layout.item_gv_music_talk, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //holder.imageView1.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.musictalk_test1));

        holder.imageView1.setImageResource(arr_test_pic[position]);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imageView1)
        RoundedImageView imageView1;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


    }
}
