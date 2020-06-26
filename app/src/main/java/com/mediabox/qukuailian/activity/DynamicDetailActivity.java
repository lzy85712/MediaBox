package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.adapter.LvRecommendAdapter;
import com.mediabox.qukuailian.utils.MyUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/11.
 * 动态详情
 */
public class DynamicDetailActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.lv_recommend)
    ListView lv_recommend;
    @BindView(R.id.et_recommend)
    EditText et_recommend;

    @OnClick(R.id.rl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick({R.id.tv_zhuanfa, R.id.iv_zhuanfa})
    public void zhuanfa() {
        Intent intent = new Intent(getApplicationContext(), ForwardActivity.class);
        startActivity(intent);
    }

    private ArrayList<String> al_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_detail);
        ButterKnife.bind(this);
        al_test = new ArrayList<>();
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        al_test.add("");
        lv_recommend.setAdapter(new LvRecommendAdapter(al_test, getApplicationContext()));
        MyUtils.setListViewHeightBasedOnChildren(lv_recommend, getApplicationContext(), null);
        lv_recommend.setFocusable(false);

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
