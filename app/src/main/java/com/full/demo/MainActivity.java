package com.full.demo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.full.demo.businessdemo.manager.NotificationHelper;
import com.full.demo.businessdemo.manager.PermissionHelper;

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
        clickBtn.setOnClickListener(view -> initClickListener());
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
//        DrawerLayout drawerLayout = findViewById(R.id.dl_layout);
//        TextView closeDrawer = findViewById(R.id.tv_drawer_close);
//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.toolbar_title_setting, R.string.toolbar_title_share);
//        drawerToggle.syncState();
//        drawerLayout.setDrawerListener(drawerToggle);
//        closeDrawer.setOnClickListener(view -> drawerLayout.closeDrawer(Gravity.RIGHT));
    }

    private void initClickListener(){
        PermissionHelper.call(MainActivity.this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionHelper.dealPermissionsResult(MainActivity.this, requestCode, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
