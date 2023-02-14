package u1;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SharePreferenceUtils.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f8177a;

    public static boolean a(Context context, String str, boolean z2) {
        return b(context).getBoolean(str, z2);
    }

    public static SharedPreferences b(Context context) {
        if (f8177a == null) {
            f8177a = context.getSharedPreferences("SharePreferenceUtils", 0);
        }
        return f8177a;
    }

    public static void c(Context context, String str, boolean z2) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putBoolean(str, z2);
        edit.commit();
    }
}
