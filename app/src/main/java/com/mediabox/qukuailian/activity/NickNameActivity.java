package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.mediabox.qukuailian.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/17.
 * 修改昵称
 */
public class NickNameActivity extends BaseActivity {

    @BindView(R.id.et_nickname)
    EditText et_nickname;

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
        setContentView(R.layout.activity_nickname);
        ButterKnife.bind(this);
    }
}
