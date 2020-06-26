package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.service.SuspensionService;
import com.mediabox.qukuailian.utils.Fglass;
import com.mediabox.qukuailian.utils.T;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhaoyong on 2018/7/20.
 * 音乐播放页面
 */
public class MusicPlayActivity extends BaseActivity {
    @BindView(R.id.rl_main_bg)
    RelativeLayout rl_main_bg;
    @BindView(R.id.fl_back)
    FrameLayout fl_back;

    @OnClick(R.id.fl_back)
    public void back() {
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        askForPermission();
    }

    // 权限请求-返回
    public static int OVERLAY_PERMISSION_REQ_CODE = 1234;

    /**
     * 请求用户给予悬浮窗的权限
     */
    public void askForPermission() {
        if (!Settings.canDrawOverlays(this)) {
            T.show(getApplicationContext(), "当前无权限，请授权！", 0);
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
        } else {
            startSuspensionService();
        }
    }


    // 启动悬浮窗视频
    public void startSuspensionService() {
        Intent intent = new Intent(this, SuspensionService.class);
        startService(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        ButterKnife.bind(this);
        setStatusBarStyle("type3");
    }

    // 控件加载完成
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // 毛玻璃
        Fglass.blur(rl_main_bg, fl_back, 2, 8);
        // 设置圆角
        fl_back.setBackgroundDrawable(getResources().getDrawable(R.drawable.corner_view_white_oval));
        // fl_back.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理权限返回
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (!Settings.canDrawOverlays(this)) {
                T.show(getApplicationContext(), "权限授予失败，无法开启悬浮窗", 0);
            } else {
                // T.show(getApplicationContext(), "权限授予成功！", 0);
                startSuspensionService();
            }

            finish();
        }
    }
}
