package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/3.
 */
public class RegActivity extends BaseActivity {
    @BindView(R.id.tv_pager_desc)
    TextView tv_pager_desc;

    @BindView(R.id.fl_back)
    FrameLayout fl_back;

    @BindView(R.id.ll_reg_one)
    LinearLayout ll_reg_one;

    @BindView(R.id.ll_reg_two)
    LinearLayout ll_reg_two;

    @BindView(R.id.tv_one_next)
    TextView tv_one_next;

    @BindView(R.id.tv_two_next)
    TextView tv_two_next;

    @BindView(R.id.iv_country)
    ImageView iv_country;


    @OnClick({R.id.tv_login_one, R.id.tv_login_two})
    public void login() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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


    @OnClick(R.id.tv_one_next)
    public void nextOne() {
        pager = 2;
        ll_reg_one.setVisibility(View.GONE);
        ll_reg_two.setVisibility(View.VISIBLE);
        tv_pager_desc.setText("2/2");
    }

    @OnClick(R.id.tv_two_next)
    public void nextTwo() {
        Intent intent = new Intent(getApplicationContext(), RegSuccessActivity.class);
        startActivity(intent);
        finish();
    }


    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }


    // 当前注册页数标识
    private int pager = 1;


    @Override
    public void onBackPressed() {
        if (pager == 1) {
            finish();
        } else if (pager == 2) {
            pager = 1;
            tv_pager_desc.setText("1/2");
            ll_reg_one.setVisibility(View.VISIBLE);
            ll_reg_two.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (MyUtils.isShouldHideInput(v, ev)) {
                if (MyUtils.hideInputMethod(this, v)) {
                    return true; //隐藏键盘时，其他控件不响应点击事件==》注释则不拦截点击事件
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
