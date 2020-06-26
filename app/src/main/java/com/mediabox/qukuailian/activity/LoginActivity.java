package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.apkfuns.logutils.LogUtils;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.fl_back)
    FrameLayout fl_back;

    @BindView(R.id.iv_country)
    ImageView iv_country;

    @OnClick(R.id.fl_back)
    public void back() {
        finish();
    }

    // 去注册页面
    @OnClick(R.id.tv_reg)
    public void reg() {
        Intent intent = new Intent(getApplicationContext(), RegActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_forget_password)
    public void enterGetPassword() {
        Intent intent = new Intent(getApplicationContext(), GetPasswordActivity.class);
        startActivity(intent);
    }

    private final static int REQUESTCODE = 1; // 返回的结果码
    // 默认中国是选中的状态
    private int position = 0;


    private int[] country_icons = {R.mipmap.china_icon, R.mipmap.hongkong, R.mipmap.japan, R.mipmap.thailand, R.mipmap.usa, R.mipmap.unitedkingdom, R.mipmap.australia, R.mipmap.taiwan};

    @OnClick(R.id.iv_country)
    public void selectCountry() {
        Intent intent = new Intent(getApplicationContext(), SelectCountryActivity.class);
        intent.putExtra("position", position);

        startActivityForResult(intent, REQUESTCODE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理选中返回
        if (resultCode == 2) {
            if (requestCode == REQUESTCODE) {
                int position = data.getIntExtra("position", 0);
                this.position = position;
                iv_country.setImageResource(country_icons[position]);
            }
        }
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
