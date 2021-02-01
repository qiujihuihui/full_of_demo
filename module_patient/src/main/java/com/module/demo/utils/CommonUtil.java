package com.module.demo.utils;

import android.app.Activity;
import android.util.Log;

/**
 * On 2020/12/22
 */
public class CommonUtil
{
    public static void testDemo(Activity context) {
        Log.d("demo", context.getPackageName());
    }
}
