package t;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.knight.cleaning.App;

import java.io.File;

/* compiled from: ContextCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f8129a = new Object();

    public static int a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i2);
        }
        return context.getResources().getColor(i2);
    }

    public static ColorStateList b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        return context.getResources().getColorStateList(i2);
    }

    public static Drawable c(Context context, int i2) {
        return context.getDrawable(i2);
    }

    public static File[] d(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] e(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static boolean f(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void g(Context context, Intent intent,String authorities) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            contentResolver.call(Uri.parse("content://" +authorities), intent.getComponent().getClassName(), (String) null, (Bundle) null);
        } catch (Exception unused) {

        }
    }
}
