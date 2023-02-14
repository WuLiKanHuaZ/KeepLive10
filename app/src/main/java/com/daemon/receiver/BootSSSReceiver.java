package com.daemon.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

public class BootSSSReceiver extends BroadcastReceiver {
    public final void a(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() + 60000;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, BootSSSReceiver.class), 0);
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setAndAllowWhileIdle(2, elapsedRealtime, broadcast);
        } else {
            alarmManager.set(2, elapsedRealtime, broadcast);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(context);
    }
}
