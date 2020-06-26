package com.mediabox.qukuailian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;

import com.mediabox.qukuailian.R;
import com.mediabox.qukuailian.constant.GlobalConstants;
import com.mediabox.qukuailian.utils.MyUtils;

/**
 * Created by lizhaoyong on 2018/5/7.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setStatusBarStyle("type3");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

        // 判断用户是否登录了
//        final LoginEntity le = (LoginEntity) PreUtils.getObject(getApplicationContext(), "LoginEntity");
//        if (le == null) {
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }, 2000);
//        } else {
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("LoginEntity", le);//序列化
//                    intent.putExtras(bundle);//发送数据
//                    startActivity(intent);
//                    finish();
//                }
//            }, 2000);
//        }
    }
}
