package com.full.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * 使用layout()方法自定义View的滑动
 */
public class FirstCustomView extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public FirstCustomView(Context context) {
        super(context);
    }

    public FirstCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public FirstCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取手指触摸点的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                // user layout() to refresh new position
                // one
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);

                // two
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

                // three
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY, int duration){
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        int scrollY = getScrollY();
        int deltaY = destY - scrollY;
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, duration);
        invalidate();
    }
}
