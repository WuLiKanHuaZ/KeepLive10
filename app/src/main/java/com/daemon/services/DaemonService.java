package com.daemon.services;

import android.app.Service;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;

import androidx.annotation.Nullable;

import s0.NotificationIdConst;
import t0.b;

public class DaemonService extends BaseService {

    public final DisplayManager.DisplayListener f3174a = new a();

    public class a implements DisplayManager.DisplayListener {

        public boolean f3175a = true;

        public a() {
        }

        @Override
        public void onDisplayAdded(int i2) {
        }

        @Override
        public void onDisplayChanged(int i2) {
            PowerManager powerManager = (PowerManager) DaemonService.this.getApplicationContext().getSystemService(POWER_SERVICE);
            if (this.f3175a == powerManager.isScreenOn()) {
                return;
            }
            if (powerManager.isScreenOn()) {
                HandleService.a(DaemonService.this, "android.intent.action.SCREEN_ON");
            } else {
                HandleService.a(DaemonService.this, "android.intent.action.SCREEN_OFF");
            }
            this.f3175a = powerManager.isScreenOn();
        }

        @Override
        public void onDisplayRemoved(int i2) {
        }
    }

    public void b() {
        ((DisplayManager) getSystemService(DISPLAY_SERVICE)).registerDisplayListener(this.f3174a, null);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            Integer num = NotificationIdConst.f8125a;
            int intValue = num.intValue();
            startForeground(intValue, a());
        }
//        c.l(this, OnePixActivity.class);
        b.a().h(this, "main");
        DaemonJobService.a(this);
        ListenerJobService.a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        ((DisplayManager) getSystemService(DISPLAY_SERVICE)).unregisterDisplayListener(this.f3174a);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    @Override // android.app.Service
//    public int onStartCommand(Intent intent, int i2, int i3) {
//        b();
//        return 1;
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        b();
        return super.onStartCommand(intent, flags, startId);
    }
}
