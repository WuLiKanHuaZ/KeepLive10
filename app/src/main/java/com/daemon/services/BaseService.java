package com.daemon.services;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;

import com.knight.cleaning.R;

public class BaseService extends Service {
    public final Notification a() {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("48098DDD", "可关闭通知", 3);
            notificationChannel.setLightColor(-16711936);
            notificationChannel.setShowBadge(false);
            notificationChannel.setDescription("");
            notificationChannel.enableLights(false);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(this, "48098DDD");
        } else {
            builder = new Notification.Builder(this);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return builder.setContentTitle("保活")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .build();
        }else {
            return builder.setContentTitle("保活")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .build();
        }
    }

    // 隐藏Notification
    public void hideNotification() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
