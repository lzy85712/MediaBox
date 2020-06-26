package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.GvReportAdapter;
import com.mediabox.qukuailian.utils.MyUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/18.
 * 发评论
 */
public class CommentActivity extends BaseActivity {

    @BindView(R.id.gv_report)
    GridView gv_report;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);

        al_test = new ArrayList<>();
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        gv_report.setAdapter(new GvReportAdapter(al_test, getApplicationContext()));
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
