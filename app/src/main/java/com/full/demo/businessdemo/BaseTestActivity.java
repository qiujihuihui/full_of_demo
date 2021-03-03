package com.full.demo.businessdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.full.demo.R;
import com.full.demo.businessdemo.recycleview.RecyclerViewDemoFragment;

/**
 * demo的父类
 */
public class BaseTestActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_binder);
        testRecyclerViewDemo();
    }

    private void testRecyclerViewDemo() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.layout_parent);
        if (fragment == null) {
            fragment = new RecyclerViewDemoFragment();
            fragmentManager.beginTransaction().add(R.id.layout_parent, fragment).commit();
        }
    }
}
