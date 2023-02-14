package u1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

/* compiled from: NotificationUtils.java */
/* loaded from: classes.dex */
public class b {
    public static NotificationChannel a(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("custom");
            if (notificationChannel != null) {
                return notificationChannel;
            }
            NotificationChannel notificationChannel2 = new NotificationChannel("alive", "aliveNotification", 4);
            notificationManager.createNotificationChannel(notificationChannel2);
            return notificationChannel2;
        }
        return null;
    }

    public static Notification b() {
        return null;
//        Notification.Builder builder;
//        if (Build.VERSION.SDK_INT >= 26) {
//            builder = new Notification.Builder(MyApplication.a(), a(MyApplication.a()).getId());
//        } else {
//            builder = new Notification.Builder(MyApplication.a());
//        }
//        Intent intent = new Intent();
//        intent.addCategory("android.intent.category.LAUNCHER");
//        intent.setClass(MyApplication.a(), MainActivity.class);
//        intent.setFlags(270532608);
//        builder.setContent(new RemoteViews(MyApplication.a().getPackageName(), (int) R.layout.notify_alive)).setWhen(System.currentTimeMillis()).setContentIntent(PendingIntent.getActivity(MyApplication.a(), 0, intent, 134217728)).setSmallIcon(R.mipmap.icon_notify).setAutoCancel(true);
//        return builder.build();
    }
}
