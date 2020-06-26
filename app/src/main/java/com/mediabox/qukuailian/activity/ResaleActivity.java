package com.mediabox.qukuailian.activity;

import android.os.Bundle;

import com.mediabox.qukuailian.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/16.
 * 转卖中
 */
public class ResaleActivity extends BaseActivity {

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }


    @OnClick(R.id.tv_changeprice)
    public void change() {

    }

    @OnClick(R.id.tv_quxiaozhuanmai)
    public void quxiao() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resale);
        ButterKnife.bind(this);
    }
}
