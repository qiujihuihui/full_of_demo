package com.module.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import com.module.base.net.NetStateChangeObserver;
import com.module.base.net.NetworkType;
import com.module.base.net.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 接收网络状态的变化
 * On 2020/8/31
 *
 * @author shenh
 */
public class NetworkStateChangeReceiver extends BroadcastReceiver
{
    private static final String TAG = "net";
    private static NetworkType originalType;

    private static class InstanceHolder
    {
        private static final NetworkStateChangeReceiver INSTANCE = new NetworkStateChangeReceiver();
    }

    private List<NetStateChangeObserver> observers = new ArrayList<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            NetworkType networkType = NetworkUtil.getNetworkType(context);
            Log.i(TAG, networkType.toString());
            notifyObservers(networkType);
        }
    }

    public static void registerReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(InstanceHolder.INSTANCE, intentFilter);
    }

    public static void unRegisterReceiver(Context context) {
        context.unregisterReceiver(InstanceHolder.INSTANCE);
    }

    public static void registerObserver(NetStateChangeObserver observer) {
        if (observer == null) return;
        if (!InstanceHolder.INSTANCE.observers.contains(observer)) {
            InstanceHolder.INSTANCE.observers.add(observer);
        }
    }

    public static void unRegisterObserver(NetStateChangeObserver observer) {
        if (observer == null) return;
        if (InstanceHolder.INSTANCE.observers == null) return;
        InstanceHolder.INSTANCE.observers.remove(observer);
    }

    private void notifyObservers(NetworkType networkType) {
        if (originalType != null && originalType == networkType) {
            return;
        }
        originalType = networkType;
        if (networkType == NetworkType.NETWORK_NO) {
            for (NetStateChangeObserver observer : observers) {
                observer.onNetDisconnected();
            }
        } else {
            for (NetStateChangeObserver observer : observers) {
                observer.onNetConnected(networkType);
            }
        }
    }
}
