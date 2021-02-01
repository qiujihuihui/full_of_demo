package com.module.base.net;

/**
 * 网络状态改变观察者
 * On 2020/8/31
 *
 * @author shenh
 */
public interface NetStateChangeObserver
{
    void onNetDisconnected();

    void onNetConnected(NetworkType networkType);
}
