package com.mediabox.qukuailian.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.fragment.MineFragment;
import com.mediabox.qukuailian.utils.MyUtils;
import com.mediabox.qukuailian.utils.T;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.namee.permissiongen.PermissionGen;

/**
 * Created by lizhaoyong on 2018/7/16.
 * 送朋友
 */
public class SendFriendActivity extends BaseActivity {


    private Intent intent;
    // 扫码返回结果
    private int REQUEST_CODE = 20;

    @BindView(R.id.et_number)
    EditText et_number;

    @OnClick(R.id.tv_back)
    public void back() {
        onBackPressed();
    }

    @OnClick(R.id.iv_scan)
    public void scan() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // 没有权限，申请权限。
            // 请求开启相机权限
            PermissionGen.needPermission(this, 105,
                    new String[]{
                            Manifest.permission.CAMERA}
            );
        } else {
            // 有权限了
            intent = new Intent(getApplicationContext(), CaptureActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_friend);
        // 初始化二维码扫描
        ZXingLibrary.initDisplayOpinion(getApplicationContext());
        ButterKnife.bind(this);
    }

    // 二维码扫描结果显示
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    et_number.setText(result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    T.show(getApplicationContext(), "解析二维码失败", 0);
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
