package com.mediabox.qukuailian.activity;

import android.os.Bundle;

import com.mediabox.qukuailian.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/17.
 * 密码修改页面
 */
public class PasswordChangeActivity extends BaseActivity {
    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_save)
    public void save() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);

    }
}
