package com.full.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 自定义Behavior
 */
public class MyFooterBehavior1 extends CoordinatorLayout.Behavior<View> {

    // 列表滑动时的距离
    private float deltaY;

    public MyFooterBehavior1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.i("tag", "getHeight():" + child.getHeight());
        if (deltaY == 0) {
            deltaY = dependency.getY() - child.getHeight();
        }
        Log.i("tag", "getY():" + dependency.getY());
        float dy = dependency.getY() - child.getHeight();
        dy = dy <= 80 ? 0 : dy;
        float y = child.getHeight() - (dy / deltaY) * child.getHeight();
        Log.i("tag", "dy:" + dy + "  y:" + y);
        child.setTranslationY(y);
        return true;
    }
}
