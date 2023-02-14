package reflection;

import android.os.Build;
import android.util.Log;

import java.lang.reflect.Method;

public final class BootstrapClass {
    private static final String TAG = "BootstrapClass";
    private static Object sVmRuntime;
    private static Method setHiddenApiExemptions;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                setHiddenApiExemptions = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                sVmRuntime = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
            } catch (Throwable th) {
                Log.w(TAG, "reflect bootstrap failed:", th);
            }
        }
    }

    public static boolean exempt(String str) {
        return false;
    }

    public static boolean exemptAll() {
        return exempt("L");
    }

    public static boolean exempt(String... strArr) {
        Method method;
        Object obj = sVmRuntime;
        if (obj != null && (method = setHiddenApiExemptions) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
