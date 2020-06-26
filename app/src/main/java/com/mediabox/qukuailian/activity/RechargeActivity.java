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
 * Created by lizhaoyong on 2018/7/16.
 * 充值页面
 */
public class RechargeActivity extends BaseActivity {

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_buy)
    public void buy() {

    }

    @OnClick(R.id.tv_zhuanmai)
    public void sell() {
        Intent intent = new Intent(getApplicationContext(), ResaleActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
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

