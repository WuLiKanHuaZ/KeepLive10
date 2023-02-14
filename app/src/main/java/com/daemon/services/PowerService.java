package com.daemon.services;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;

import s.k;
import s0.NotificationIdConst;

public class PowerService extends BaseService {
    public final void b() {
        try {
            if (((PowerManager) getApplicationContext().getSystemService(POWER_SERVICE)).isScreenOn()) {
                return;
            }
        } catch (Exception unused) {

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            Integer num = NotificationIdConst.f8125a;
            int intValue = num.intValue();
            startForeground(intValue, a());
        }
    }

    @Override
    public void onDestroy() {
        k.c(this).a();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        b();
        return super.onStartCommand(intent, flags, startId);
    }
}
