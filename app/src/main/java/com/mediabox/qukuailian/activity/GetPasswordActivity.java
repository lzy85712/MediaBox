package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/4.
 * 找回密码
 */
public class GetPasswordActivity extends BaseActivity {


    @BindView(R.id.tv_pager_indicator)
    TextView tv_pager_indicator;
    @BindView(R.id.tv_question_result)
    TextView tv_question_result;
    @BindView(R.id.tv_question_one_content)
    TextView tv_question_one_content;

    @BindView(R.id.tv_question_two_content)
    TextView tv_question_two_content;

    @BindView(R.id.tv_question_three_content)
    TextView tv_question_three_content;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_commit)
    public void commit() {
        Intent intent = new Intent(getApplicationContext(), ResetPasswordActivity.class);
        startActivity(intent);
    }

    private final static int REQUESTCODE = 1; // 返回的结果码

    // 问题选择页面
    @OnClick(R.id.tv_question_one)
    public void enterQuestionSelectOne() {
        Intent intent = new Intent(getApplicationContext(), QuestionSelectActivity.class);
        intent.putExtra("position", 1);
        intent.putExtra("type", "getPassword");
        startActivityForResult(intent, REQUESTCODE);
    }

    @OnClick(R.id.tv_question_two)
    public void enterQuestionSelectTwo() {
        Intent intent = new Intent(getApplicationContext(), QuestionSelectActivity.class);
        intent.putExtra("position", 2);
        intent.putExtra("type", "getPassword");
        startActivityForResult(intent, REQUESTCODE);
    }

    @OnClick(R.id.tv_question_three)
    public void enterQuestionSelectThree() {
        Intent intent = new Intent(getApplicationContext(), QuestionSelectActivity.class);
        intent.putExtra("position", 3);
        intent.putExtra("type", "getPassword");
        startActivityForResult(intent, REQUESTCODE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_password);
        ButterKnife.bind(this);
    }

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
