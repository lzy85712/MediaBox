package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.apkfuns.logutils.LogUtils;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.PreUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/17.
 * 性别设置
 */
public class SexActivity extends BaseActivity {

    @BindView(R.id.rb_women)
    RadioButton rb_women;

    @BindView(R.id.rb_man)
    RadioButton rb_man;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_save)
    public void save() {
        Intent intent = new Intent();
        String sex = getResources().getString(R.string.women);
        if (rb_women.isChecked()) {
            sex = getResources().getString(R.string.women);
        } else {
            sex = getResources().getString(R.string.man);
        }
        // 性别存本地
        PreUtils.setParam(getApplicationContext(), "sex", sex);
        intent.putExtra("sex", sex);
        setResult(2, intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);
        ButterKnife.bind(this);

        String sex = (String) PreUtils.getParam(getApplicationContext(), "sex", "");
        if (!sex.equals("")) {
            if (sex.equals(getResources().getString(R.string.man))) {
                rb_man.setChecked(true);
            } else if (sex.equals(getResources().getString(R.string.women))) {
                rb_women.setChecked(true);
            }
        } else {
            // 默认选中女
            rb_women.setChecked(true);
        }


        rb_women.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rb_man.setChecked(false);
                }
            }
        });

        rb_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rb_women.setChecked(false);
                }
            }
        });


    }
}
