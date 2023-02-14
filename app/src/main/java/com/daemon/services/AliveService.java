package com.daemon.services;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

import androidx.annotation.Nullable;

import com.daemon.core.NativeDaemonApi;
import com.knight.cleaning.R;

import s0.NotificationIdConst;
import t0.b;

public class AliveService extends BaseService {

    public MediaPlayer mediaPlayer;
    public Thread aThread = new AThread();

    /* loaded from: classes.dex */
    public class AThread extends Thread {
        public AThread() {
        }

        @Override
        public void run() {
            try {
                Process.setThreadPriority(-2);
                do {

                } while ((AliveService.this.getPackageManager().getApplicationInfo(AliveService.this.getPackageName(), 128).flags & 2097152) == 0);
                Log.d("被杀","");
                NativeDaemonApi.onDead();
                NativeDaemonApi.check("");
            } catch (Exception unused) {

            }
        }
    }

    public final void startMedia() {
        try {
            stopMedia();
            MediaPlayer create2 = MediaPlayer.create(getApplication(), R.raw.keeplive);
            this.mediaPlayer = create2;
            create2.setWakeMode(getApplicationContext(), 1);
            this.mediaPlayer.setVolume(0.0f, 0.0f);
            this.mediaPlayer.setLooping(true);
            this.mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(11).build());
            this.aThread.start();
        } catch (Throwable unused) {
        }
    }

    public void stopMedia() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        } catch (Exception unused) {
            this.mediaPlayer = null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            Integer num = NotificationIdConst.f8125a;
            int intValue = num.intValue();
            startForeground(intValue, a());
        }
        b.a().h(this, "watch");
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopMedia();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startMedia();
        return super.onStartCommand(intent, flags, startId);
    }
}
