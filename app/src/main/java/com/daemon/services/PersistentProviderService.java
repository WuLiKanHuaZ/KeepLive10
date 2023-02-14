package com.daemon.services;


import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;

import s0.NotificationIdConst;
import t0.b;


public class PersistentProviderService extends BaseService {
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            Integer num = NotificationIdConst.f8125a;
            startForeground(num.intValue(), a());
        }
        b.a().h(this, "loop");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //    @Override // android.app.Service
//    public int onStartCommand(Intent intent, int i2, int i3) {
//        return 1;
//    }
}
