package s;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import java.util.HashSet;
import java.util.Set;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f8112c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static Set<String> f8113d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f8114e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Context f8115a;

    /* renamed from: b  reason: collision with root package name */
    public final NotificationManager f8116b;

    public k(Context context) {
        this.f8115a = context;
        this.f8116b = (NotificationManager) context.getSystemService("notification");
    }

    public static k c(Context context) {
        return new k(context);
    }

    public void a() {
        this.f8116b.cancelAll();
    }

    public void b(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8116b.createNotificationChannel(notificationChannel);
        }
    }
}
