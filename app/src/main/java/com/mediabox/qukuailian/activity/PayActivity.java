package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.apkfuns.logutils.LogUtils;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.ielse.view.SwitchView;

/**
 * Created by lizhaoyong on 2018/7/20.
 * 支付页面
 */
public class PayActivity extends BaseActivity {
    @BindView(R.id.sv_btn)
    SwitchView sv_btn;


    @BindView(R.id.rb_check_zhifubao)
    RadioButton rb_check_zhifubao;
    @BindView(R.id.rb_check_weixin)
    RadioButton rb_check_weixin;
    @BindView(R.id.rb_check_visa)
    RadioButton rb_check_visa;
    @BindView(R.id.rb_check_upt)
    RadioButton rb_check_upt;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.sv_btn)
    public void toggln() {
        if (sv_btn.isOpened()) {
            LogUtils.d("开");
        } else {
            LogUtils.d("关");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);

        rb_check_zhifubao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rb_check_weixin.setChecked(false);
                    rb_check_visa.setChecked(false);
                    rb_check_upt.setChecked(false);
                }
            }
        });

        rb_check_weixin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rb_check_zhifubao.setChecked(false);
                    rb_check_visa.setChecked(false);
                    rb_check_upt.setChecked(false);
                }
            }
        });

        rb_check_visa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rb_check_weixin.setChecked(false);
                    rb_check_zhifubao.setChecked(false);
                    rb_check_upt.setChecked(false);
                }
            }
        });

        rb_check_upt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rb_check_weixin.setChecked(false);
                    rb_check_visa.setChecked(false);
                    rb_check_zhifubao.setChecked(false);
                }
            }
        });


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
