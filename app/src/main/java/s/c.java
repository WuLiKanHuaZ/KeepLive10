package s;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;

/* compiled from: AlarmManagerCompat.java */
/* loaded from: classes.dex */
public final class c {
    public static void a(AlarmManager alarmManager, int i2, long j2, PendingIntent pendingIntent) {
        alarmManager.setExact(i2, j2, pendingIntent);
    }

    public static void b(AlarmManager alarmManager, int i2, long j2, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(i2, j2, pendingIntent);
        } else {
            a(alarmManager, i2, j2, pendingIntent);
        }
    }
}
