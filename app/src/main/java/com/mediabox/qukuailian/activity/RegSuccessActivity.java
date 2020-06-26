package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mediabox.qukuailian.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/3.
 * 注册成页面
 */
public class RegSuccessActivity extends BaseActivity {
    @BindView(R.id.tv_confirm)
    TextView tv_confirm;

    @BindView(R.id.tv_jump)
    TextView tv_jump;

    @OnClick(R.id.tv_confirm)
    public void confirm() {
        Intent intent = new Intent(getApplicationContext(), SetPasswordProtectionActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_jump)
    public void jump() {
        onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_success);
        ButterKnife.bind(this);
        setStatusBarStyle("type2");
    }
}
