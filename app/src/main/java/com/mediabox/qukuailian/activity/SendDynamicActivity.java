package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;
import com.mediabox.qukuailian.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/11.
 */
public class SendDynamicActivity extends BaseActivity {

    @BindView(R.id.et_content)
    EditText et_content;

    @OnClick(R.id.tv_pub)
    public void pub() {
        T.show(getApplicationContext(), "发布了", 0);
    }

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_dynamic);
        ButterKnife.bind(this);

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
