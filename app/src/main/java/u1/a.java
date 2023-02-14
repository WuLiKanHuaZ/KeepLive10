package u1;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

/* compiled from: DeviceUtils.java */
/* loaded from: classes.dex */
public class a {
    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static String b() {
        return Build.BRAND;
    }

    public static String c() {
        return Build.MANUFACTURER;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String f() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            if ("Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString())) {
                return "Harmony_" + e("hw_sc.build.platform.version", "");
            }
            return "Android " + Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int g() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean h(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        boolean z2 = false;
        if (simState != 0 && simState != 1) {
            z2 = true;
        }
        Log.d("try", z2 ? "有SIM卡" : "无SIM卡");
        return z2;
    }

    public static boolean i() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/"};
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                String str = strArr[i2];
                File file = new File(str + "su");
                if (file.exists() && file.canExecute()) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
