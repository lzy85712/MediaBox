package com.mediabox.qukuailian.application;

import android.app.Application;


import com.google.gson.Gson;
import com.mediabox.qukuailian.constant.GlobalConstants;

import org.xutils.x;

/**
 * Created by lizhaoyong on 2018/5/4.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        // 开启日志输出
        x.Ext.setDebug(true);
        GlobalConstants.gson = new Gson();
        
    }
}
