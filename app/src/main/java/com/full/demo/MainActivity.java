package com.full.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.full.demo.businessdemo.BaseTestActivity;

public class MainActivity extends AppCompatActivity {

    private Button clickBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickBtn = findViewById(R.id.btn_click);
        clickBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BaseTestActivity.class)));
    }
}
