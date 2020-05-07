package com.full.demo.businessdemo.customview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.full.demo.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * 自定义view的页面
 */
@ContentView(R.layout.activity_first_view)
public class FirstViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
