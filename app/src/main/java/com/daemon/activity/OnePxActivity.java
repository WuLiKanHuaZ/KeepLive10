package com.daemon.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public final class OnePxActivity extends AppCompatActivity {

    public Handler f3160r = new Handler(Looper.getMainLooper());

    public void K() {
        moveTaskToBack(true);
    }

    public void L() {
        try {
            if (((PowerManager) getApplicationContext().getSystemService(Context.POWER_SERVICE)).isScreenOn()) {
                this.f3160r.postDelayed(new Runnable() {
                    @Override
                    public final void run() {
                        OnePxActivity.this.K();
                    }
                }, 1500L);
            }
        } catch (Exception unused) {
            moveTaskToBack(true);
        }
    }

    public void M() {
        getWindow().clearFlags(201326592);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(8388659);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        M();
    }

    @Override
    public void onResume() {
        super.onResume();
        L();
    }
}
