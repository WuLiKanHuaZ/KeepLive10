package com.daemon.sync.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import u0.d;
import u0.f;

/* loaded from: classes.dex */
public class SyncService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public d f3185a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        d dVar = this.f3185a;
        if (dVar == null) {
            return null;
        }
        return dVar.e();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("同步","");
        this.f3185a = new f();
    }
}
