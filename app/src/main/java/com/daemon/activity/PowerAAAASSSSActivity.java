package com.daemon.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public final class PowerAAAASSSSActivity extends AppCompatActivity {
    public final void J() {
        try {
            if (((PowerManager) getApplicationContext().getSystemService(Context.POWER_SERVICE)).isScreenOn()) {
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    public void K() {
        getWindow().clearFlags(201326592);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        c.j(this);
        Window window = getWindow();
        window.setGravity(8388659);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        K();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
//            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.addFlags(67108864);
//            intent.addFlags(268435456);
//            intent.addCategory("android.intent.category.HOME");
//            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.android.settings");
        launchIntentForPackage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(launchIntentForPackage);
        J();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.onTouchEvent(motionEvent);
    }
}
