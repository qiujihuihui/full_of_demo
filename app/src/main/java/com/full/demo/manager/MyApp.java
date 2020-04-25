package com.full.demo.manager;

import android.app.Application;

import org.xutils.x;

/**
 * 全局控制
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
