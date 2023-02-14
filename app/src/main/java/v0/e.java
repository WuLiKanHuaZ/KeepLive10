package v0;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: ModelUtil.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f8213a = {"huawei", "honor"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f8214b = {"vivo", "iqoo"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f8215c = {"xiaomi", "redmi"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f8216d = {"oppo", "realme", "oneplus"};

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static boolean c() {
        return d(a(), b(), f8213a);
    }

    public static boolean d(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e() {
        return d(a(), b(), f8216d);
    }

    public static boolean f() {
        return d(a(), b(), f8214b);
    }

    public static boolean g() {
        return d(a(), b(), f8215c);
    }
}
