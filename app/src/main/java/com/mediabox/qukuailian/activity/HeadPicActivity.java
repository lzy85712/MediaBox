package com.mediabox.qukuailian.activity;

import android.os.Bundle;

import com.mediabox.qukuailian.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/17.
 * 头像页面
 */
public class HeadPicActivity extends BaseActivity {
    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_pic);
        ButterKnife.bind(this);
        setStatusBarStyle("type2");
    }
}
