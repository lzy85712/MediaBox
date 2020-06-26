package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.apkfuns.logutils.LogUtils;
import com.mediabox.qukuailian.R;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/3.
 * 问题选择页面
 */
public class QuestionSelectActivity extends BaseActivity {

    @BindView(R.id.common_wheelview)
    WheelView common_wheelview;
    @BindView(R.id.fl_back)
    FrameLayout fl_back;
    @BindView(R.id.rl_title)
    RelativeLayout rl_title;


    private ArrayList<String> al_test;
    // 问题几传来的标识
    private int position;
    // 是否显示密码找回
    private String type;

    @OnClick(R.id.tv_cancel)
    public void cancel() {
        onBackPressed();
    }


    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_confirm)
    public void confirm() {
        Intent intent = new Intent();
        intent.putExtra("question", al_test.get(common_wheelview.getCurrentPosition()));
        intent.putExtra("position", position);
        setResult(2, intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_select);
        ButterKnife.bind(this);

        al_test = new ArrayList<String>();
        al_test.add("您初中的班主任的名字是？");
        al_test.add("您的初恋女友或男友是？");
        al_test.add("您买的第一步手机是什么牌子的？");
        al_test.add("您的父亲的名字是？");
        al_test.add("您觉得最值得看的一部电影的名字是？");
        al_test.add("您出生的医院是？");


        position = getIntent().getIntExtra("position", 0);
        type = getIntent().getStringExtra("type");
        if (type != null && !type.equals("")) {
            rl_title.setVisibility(View.VISIBLE);
            fl_back.setVisibility(View.VISIBLE);
        } else {
            rl_title.setVisibility(View.GONE);
            fl_back.setVisibility(View.GONE);
        }


        common_wheelview.setWheelAdapter(new ArrayWheelAdapter(this));
        common_wheelview.setSkin(WheelView.Skin.Common);
        common_wheelview.setWheelData(al_test);
        common_wheelview.setWheelSize(5);
        common_wheelview.setBackgroundColor(getResources().getColor(R.color.main_color));

    }
}
