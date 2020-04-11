package com.full.demo;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.full.demo.businessdemo.manager.NotificationHelper;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void initViews() {
        Button clickBtn = findViewById(R.id.btn_click);
        clickBtn.setOnClickListener(view -> NotificationHelper.showHangNotification(MainActivity.this));
        Toolbar toolbar = findViewById(R.id.common_toolbar);
        toolbar.setTitle(R.string.toolbar_title_main_page);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
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
}
