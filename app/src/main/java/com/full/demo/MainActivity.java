package com.full.demo;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.full.demo.businessdemo.manager.NotificationHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickBtn = findViewById(R.id.btn_click);
        clickBtn.setOnClickListener(view -> NotificationHelper.showHangNotification(MainActivity.this));
    }

}
