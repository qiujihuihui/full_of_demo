package com.full.demo.manager;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * 全局控制
 */
public class MyApp extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        context = getApplicationContext();
    }
}
