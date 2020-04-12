package com.full.demo.businessdemo.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;

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

    // >= Android 8.0 (26)
    public static void showHigherVersionNotification(Context context) {
        String notificationChannelId = createNotificationChannel(context);
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(createPersonMe(context)).setConversationTitle("full_demo");
        NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message("你好，我正在测试通知", 1528490645998l, createPersonHim(context));
        messagingStyle.addMessage(message);
        // 只有一条消息
        messagingStyle.setGroupConversation(false);
        Intent notifyIntent = new Intent(context, BaseTestActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(BaseTestActivity.class);
        stackBuilder.addNextIntent(notifyIntent);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

//        String replyLabel = context.getString(R.string.toolbar_title_setting);
//        RemoteInput remoteInput = new RemoteInput.Builder(MessagingIntentService.EXTRA_REPLY)
//                .setLabel(replyLabel)
//                // Use machine learning to create responses based on previous messages.
//                .setChoices(messagingStyleCommsAppData.getReplyChoicesBasedOnLastMessage())
//                .build();

//        PendingIntent replyActionPendingIntent;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            Intent intent = new Intent(this, MessagingIntentService.class);
//            intent.setAction(MessagingIntentService.ACTION_REPLY);
//            replyActionPendingIntent = PendingIntent.getService(this, 0, intent, 0);
//
//        } else {
//            replyActionPendingIntent = mainPendingIntent;
//        }
//        NotificationCompat.Action replyAction =
//                new NotificationCompat.Action.Builder(
//                        R.drawable.ic_reply_white_18dp,
//                        replyLabel,
//                        replyActionPendingIntent)
//                        .addRemoteInput(remoteInput)
//                        .setShowsUserInterface(false)
//                        // Allows system to generate replies by context of conversation.
//                        .setAllowGeneratedReplies(true)
//                        .setSemanticAction(Action.SEMANTIC_ACTION_REPLY)
//                        .build();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext(), notificationChannelId);
        builder.setStyle(messagingStyle);
        builder.setContentTitle("demo应用");
        builder.setContentText("我点击了主页面的按钮");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.demo_pic1));
        builder.setContentIntent(pendingIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setColor(ContextCompat.getColor(context.getApplicationContext(), R.color.colorPrimary));
        builder.setCategory(Notification.CATEGORY_MESSAGE);
        builder.setAutoCancel(true);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            builder.setGroupSummary(false).setGroup("group");
//        }
        builder.addPerson(createPersonHim(context).getUri());
        Notification notification = builder.build();
        getNotificationManager(context).notify(randomNotifyId(), notification);
    }

    private static Person createPersonMe(Context context){
        return new Person.Builder()
                .setName("Me MacDonald")
                .setKey("1234567890")
                .setUri("tel:1234567890")
                .setIcon(IconCompat.createWithResource(context, R.mipmap.demo_pic2))
                .build();
    }

    private static Person createPersonHim(Context context){
        return new Person.Builder()
                        .setName("Wendy Wonda")
                        .setKey("2233221122")
                        .setUri("tel:2233221122")
                        .setIcon(IconCompat.createWithResource(context, R.mipmap.ic_launcher_round))
                        .build();
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    private static int randomNotifyId() {
        return 1 + (int) (Math.random() * 2147483646);
    }

    private static String createNotificationChannel(Context context){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return null;
        String channelId = "fullDemo";
        CharSequence channelName = context.getString(R.string.app_name);
        String channelDescription = "full_demo的版本O通知";
        int channelLockScreenVisibility = NotificationCompat.VISIBILITY_PUBLIC;
        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setDescription(channelDescription);
        notificationChannel.setLockscreenVisibility(channelLockScreenVisibility);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        return channelId;
    }
}
