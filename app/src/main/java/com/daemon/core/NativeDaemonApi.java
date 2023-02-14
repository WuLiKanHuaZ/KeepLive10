package com.daemon.core;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import t0.b;


public class NativeDaemonApi {
    static {
        try {
            System.loadLibrary("god");
            Log.e("NativeDaemonApi", "load so success");
        } catch (Exception e2) {
            Log.e("NativeDaemonApi", "load so fail", e2);
        }
    }

    public static native void check(Object o);

    public static native void dump(Context context, String str, String str2, String str3, String str4);

    public static native void listener(Context context, String str, int i2);

//    public static native void lockFile(String str, int i2);

    public static void onDead() {
        b.a().g();
    }

    public static native void startActivity(Context context, Intent intent, int i2);
}
