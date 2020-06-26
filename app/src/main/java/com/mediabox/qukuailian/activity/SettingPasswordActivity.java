package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/17.
 * 设置密码的中介页面
 */
public class SettingPasswordActivity extends BaseActivity {

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_setting)
    public void setting() {
        Intent intent = new Intent(getApplicationContext(), PasswordProChangeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_chongzhi)
    public void chongzhi() {
        Intent intent = new Intent(getApplicationContext(), PasswordChangeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_password);
        ButterKnife.bind(this);
    }


    // 点击外部软键盘隐藏
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (MyUtils.isShouldHideInput(v, ev)) {
                if (MyUtils.hideInputMethod(this, v)) {
                    return true;
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
