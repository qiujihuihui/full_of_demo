package com.module.demo.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/**
 * @author Shenhui
 * @version 1.0
 * @since 2021/3/3  9:33
 */
public class RemoteService extends Service
{
    private static final String TAG = "binder_sample";

    BinderMessage binderMessage;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "[RemoteService] onCreate");
        initMessage();
    }

    private void initMessage() {
        binderMessage = new BinderMessage();
        binderMessage.setMessage("this is a message of test data");
        binderMessage.setMessageId(12);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "[RemoteService] onBind");
        return remoteService;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "[RemoteService] onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "[RemoteService] onDestroy");
        super.onDestroy();
    }

    private final IRemoteService.Stub remoteService = new IRemoteService.Stub() {
        @Override
        public int getPid() {
            Log.i(TAG, "[RemoteService] getPid()=" + android.os.Process.myPid());
            return android.os.Process.myPid();
        }

        @Override
        public BinderMessage getBinderMessage() {
            Log.i(TAG, "[RemoteService] getBinderMessage()" + binderMessage.toString());
            return binderMessage;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            // 可用于权限拦截
            return super.onTransact(code, data, reply, flags);
        }
    };
}
