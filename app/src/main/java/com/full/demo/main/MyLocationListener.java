package com.full.demo.main;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 *  one Observer of Lifecycle
 */
public class MyLocationListener implements LifecycleObserver
{
    private OnLocationChangeListener changeListener;

    MyLocationListener(OnLocationChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startGetLocation() {
        if (changeListener != null) {
            changeListener.onChanged(12.02, 13.03);
            changeListener.positionChanged("执行了ON_RESUME");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void goOnGetLocation() {
        if (changeListener != null) {
            changeListener.onChanged(22.02, 23.03);
            changeListener.positionChanged("Goon执行了ON_RESUME");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stopGetLocation() {
        if (changeListener != null) {
            changeListener.onChanged(20.02, 30.03);
            changeListener.positionChanged("执行了ON_PAUSE");
        }
    }

    public interface OnLocationChangeListener {
        void onChanged(double latitude, double longitude);
        void positionChanged(String message);
    }
}
