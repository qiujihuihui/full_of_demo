package com.full.demo.main;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 *  one Observer of Lifecycle
 */
public class MyLocationListener implements LifecycleObserver
{
    private final String TAG = "LocationListener";

    private Activity mActivity;
    private OnLocationChangeListener changeListener;

    MyLocationListener(Activity activity, OnLocationChangeListener changeListener) {
        this.mActivity = activity;
        this.changeListener = changeListener;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startGetLocation() {
        Log.d(TAG, "ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stopGetLocation() {
        Log.d(TAG, "ON_PAUSE");
    }

    public interface OnLocationChangeListener {
        void onChanged(double latitude, double longitude);
    }
}
