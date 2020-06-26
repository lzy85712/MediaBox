package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.Fglass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/12.
 */
public class InfluenceActivity extends BaseActivity {

    @BindView(R.id.rl_bg)
    RelativeLayout rl_bg;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_influence);
        ButterKnife.bind(this);
        setStatusBarStyle("type2");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // Fglass.blur(rl_bg, rl_bg, 2, 8);
    }
}
