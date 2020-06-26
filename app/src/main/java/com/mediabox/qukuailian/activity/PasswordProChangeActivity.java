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
 * Created by lizhaoyong on 2018/7/17.
 * 密码保护修改页面
 */
public class PasswordProChangeActivity extends BaseActivity {
    @BindView(R.id.tv_question_one)
    TextView tv_question_one;
    @BindView(R.id.tv_question_two)
    TextView tv_question_two;
    @BindView(R.id.tv_question_three)
    TextView tv_question_three;
    @BindView(R.id.tv_question_one_content)
    TextView tv_question_one_content;
    @BindView(R.id.tv_question_two_content)
    TextView tv_question_two_content;
    @BindView(R.id.tv_question_three_content)
    TextView tv_question_three_content;
    @BindView(R.id.tv_desc)
    TextView tv_desc;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_save)
    TextView tv_save;

    // 是否通过审核
    private boolean is_pass = false;


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

    private final static int REQUESTCODE = 1; // 返回的结果码

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.tv_save)
    public void save() {

        tv_question_one.setVisibility(View.VISIBLE);
        tv_question_two.setVisibility(View.VISIBLE);
        tv_question_three.setVisibility(View.VISIBLE);
        tv_title.setText("修改密码保护");
        tv_save.setText("保存");
        tv_desc.setVisibility(View.GONE);
        is_pass = true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordpro_change);
        ButterKnife.bind(this);
        tv_question_one.setVisibility(View.INVISIBLE);
        tv_question_two.setVisibility(View.INVISIBLE);
        tv_question_three.setVisibility(View.INVISIBLE);
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
