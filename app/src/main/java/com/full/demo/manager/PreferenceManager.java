package com.full.demo.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 缓存管理
 */
public class PreferenceManager {
    private static final String COMMON_DATA = "common_data";
    /*当前账号*/
    private static final String CURRENT_ACCOUNT = "account";
    /*当前密码*/
    private static final String CURRENT_PASSWORD = "current_password";

    private SharedPreferences preferences;
    private static PreferenceManager manager = new PreferenceManager();

    public static PreferenceManager getInstance(){
        return manager;
    }

    private PreferenceManager(){
        preferences = MyApp.context.getSharedPreferences(COMMON_DATA, Context.MODE_PRIVATE);
    }

    public void setLoginAccount(String account){
        preferences.edit().putString(CURRENT_ACCOUNT, account).apply();
    }

    public String getLoginAccount(){
        return preferences.getString(CURRENT_ACCOUNT, "");
    }

    public void setLoginPassword(String password){
        preferences.edit().putString(CURRENT_PASSWORD, password).apply();
    }

    public String getLoginPassword(){
        return preferences.getString(CURRENT_PASSWORD, "");
    }
}
