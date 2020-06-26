package com.mediabox.qukuailian.activity;

import android.os.Bundle;

import com.mediabox.qukuailian.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/3.
 * 设置密码保护成功页面
 */
public class ProtectionSuccessActivity extends BaseActivity {

    @OnClick(R.id.tv_finish)
    public void setFinish() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection_success);
        ButterKnife.bind(this);
        setStatusBarStyle("type2");

    }
}
