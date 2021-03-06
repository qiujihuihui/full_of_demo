package com.full.demo.manager;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.xutils.x;

import androidx.multidex.MultiDex;

/**
 * 全局控制
 */
public class MyApp extends Application
{
    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        MultiDex.install(this);
        Fresco.initialize(this);
    }
}
