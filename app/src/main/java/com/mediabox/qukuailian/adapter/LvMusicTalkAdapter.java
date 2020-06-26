package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.CommentActivity;
import com.mediabox.qukuailian.activity.ForwardActivity;
import com.mediabox.qukuailian.utils.MyUtils;
import com.mediabox.qukuailian.utils.T;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 */
public class LvMusicTalkAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    // 测试图片地址
    private int[] arr_test_pic = {R.mipmap.musictalk_test1, R.mipmap.musictalk_test2, R.mipmap.musictalk_test3, R.mipmap.musictalk_test4, R.mipmap.musictalk_test5, R.mipmap.musictalk_test6};
    private int[] arr_test_pic_two = {R.mipmap.musictalk_test7, R.mipmap.musictalk_test8};

    private LayoutInflater mInflater;

    public LvMusicTalkAdapter(ArrayList<String> datas, Context context) {
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
            convertView = mInflater.inflate(R.layout.item_lv_music_talk, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (type.equals("type1")) {
            holder.imageView1.setVisibility(View.VISIBLE);
            holder.gv_pic.setVisibility(View.GONE);
        } else if (type.equals("type2")) {
            holder.imageView1.setVisibility(View.GONE);
            holder.gv_pic.setVisibility(View.VISIBLE);
            ArrayList<String> al_test = new ArrayList<String>();
            al_test.add("");
            al_test.add("");
            al_test.add("");
            al_test.add("");
            al_test.add("");
            al_test.add("");
            holder.gv_pic.setAdapter(new GvMusicTalkAdapter(al_test, mContext, arr_test_pic));
            MyUtils.setGridViewHeightBasedOnChildren(holder.gv_pic);
        } else if (type.equals("type3")) {
            holder.imageView1.setVisibility(View.GONE);
            holder.gv_pic.setVisibility(View.VISIBLE);
            ArrayList<String> al_test = new ArrayList<String>();
            al_test.add("");
            al_test.add("");
            holder.gv_pic.setNumColumns(2);
            holder.gv_pic.setAdapter(new GvMusicTalkAdapter(al_test, mContext, arr_test_pic_two));
            MyUtils.setGridViewHeightBasedOnChildren(holder.gv_pic);

        } else {
            holder.imageView1.setVisibility(View.VISIBLE);
            holder.gv_pic.setVisibility(View.GONE);
        }

        // 进入评论页面
        holder.tv_eva_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CommentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        holder.tv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.show(mContext, "赞+1", 0);
            }
        });


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imageView1)
        RoundedImageView imageView1;
        @BindView(R.id.gv_pic)
        GridView gv_pic;
        @BindView(R.id.tv_eva_number)
        TextView tv_eva_number;
        @BindView(R.id.tv_agree)
        TextView tv_agree;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
