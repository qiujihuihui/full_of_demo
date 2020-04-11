package com.full.demo.businessdemo.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.full.demo.R;
import com.full.demo.businessdemo.BaseTestActivity;

/**
 * 展示通知栏
 */
public class NotificationHelper {

    // Android 5.0、5.1(21、22)
    public static void showNotificationWithCustomView(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/")), 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        builder.setContentTitle("折叠式通知");
        builder.setContentText("测试一下折叠式通知");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.view_custom_notification_fold);
        Notification notification = builder.build();
//        notification.contentView = remoteViews;
        notification.bigContentView = remoteViews;
        getNotificationManager(context).notify(randomNotifyId(), notification);
    }

    // Android 5.0、5.1(21、22)
    public static void showHangNotification(Context context){
        Notification.Builder builder = new Notification.Builder(context);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/")), 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        builder.setContentTitle("悬挂式通知");
        builder.setContentText("测试一下悬挂式通知");
        // 设置点击跳转
        Intent hangIntent = new Intent();
        hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hangIntent.setClass(context, BaseTestActivity.class);
        PendingIntent hangPending = PendingIntent.getActivity(context, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(hangPending, true);
        getNotificationManager(context).notify(randomNotifyId(), builder.build());
    }

    // Higher Android System Version
    public static void showHigherVersionNotification(Context context) {
        //通知渠道的ID
        String id = "channel_demo";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //用户可以看到的通知渠道的名字
            CharSequence name = context.getString(R.string.app_name);
            //用户可看到的通知描述
            String description = context.getString(R.string.main_click_test);
            //构建NotificationChannel实例
            NotificationChannel notificationChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
            //配置通知渠道的属性
            notificationChannel.setDescription(description);
            //设置通知出现时的闪光灯
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            //设置通知出现时的震动
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 100});
            //在notificationManager中创建通知渠道
            getNotificationManager(context).createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, id);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/")), 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        builder.setContentTitle("我点击了主页面的按钮");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setGroupSummary(false).setGroup("group");
        }
        Notification notification = builder.build();
        getNotificationManager(context).notify(randomNotifyId(), notification);
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    private static int randomNotifyId() {
        return 1 + (int) (Math.random() * 2147483646);
    }
}
