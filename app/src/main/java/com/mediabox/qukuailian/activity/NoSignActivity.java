package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvBuyProdAdapter;
import com.mediabox.qukuailian.adapter.LvNoSignAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/12.
 */
public class NoSignActivity extends BaseActivity{

    @BindView(R.id.lv_no_sign)
    ListView lv_no_sign;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_sign);
        ButterKnife.bind(this);

        al_test = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            al_test.add("");
        }

        lv_no_sign.setAdapter(new LvNoSignAdapter(al_test, getApplicationContext()));
    }
}
