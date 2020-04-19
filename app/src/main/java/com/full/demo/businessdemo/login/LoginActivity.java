package com.full.demo.businessdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.full.demo.MainActivity;
import com.full.demo.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

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
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
