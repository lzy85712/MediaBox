package com.mediabox.qukuailian.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.apkfuns.logutils.LogUtils;
import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.utils.AppManager;
import com.mediabox.qukuailian.utils.DialogUtils;

/**
 * Created by lizhaoyong on 2018/7/2.
 */
public class BaseActivity extends FragmentActivity {

    // 网络请求加载对话框
    private Dialog myDialog;


    protected void showDialog(Activity activity) {
        myDialog = DialogUtils.createLoadingDialog(activity, "加载中...");
    }


    protected void closeDialog() {
        DialogUtils.closeDialog(myDialog);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 填充标题栏
        // 6.0以上才可以设置状态栏字体颜色
        setStatusBarStyle("type1");
        AppManager.getAppManager().addActivity(this);
    }


    // 设置状态栏样式 默认 type1样式
    // type1 = 浅蓝背景 + 黑色字体
    // type2 = 深蓝背景 + 白色字体
    // type3 = 状态栏透明 + 白色字体

    public void setStatusBarStyle(String type) {
        if (type.equals("type1")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置状态栏黑色字体
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //设置状态栏颜色
                window.setStatusBarColor(getResources().getColor(R.color.login_bg));
            }
        } else if (type.equals("type2")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);//设置状态栏白色
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //设置状态栏颜色
                window.setStatusBarColor(getResources().getColor(R.color.main_color));
            }

        } else if (type.equals("type3")) {
            // 透明状态栏
            getWindow()
                    .addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }


}
