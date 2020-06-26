package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvSignAdapter;
import com.mediabox.qukuailian.utils.MyUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/13.
 * 签发的页面
 */
public class SignActivity extends BaseActivity {


    @BindView(R.id.lv_sign)
    ListView lv_sign;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_number_select)
    public void select() {
        Intent intent = new Intent(getApplicationContext(), NumberSelectActivity.class);
        startActivity(intent);
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            al_test.add("");
        }
        lv_sign.setAdapter(new LvSignAdapter(al_test, getApplicationContext()));
        lv_sign.setFocusable(false);
        lv_sign.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        MyUtils.setListViewHeightBasedOnChildren(lv_sign, getApplicationContext(), null);
    }
}
