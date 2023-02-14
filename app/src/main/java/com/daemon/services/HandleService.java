package com.daemon.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class HandleService extends IntentService {
    public HandleService() {
        super("HandleService");
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, HandleService.class);
        intent.setAction(str);
        context.startService(intent);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.SCREEN_OFF")) {
//                c.l(this, OnePixActivity.class);
            } else if (action.equals("heart")) {
                SystemClock.sleep(10000L);
                a(this, "heart");
            }
        }
    }
}
