package com.full.demo;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationManagerCompat;

import com.full.demo.businessdemo.manager.NotificationHelper;
import com.full.demo.businessdemo.manager.PermissionHelper;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;

    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initSettings();
    }

    private void initSettings(){
        notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void initViews() {
        mainLayout = findViewById(R.id.ctl_layout);
        Button clickBtn = findViewById(R.id.btn_click);
        clickBtn.setOnClickListener(view -> showSnackBar());
        Toolbar toolbar = findViewById(R.id.common_toolbar);
        toolbar.setTitle(R.string.toolbar_title_main_page);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.tb_setting:
                    Toast.makeText(MainActivity.this, "You have clicked the setting button", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_share:
                    Toast.makeText(MainActivity.this, "You have clicked the share button", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    private void initClickListener(){
        PermissionHelper.call(MainActivity.this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionHelper.dealPermissionsResult(MainActivity.this, requestCode, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showNotification() {
        boolean areNotificationsEnabled = notificationManagerCompat.areNotificationsEnabled();
        if (!areNotificationsEnabled) {
            Snackbar snackbar = Snackbar.make(mainLayout, "你需要打开通知权限", Snackbar.LENGTH_LONG)
                    .setAction("确定", view -> {
                        openNotificationSettingsForApp();
                    });
            snackbar.show();
        } else {
            NotificationHelper.showHigherVersionNotification(MainActivity.this);
        }
    }

    private void openNotificationSettingsForApp(){
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", getPackageName());
        intent.putExtra("app_uid", getApplicationInfo().uid);
        startActivity(intent);
    }

    private void showSnackBar() {
        Snackbar.make(mainLayout, "展示SnackBar", Snackbar.LENGTH_LONG).setAction("点击取消", view -> Toast.makeText(MainActivity.this, "已经取消了", Toast.LENGTH_SHORT).show()).setDuration(Snackbar.LENGTH_LONG).show();
    }
}
