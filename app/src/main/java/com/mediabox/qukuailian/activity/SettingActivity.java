package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.PreUtils;
import com.mediabox.qukuailian.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/11.
 */
public class SettingActivity extends BaseActivity {
    private final static int REQUESTCODE = 1; // 返回的结果码

    @BindView(R.id.tv_sex)
    TextView tv_sex;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.rl_beifen)
    public void beifen() {
        intent = new Intent(getApplicationContext(), BackupsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_person_desc)
    public void personDesc() {
        intent = new Intent(getApplicationContext(), PersonalIntroducActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_nickname)
    public void nickname() {
        intent = new Intent(getApplicationContext(), NickNameActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_clean)
    public void clean() {
        T.show(getApplicationContext(), getString(R.string.cacheclean), 0);
    }

    @OnClick(R.id.rl_sex)
    public void sex() {
        intent = new Intent(getApplicationContext(), SexActivity.class);
        startActivityForResult(intent, REQUESTCODE);
    }

    @OnClick(R.id.rl_head)
    public void head() {
        intent = new Intent(getApplicationContext(), HeadPicActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_login_password)
    public void password() {
        intent = new Intent(getApplicationContext(), SettingPasswordActivity.class);
        startActivity(intent);
    }


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        // 设置本地存储的性别
        String sex = (String) PreUtils.getParam(getApplicationContext(), "sex", "");
        if (!sex.equals("")) {
            tv_sex.setText(sex);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理选中返回
        if (resultCode == 2) {
            if (requestCode == REQUESTCODE) {
                String sex = data.getStringExtra("sex");
                tv_sex.setText(sex);
            }
        }
    }
}
