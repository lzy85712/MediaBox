package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvPubProdAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/12.
 * 已发行的作品
 */
public class PubProdActivity extends BaseActivity {

    @BindView(R.id.lv_pub_prod)
    ListView lv_pub_prod;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<String> al_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub_prod);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            al_test.add("");
        }
        lv_pub_prod.setAdapter(new LvPubProdAdapter(al_test, getApplicationContext()));

        lv_pub_prod.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SignActivity.class);
                startActivity(intent);
            }
        });


    }
}
