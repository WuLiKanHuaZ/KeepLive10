package com.daemon.services;

import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;

import s0.NotificationIdConst;
import t0.b;

/* loaded from: classes.dex */
public class AssistantProviderService extends BaseService {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            Integer num = NotificationIdConst.f8125a;
            startForeground(num.intValue(), a());
        }
        b.a().h(this, "listen");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
