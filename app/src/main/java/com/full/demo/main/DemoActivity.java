package com.full.demo.main;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.full.demo.R;
import com.module.base.glide.GlideUtils;
import com.module.base.widget.DimpleView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 用于测试的Demo主页
 * On 2020/10/20
 */
public class DemoActivity extends AppCompatActivity
{
    DimpleView dimpleView;
    ImageView centerImg;

    private ObjectAnimator animator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        dimpleView = findViewById(R.id.dimple_view);
        centerImg = findViewById(R.id.img_center);
        animator = ObjectAnimator.ofFloat(centerImg, View.ROTATION, 0f, 360f);
        animator.setDuration(6000);
        animator.setRepeatCount(-1);
        animator.setInterpolator(new LinearInterpolator());
        GlideUtils.loadCircleAvatar(DemoActivity.this, R.mipmap.demo_car, centerImg);
        centerImg.setOnClickListener(v -> animator.start());
    }
}
