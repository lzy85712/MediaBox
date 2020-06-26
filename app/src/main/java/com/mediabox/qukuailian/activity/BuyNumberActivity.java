package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvBuyNumberAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/14.
 */
public class BuyNumberActivity extends BaseActivity {

    @BindView(R.id.lv_buy_number)
    ListView lv_buy_number;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.rl_recommend)
    public void evla() {
        Intent intent = new Intent(getApplicationContext(), EvaluateActivity.class);
        startActivity(intent);
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_number);
        ButterKnife.bind(this);

        al_test = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            al_test.add("");
        }
        lv_buy_number.setAdapter(new LvBuyNumberAdapter(al_test, getApplicationContext()));


    }
}
