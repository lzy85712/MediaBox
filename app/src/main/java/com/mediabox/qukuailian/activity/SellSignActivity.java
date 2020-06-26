package com.mediabox.qukuailian.activity;

import android.os.Bundle;

import com.mediabox.qukuailian.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/16.
 * 转卖签发
 */
public class SellSignActivity extends BaseActivity {

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_sign);
        ButterKnife.bind(this);
    }
}
