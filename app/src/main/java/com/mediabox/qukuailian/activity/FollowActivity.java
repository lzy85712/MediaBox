package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvTopAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/14.
 * 跟踪
 */
public class FollowActivity extends BaseActivity {


    @BindView(R.id.tv_indicator_one)
    TextView tv_indicator_one;
    @BindView(R.id.tv_indicator_two)
    TextView tv_indicator_two;
    @BindView(R.id.tv_indicator_three)
    TextView tv_indicator_three;

    @BindView(R.id.lv_top)
    ListView lv_top;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_number_select)
    public void select() {
        Intent intnet = new Intent(getApplicationContext(), NumberSelectActivity.class);
        startActivity(intnet);
    }


    @OnClick(R.id.tv_indicator_one)
    public void one() {
        tv_indicator_one.setTextColor(Color.parseColor("#ffffff"));
        tv_indicator_one.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_gray_15radio));
        tv_indicator_one.setPadding(30, 10, 30, 10);

        tv_indicator_two.setTextColor(Color.parseColor("#a2a8ba"));
        tv_indicator_two.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_empty_5radio));

        tv_indicator_three.setTextColor(Color.parseColor("#a2a8ba"));
        tv_indicator_three.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_empty_5radio));
    }

    @OnClick(R.id.tv_indicator_two)
    public void two() {
        tv_indicator_one.setTextColor(Color.parseColor("#a2a8ba"));
        tv_indicator_one.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_empty_5radio));


        tv_indicator_two.setTextColor(Color.parseColor("#ffffff"));
        tv_indicator_two.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_gray_15radio));
        tv_indicator_two.setPadding(30, 10, 30, 10);

        tv_indicator_three.setTextColor(Color.parseColor("#a2a8ba"));
        tv_indicator_three.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_empty_5radio));
    }

    @OnClick(R.id.tv_indicator_three)
    public void three() {
        tv_indicator_one.setTextColor(Color.parseColor("#a2a8ba"));
        tv_indicator_one.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_empty_5radio));


        tv_indicator_two.setTextColor(Color.parseColor("#a2a8ba"));
        tv_indicator_two.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_empty_5radio));


        tv_indicator_three.setTextColor(Color.parseColor("#ffffff"));
        tv_indicator_three.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_gray_15radio));
        tv_indicator_three.setPadding(30, 10, 30, 10);

    }


    private ArrayList<String> al_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            al_test.add("");
        }
        lv_top.setAdapter(new LvTopAdapter(al_test, getApplicationContext()));

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        tv_indicator_one.setPadding(30, 10, 30, 10);
    }
}
