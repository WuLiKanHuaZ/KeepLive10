package com.daemon.services;

import static android.media.AudioAttributes.USAGE_ASSISTANCE_ACCESSIBILITY;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.knight.cleaning.R;

import s0.NotificationIdConst;
import t0.b;
import v0.e;


public class GuardService extends BaseService {

    public MediaPlayer f3177a;

    public final void b() {
        try {
            c();
            if (!e.f() && !e.g()) {
                MediaPlayer create = MediaPlayer.create(getApplication(), R.raw.keeplive);
                this.f3177a = create;
                create.setWakeMode(getApplicationContext(), 1);
                this.f3177a.setVolume(1.0f, 1.0f);
                this.f3177a.setLooping(true);
                this.f3177a.setAudioAttributes(new AudioAttributes.Builder().setUsage(USAGE_ASSISTANCE_ACCESSIBILITY).build());
                this.f3177a.start();
                return;
            }
            MediaPlayer create2 = MediaPlayer.create(getApplication(), R.raw.keeplive);
            this.f3177a = create2;
            create2.setWakeMode(getApplicationContext(), 1);
            this.f3177a.setVolume(0.0f, 0.0f);
            this.f3177a.setLooping(true);
            this.f3177a.setAudioAttributes(new AudioAttributes.Builder().setUsage(USAGE_ASSISTANCE_ACCESSIBILITY).build());
            this.f3177a.start();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        MediaPlayer mediaPlayer = this.f3177a;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.stop();
            this.f3177a.release();
            this.f3177a = null;
        } catch (Exception unused) {
            this.f3177a = null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Integer num = NotificationIdConst.f8125a;
                int intValue = num.intValue();
                startForeground(intValue, a());
            }
        }catch (Exception e){
            ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(NotificationIdConst.f8125a,a());
        }
        b.a().h(this, "keep");
    }

    @Override // android.app.Service
    public void onDestroy() {
        c();
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
//        return START_STICKY;
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        b();
        return super.onStartCommand(intent, flags, startId);
    }
}
