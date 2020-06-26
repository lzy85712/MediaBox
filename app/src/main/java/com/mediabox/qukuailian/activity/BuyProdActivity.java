package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvBuyProdAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/12.
 * 已购作品
 */
public class BuyProdActivity extends BaseActivity {

    @BindView(R.id.lv_buy_prod)
    ListView lv_buy_prod;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_prod);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            al_test.add("");
        }

        lv_buy_prod.setAdapter(new LvBuyProdAdapter(al_test, getApplicationContext()));

        lv_buy_prod.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), BuyNumberActivity.class);
                startActivity(intent);
            }
        });
    }
}
