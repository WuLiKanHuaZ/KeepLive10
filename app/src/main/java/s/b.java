package s;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class b {

    public static final Class<?> f8046a;

    public static final Field f8047b;

    public static final Field f8048c;

    public static final Method f8049d;

    public static final Method f8050e;

    public static final Method f8051f;

    public static final Handler f8052g = new Handler(Looper.getMainLooper());

    public static class a implements Runnable {

        public final d f8053a;

        public final Object f8054b;

        public a(d dVar, Object obj) {
            this.f8053a = dVar;
            this.f8054b = obj;
        }

        @Override
        public void run() {
            this.f8053a.f8059a = this.f8054b;
        }
    }

    public static class RunnableC0099b implements Runnable {

        public final Application f8055a;

        public final d f8056b;

        public RunnableC0099b(Application application, d dVar) {
            this.f8055a = application;
            this.f8056b = dVar;
        }

        @Override
        public void run() {
            this.f8055a.unregisterActivityLifecycleCallbacks(this.f8056b);
        }
    }

    public static class c implements Runnable {

        public final Object f8057a;

        public final Object f8058b;

        public c(Object obj, Object obj2) {
            this.f8057a = obj;
            this.f8058b = obj2;
        }

        @Override
        public void run() {
            try {
                Method method = b.f8049d;
                if (method != null) {
                    method.invoke(this.f8057a, this.f8058b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    b.f8050e.invoke(this.f8057a, this.f8058b, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {

            }
        }
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {

        public Object f8059a;

        public Activity f8060b;

        public final int f8061c;

        public boolean f8062d = false;

        public boolean f8063e = false;

        public boolean f8064f = false;

        public d(Activity activity) {
            this.f8060b = activity;
            this.f8061c = activity.hashCode();
        }

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            if (this.f8060b == activity) {
                this.f8060b = null;
                this.f8063e = true;
            }
        }

        @Override
        public void onActivityPaused(Activity activity) {
            if (!this.f8063e || this.f8064f || this.f8062d || !b.h(this.f8059a, this.f8061c, activity)) {
                return;
            }
            this.f8064f = true;
            this.f8059a = null;
        }

        @Override
        public void onActivityResumed(Activity activity) {
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override
        public void onActivityStarted(Activity activity) {
            if (this.f8060b == activity) {
                this.f8062d = true;
            }
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a2 = a();
        f8046a = a2;
        f8047b = b();
        f8048c = f();
        f8049d = d(a2);
        f8050e = c(a2);
        f8051f = e(a2);
    }

    public static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    public static boolean h(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f8048c.get(activity);
            if (obj2 == obj && activity.hashCode() == i2) {
                f8052g.postAtFrontOfQueue(new c(f8047b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {

            return false;
        }
    }

    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f8051f == null) {
            return false;
        } else {
            if (f8050e == null && f8049d == null) {
                return false;
            }
            try {
                Object obj2 = f8048c.get(activity);
                if (obj2 == null || (obj = f8047b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                d dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f8052g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f8051f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new RunnableC0099b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
