package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvSelectBuyAdapter;
import com.mediabox.qukuailian.utils.MyUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/20.
 * 单曲购买
 */
public class SingleMusicBuyActivity extends BaseActivity {

    @BindView(R.id.lv)
    ListView lv;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_select)
    public void select() {
        Intent intent = new Intent(getApplicationContext(), NumberSelectActivity.class);
        startActivity(intent);
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_music_buy);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        lv.setAdapter(new LvSelectBuyAdapter(al_test, getApplicationContext()));
        MyUtils.setListViewHeightBasedOnChildren(lv, getApplicationContext(), null);
    }

}
