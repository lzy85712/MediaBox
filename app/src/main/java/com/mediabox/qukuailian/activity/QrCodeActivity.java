package com.mediabox.qukuailian.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mediabox.qukuailian.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/11.
 * 二维码显示页面
 */
public class QrCodeActivity extends BaseActivity {

    @BindView(R.id.iv_qrcode)
    ImageView iv_qrcode;
    @BindView(R.id.tv_show_qrcode)
    TextView tv_show_qrcode;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        ButterKnife.bind(this);
        setStatusBarStyle("type2");
    }


    // 控件加载完成
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // 设置高度成为正方形
        ViewGroup.LayoutParams params = iv_qrcode.getLayoutParams();
        int width = iv_qrcode.getWidth();
        params.height = width;
        iv_qrcode.setLayoutParams(params);
        // 生成二维码
        String textContent = tv_show_qrcode.getText().toString();
        iv_qrcode.setImageBitmap(CodeUtils.createImage(textContent, width, width, null));
    }

}
