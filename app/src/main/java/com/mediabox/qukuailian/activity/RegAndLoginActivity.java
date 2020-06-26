package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.Fglass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class RegAndLoginActivity extends BaseActivity {
    @BindView(R.id.fl_back)
    FrameLayout fl_back;
    @BindView(R.id.rl_bg)
    RelativeLayout rl_bg;
    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.fl_cb)
    FrameLayout fl_cb;
    @BindView(R.id.iv_check)
    ImageView iv_check;
    @BindView(R.id.tv_login)
    TextView tv_login;
    @BindView(R.id.tv_reg)
    TextView tv_reg;


    @OnClick(R.id.fl_cb)
    public void check() {
        if (check) {
            iv_check.setVisibility(View.INVISIBLE);
        } else {
            iv_check.setVisibility(View.VISIBLE);
        }
        check = !check;
    }

    // 用户协议的选中状态
    private boolean check = true;


    @OnClick(R.id.fl_back)
    public void back() {
        finish();
    }


    @OnClick(R.id.tv_login)
    public void login() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_reg)
    public void reg() {
        Intent intent = new Intent(getApplicationContext(), RegActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_and_login);
        ButterKnife.bind(this);
        setStatusBarStyle("type2");
    }


    // 控件加载完成
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // 毛玻璃
        Fglass.blur(rl_bg, fl_back, 2, 8);
        // 设置圆角
        fl_back.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_white_oval));
        // fl_back.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }
}
