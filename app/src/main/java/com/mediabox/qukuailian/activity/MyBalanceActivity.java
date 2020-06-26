package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvMyBalanceAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/12.
 * 我的余额
 */
public class MyBalanceActivity extends BaseActivity {
    @BindView(R.id.lv_record)
    ListView lv_record;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_buy)
    public void buy() {
        Intent intent = new Intent(getApplicationContext(), RechargeActivity.class);
        startActivity(intent);
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_balance);
        ButterKnife.bind(this);
        setStatusBarStyle("type2");
        al_test = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            al_test.add("");
        }

        lv_record.setAdapter(new LvMyBalanceAdapter(al_test, getApplicationContext()));


        lv_record.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
}
