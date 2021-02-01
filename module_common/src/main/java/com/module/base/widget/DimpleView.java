package com.module.base.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.module.base.widget.dimple.Particle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;

/**
 * 自定义宇宙尘埃的效果
 * On 2020/10/20
 *
 * @author shenh
 */
public class DimpleView extends View
{
    private static final String TAG = "dimple";
    // 粒子集合
    private List<Particle> particleList = new ArrayList<>();
    // 定义画笔
    Paint paint;

    private float centerX;
    private float centerY;
    private Random random;

    Path path;
    // 用于测量扩散圆某一处的X、Y值
    private PathMeasure pathMeasure;
    // 扩散圆上某一点的X、Y值
    private float[] pos = new float[2];
    // 扩散圆上某一点的切线
    private float[] tan = new float[2];

    private ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);

    public DimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "DimpleView()--");
        paint = new Paint();
        path = new Path();
        pathMeasure = new PathMeasure();
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        Log.d(TAG, "onSizeChanged()--");
        centerX = (float) (w / 2);
        centerY = (float) (h / 2);
        random = new Random();
        path.addCircle(centerX, centerY, 280f, Path.Direction.CCW);
        pathMeasure.setPath(path, false);
        float nextX;
        float nextY;
        double angle;
        int offset;
        float maxOffset;
        for (int i = 0; i < 2000; i++) {
            // 按比例测量路径上每一点的值
            pathMeasure.getPosTan(i / 2000f * pathMeasure.getLength(), pos, tan);
            nextX = pos[0] + random.nextInt(6) - 3f;
            nextY = pos[1] + random.nextInt(6) - 3f;
            // 反余弦函数可以达到角度值，是弧度
            angle = Math.acos((double) ((pos[0] - centerX) / 280f));
            float speed = random.nextInt(2) + 2f;
            offset = random.nextInt(200);
            maxOffset = random.nextInt(200);
            particleList.add(new Particle(nextX, nextY, 2f, speed, 100, angle, offset, maxOffset));
        }
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw()--");
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        for (Particle particle : particleList) {
            // 设置画笔的透明度
            paint.setAlpha(particle.getAlpha());
            canvas.drawCircle(particle.getX(), particle.getY(), particle.getRadius(), paint);
        }
    }

    private void init() {
        animator.setDuration(2000);
        animator.setRepeatCount(-1);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d(TAG, "onAnimationUpdate()--");
                updateParticle();
                invalidate();
            }
        });
    }

    private void updateParticle() {
        for (Particle particle : particleList) {
            if (particle.getOffset() > particle.getMaxOffset()) {
                particle.setOffset(0);
                particle.setSpeed((float) (random.nextInt(2) + 2));
            }
            particle.setAlpha((int) (1f - particle.getOffset() / particle.getMaxOffset() * 225f));
            particle.setX((float) (centerX + Math.cos(particle.getAngle()) * (280f + particle.getOffset())));
            if (particle.getY() > centerY) {
                particle.setY((float) (Math.sin(particle.getAngle()) * (280f + particle.getOffset()) + centerY));
            } else {
                particle.setY((float) (centerY - Math.sin(particle.getAngle()) * (280f + particle.getOffset())));
            }
            particle.setOffset(particle.getOffset() + (int) particle.getSpeed());
        }
    }
}
