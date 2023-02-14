package com.daemon.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;


public class ScheduledService extends Service {

    public static final Integer f3179b = 345;

    public static final Long f3180c = 10000L;

    public Handler f3181a = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message message) {
            if (message.what == 345) {
                t.a.g(ScheduledService.this, new Intent(ScheduledService.this, AssistantProviderService.class),getApplicationContext().getPackageName()+".keep.p1");
                t.a.g(ScheduledService.this, new Intent(ScheduledService.this, PersistentProviderService.class),getApplicationContext().getPackageName()+".keep.p2");
                sendEmptyMessageDelayed(ScheduledService.f3179b.intValue(), ScheduledService.f3180c.longValue());
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private long showTime = 0;

    @Override
    public int onStartCommand(Intent intent, int i2, int i3) {
        showTime = System.currentTimeMillis();
        this.f3181a.sendEmptyMessageDelayed(f3179b.intValue(), f3180c.longValue());
        return super.onStartCommand(intent, i2, i3);
    }


}
