package com.mediabox.qukuailian.activity;

import android.os.Bundle;

import com.mediabox.qukuailian.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/19.
 * 签发留言
 */
public class SignLeaveMsgActivity extends BaseActivity{

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_msg);
        ButterKnife.bind(this);
    }
}
