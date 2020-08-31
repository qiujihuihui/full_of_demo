package com.full.demo.businessdemo.login;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.full.demo.R;
import com.full.demo.main.MainActivity;
import com.full.demo.manager.PreferenceManager;
import com.google.android.material.textfield.TextInputLayout;
import com.module.base.NetworkStateChangeReceiver;
import com.module.base.net.NetStateChangeObserver;
import com.module.base.net.NetworkType;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements NetStateChangeObserver
{
    private static final String TAG = "net";

    private TextInputLayout usernameInputLayout;
    private TextInputLayout pwdInputLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInputLayout = findViewById(R.id.til_username);
        pwdInputLayout = findViewById(R.id.til_password);
        Button btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(view -> login());
        initView();
        requestPermissions();
        NetworkStateChangeReceiver.registerReceiver(LoginActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        NetworkStateChangeReceiver.registerObserver(this);
    }

    @SuppressLint("CheckResult")
    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            RxPermissions rxPermissions = new RxPermissions(LoginActivity.this);
            rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE).subscribe(aBoolean -> {
                if (!aBoolean) {
                    Toast.makeText(LoginActivity.this, "App未能获取全部需要的相关权限，部分功能可能无法正常使用", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initView(){
        String userName = PreferenceManager.getInstance().getLoginAccount();
        String password = PreferenceManager.getInstance().getLoginPassword();
        if (!TextUtils.isEmpty(userName)){
            usernameInputLayout.getEditText().setText(userName);
        }
        if (!TextUtils.isEmpty(password)){
            pwdInputLayout.getEditText().setText(password);
        }
    }

    private boolean validatePassword(String password) {
        return password.length() > 6;
    }

    /**
     * 6-16位数字字母混合,不能全为数字,不能全为字母,首位不能为数字
     *
     * @param username
     * @return
     */
    private boolean validateUserName(String username) {
        String regex = "^(?![0-9])(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(username);
        return m.matches();
    }

    private void login() {
        String username = usernameInputLayout.getEditText().getText().toString();
        String password = pwdInputLayout.getEditText().getText().toString();
        if (!validateUserName(username)) {
            usernameInputLayout.setErrorEnabled(true);
            usernameInputLayout.setError("请输入正确的账号");
        } else if (!validatePassword(password)) {
            pwdInputLayout.setErrorEnabled(true);
            pwdInputLayout.setError("密码字数过少！");
        } else {
            usernameInputLayout.setErrorEnabled(false);
            pwdInputLayout.setErrorEnabled(false);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            PreferenceManager.getInstance().setLoginAccount(username);
            PreferenceManager.getInstance().setLoginPassword(password);
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    public void onNetDisconnected() {
        Log.i(TAG, "net disconnected!");
        Toast.makeText(LoginActivity.this, "网络已经断开", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNetConnected(NetworkType networkType) {
        Log.i(TAG, "net is connected!");
        Toast.makeText(LoginActivity.this, "网络已经连接成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        NetworkStateChangeReceiver.unRegisterObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetworkStateChangeReceiver.unRegisterReceiver(LoginActivity.this);
    }
}
