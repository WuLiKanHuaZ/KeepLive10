package com.daemon.sync.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import t0.a;

/* loaded from: classes.dex */
public class AuthService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public a f3183a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if ("android.accounts.AccountAuthenticator".equals(intent.getAction())) {
            return this.f3183a.getIBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3183a = new a(this);
    }
}
