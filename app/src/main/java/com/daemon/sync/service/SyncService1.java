package com.daemon.sync.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import u0.d;
import u0.e;

/* loaded from: classes.dex */
public class SyncService1 extends Service {

    /* renamed from: a  reason: collision with root package name */
    public d f3186a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        d dVar = this.f3186a;
        if (dVar == null) {
            return null;
        }
        return dVar.e();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3186a = new e();
    }
}
