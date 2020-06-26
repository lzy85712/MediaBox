package com.mediabox.qukuailian.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.CommentActivity;
import com.mediabox.qukuailian.activity.ForwardActivity;
import com.mediabox.qukuailian.utils.T;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhaoyong on 2018/7/4.
 * 动态:处理多种布局复用
 */
public class LvDynamicAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;
    private LayoutInflater mInflater;

    //为四种布局定义一个标识
    private final int TYPE1 = 0;
    private final int TYPE2 = 1;
    private final int TYPE3 = 2;
    private final int TYPE4 = 3;


    public LvDynamicAdapter(ArrayList<String> datas, Context context) {
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


    // 默认4种布局
    @Override
    public int getViewTypeCount() {
        return 4;
    }


    @Override
    public int getItemViewType(int position) {
        String type = mDatas.get(position);
        if (type.equals("type1")) {
            return TYPE1;
        } else if (type.equals("type2")) {
            return TYPE2;
        } else if (type.equals("type3")) {
            return TYPE3;
        } else if (type.equals("type4")) {
            return TYPE4;
        }
        // 都没有默认布局1
        return TYPE1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;
        ViewHolder4 holder4 = null;

        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE1:
                    convertView = mInflater.inflate(R.layout.item_lv_dynamic_type_two, null, false);
                    holder1 = new ViewHolder1(convertView);
                    convertView.setTag(holder1);
                    break;
                case TYPE2:
                    convertView = mInflater.inflate(R.layout.item_lv_dynamic_type_one, null, false);
                    holder2 = new ViewHolder2(convertView);
                    convertView.setTag(holder2);
                    break;
                case TYPE3:
                    convertView = mInflater.inflate(R.layout.item_lv_dynamic_type_three, null, false);
                    holder3 = new ViewHolder3(convertView);
                    convertView.setTag(holder3);
                    break;
                case TYPE4:
                    convertView = mInflater.inflate(R.layout.item_lv_dynamic_type_four, null, false);
                    holder4 = new ViewHolder4(convertView);
                    convertView.setTag(holder4);
                    break;

            }
        } else {
            switch (type) {
                case TYPE1:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE2:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
                case TYPE3:
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
                case TYPE4:
                    holder4 = (ViewHolder4) convertView.getTag();
                    break;
            }
        }


        //为布局设置数据和事件
        switch (type) {
            case TYPE1:
                holder1.tv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder1.iv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder1.tv_comment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, CommentActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder1.tv_agree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        T.show(mContext, "赞+1", 0);
                    }
                });

                break;
            case TYPE2:
                holder2.tv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });


                holder2.iv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder2.tv_comment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, CommentActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder2.tv_agree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        T.show(mContext, "赞+1", 0);
                    }
                });
                break;
            case TYPE3:
                holder3.tv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });


                holder3.iv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder3.tv_comment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, CommentActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder3.tv_agree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        T.show(mContext, "赞+1", 0);
                    }
                });

                break;
            case TYPE4:
                holder4.tv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder4.iv_zhuanfa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ForwardActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder4.tv_comment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, CommentActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                });

                holder4.tv_agree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        T.show(mContext, "赞+1", 0);
                    }
                });
                break;
        }

        return convertView;
    }


    static class ViewHolder1 {
        @BindView(R.id.tv_zhuanfa)
        TextView tv_zhuanfa;
        @BindView(R.id.iv_zhuanfa)
        ImageView iv_zhuanfa;
        @BindView(R.id.tv_comment)
        TextView tv_comment;
        @BindView(R.id.tv_agree)
        TextView tv_agree;

        public ViewHolder1(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder2 {
        @BindView(R.id.tv_zhuanfa)
        TextView tv_zhuanfa;
        @BindView(R.id.iv_zhuanfa)
        ImageView iv_zhuanfa;
        @BindView(R.id.tv_comment)
        TextView tv_comment;
        @BindView(R.id.tv_agree)
        TextView tv_agree;

        public ViewHolder2(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder3 {
        @BindView(R.id.tv_zhuanfa)
        TextView tv_zhuanfa;
        @BindView(R.id.iv_zhuanfa)
        ImageView iv_zhuanfa;
        @BindView(R.id.tv_comment)
        TextView tv_comment;
        @BindView(R.id.tv_agree)
        TextView tv_agree;

        public ViewHolder3(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder4 {
        @BindView(R.id.tv_zhuanfa)
        TextView tv_zhuanfa;
        @BindView(R.id.iv_zhuanfa)
        ImageView iv_zhuanfa;
        @BindView(R.id.tv_comment)
        TextView tv_comment;
        @BindView(R.id.tv_agree)
        TextView tv_agree;

        public ViewHolder4(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
