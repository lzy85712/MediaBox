package com.mediabox.qukuailian.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.activity.MusicPlayActivity;

/**
 * Created by lizhaoyong on 2018/7/24.
 * 悬浮窗
 */
public class SuspensionService extends Service {

    // 是否创建过视图了
    public boolean isCreateWindow = false;
    // 定义浮动窗口布局
    public RelativeLayout mFloatLayout;
    public WindowManager.LayoutParams wmParams;
    // 创建浮动窗口设置布局参数的对象
    public WindowManager mWindowManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if (isCreateWindow == false) {
            createFloatView();
            isCreateWindow = !isCreateWindow;
        }

        return START_NOT_STICKY;
    }


    public void createFloatView() {
        wmParams = new WindowManager.LayoutParams();
        // 获取WindowManagerImpl.CompatModeWrapper
        mWindowManager = (WindowManager) getApplication().getSystemService(
                getApplication().WINDOW_SERVICE);
        // 设置window type
        wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        // 设置图片格式，效果为背景透明
        wmParams.format = PixelFormat.RGBA_8888;
        // 设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        // 调整悬浮窗显示的停靠位置为左侧置顶
        wmParams.gravity = Gravity.BOTTOM;
        // 设置悬浮窗口长宽数据
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = 140;
        //设置x、y初始值
        wmParams.y = 200;
        LayoutInflater inflater = LayoutInflater.from(getApplication());
        // 获取浮动窗口视图所在布局
        mFloatLayout = (RelativeLayout) inflater.inflate(R.layout.window_suspensin,
                null);
        // 添加mFloatLayout
        mWindowManager.addView(mFloatLayout, wmParams);

        ImageView iv_close = (ImageView) mFloatLayout.findViewById(R.id.iv_close);

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
            }
        });

        RelativeLayout rl_whole = (RelativeLayout) mFloatLayout.findViewById(R.id.rl_whole);
        rl_whole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
                Intent intent = new Intent(getApplicationContext(), MusicPlayActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onDestroy() {
        if (isCreateWindow != false) {
            if (mFloatLayout != null && mWindowManager != null
                    && mFloatLayout != null) {
                mWindowManager.removeView(mFloatLayout);
            }
        }
        isCreateWindow = false;
        super.onDestroy();
    }
}
