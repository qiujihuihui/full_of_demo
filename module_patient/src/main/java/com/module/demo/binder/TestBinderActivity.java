package com.module.demo.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.module.demo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Shenhui
 * @version 1.0
 * @since 2021/3/2  15:16
 */
public class TestBinderActivity extends AppCompatActivity
{
    private static final String TAG = "binder_sample";

    Button bindButton;
    Button unbindButton;
    Button killButton;
    TextView txtView;

    private IRemoteService remoteService;
    private boolean isBound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "[TestBinderActivity] onCreate");
        setContentView(R.layout.activity_test_binder);
        bindButton = findViewById(R.id.btn_bind_service);
        unbindButton = findViewById(R.id.btn_unbind_service);
        killButton = findViewById(R.id.btn_kill_service);
        txtView = findViewById(R.id.txt_bottom);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onViewClicked();
    }

    private final ServiceConnection connection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            remoteService = IRemoteService.Stub.asInterface(service);
            String pidInfo = null;
            try {
                BinderMessage message = remoteService.getBinderMessage();
                pidInfo = "pid=" + remoteService.getPid() +
                        ", messageId=" + message.getMessageId() +
                        ", message=" + message.getMessage();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "[TestBinderActivity] onServiceConnected");
            showText(pidInfo);
            Toast.makeText(TestBinderActivity.this, "remote service connected success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "[TestBinderActivity] onServiceDisconnected");
            showText("remote service disconnect");
            remoteService = null;
            Toast.makeText(TestBinderActivity.this, "remote service disconnected", Toast.LENGTH_SHORT).show();
        }
    };

    private void bindRemoteService() {
        Log.i(TAG, "[TestBinderActivity] bindRemoteService");
        Intent intent = new Intent(TestBinderActivity.this, RemoteService.class);
        intent.setAction(IRemoteService.class.getName());
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
        isBound = true;
        showText("bind success");
    }

    private void unbindRemoteService() {
        if (!isBound) return;
        Log.i(TAG, "[TestBinderActivity] unbindRemoteService");
        unbindService(connection);
        isBound = false;
        showText("unbind success");
    }

    private void killRemoteService() {
        Log.i(TAG, "[TestBinderActivity] killRemoteService");
        try {
            android.os.Process.killProcess(remoteService.getPid());
            showText("has killed the remote service success");
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(TestBinderActivity.this, "kill remote service failure", Toast.LENGTH_SHORT).show();
        }
    }

    private void onViewClicked() {
        bindButton.setOnClickListener(v -> bindRemoteService());
        unbindButton.setOnClickListener(v -> unbindRemoteService());
        killButton.setOnClickListener(v -> killRemoteService());
    }

    private void showText(String message) {
        txtView.setText(message);
    }
}
