package com.daemon.providerrrrrrs;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class DaemonProvider extends BaseProvider {

    public static Context f3161a;

    public static Application a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("getApplication", new Class[0]);
            declaredMethod2.setAccessible(true);
            return (Application) declaredMethod2.invoke(invoke, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Context b() {
        if (f3161a == null) {
            Application c2 = c();
            f3161a = c2;
            if (c2 == null) {
                f3161a = a();
            }
        }
        return f3161a;
    }

    public static Application c() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override
    public Bundle call(String str, String str2, Bundle bundle) {
        return super.call(str, str2, bundle);
    }
}
