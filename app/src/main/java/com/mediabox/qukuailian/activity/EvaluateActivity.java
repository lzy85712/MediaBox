package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.azhong.ratingbar.OnChangeListener;
import com.azhong.ratingbar.RatingBar;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/18.
 * 评价页面
 */
public class EvaluateActivity extends BaseActivity {

    @BindView(R.id.ratingbar)
    RatingBar ratingbar;
    @BindView(R.id.et_content)
    EditText et_content;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        ButterKnife.bind(this);
        ratingbar.setOnStarChangeListener(new OnChangeListener() {
            @Override
            public void onChange(int star) {
                // LogUtils.d("star = " + star);
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
