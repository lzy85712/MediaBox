package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/3.
 * 设置密码保护页面
 */
public class SetPasswordProtectionActivity extends BaseActivity {

    @BindView(R.id.fl_back)
    FrameLayout fl_back;

    @BindView(R.id.tv_question_one_content)
    TextView tv_question_one_content;

    @BindView(R.id.tv_question_two_content)
    TextView tv_question_two_content;

    @BindView(R.id.tv_question_three_content)
    TextView tv_question_three_content;

    @OnClick(R.id.fl_back)
    public void back() {
        finish();
    }

    private final static int REQUESTCODE = 1; // 返回的结果码


    // 问题选择页面
    @OnClick(R.id.tv_question_one)
    public void enterQuestionSelectOne() {
        Intent intent = new Intent(getApplicationContext(), QuestionSelectActivity.class);
        intent.putExtra("position", 1);
        startActivityForResult(intent, REQUESTCODE);
    }

    @OnClick(R.id.tv_question_two)
    public void enterQuestionSelectTwo() {
        Intent intent = new Intent(getApplicationContext(), QuestionSelectActivity.class);
        intent.putExtra("position", 2);
        startActivityForResult(intent, REQUESTCODE);
    }

    @OnClick(R.id.tv_question_three)
    public void enterQuestionSelectThree() {
        Intent intent = new Intent(getApplicationContext(), QuestionSelectActivity.class);
        intent.putExtra("position", 3);
        startActivityForResult(intent, REQUESTCODE);
    }


    @OnClick(R.id.tv_finish)
    public void setFinish() {
        Intent intent = new Intent(getApplicationContext(), ProtectionSuccessActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_protection);
        ButterKnife.bind(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理选中返回
        if (resultCode == 2) {
            if (requestCode == REQUESTCODE) {
                String question = data.getStringExtra("question");
                int position = data.getIntExtra("position", 0);
                switch (position) {
                    case 1:
                        tv_question_one_content.setText("No.1 " + question);
                        break;
                    case 2:
                        tv_question_two_content.setText("No.2 " + question);
                        break;
                    case 3:
                        tv_question_three_content.setText("No.3 " + question);
                        break;
                }

            }
        }
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
