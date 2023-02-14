package s;

import android.app.PendingIntent;
import android.os.Bundle;

import androidx.core.graphics.drawable.IconCompat;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f8065a;

    /* renamed from: b  reason: collision with root package name */
    public IconCompat f8066b;

    /* renamed from: c  reason: collision with root package name */
    public m[] f8067c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8068d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8069e;

    /* renamed from: f  reason: collision with root package name */
    public int f8070f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8071g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public int f8072h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f8073i;

    /* renamed from: j  reason: collision with root package name */
    public PendingIntent f8074j;

    public PendingIntent a() {
        return this.f8074j;
    }

    public boolean b() {
        return this.f8068d;
    }

    public Bundle c() {
        return this.f8065a;
    }

    public IconCompat d() {
        int i2;
        if (this.f8066b == null && (i2 = this.f8072h) != 0) {
            this.f8066b = IconCompat.createWithResource(null, "", i2);
        }
        return this.f8066b;
    }

    public m[] e() {
        return this.f8067c;
    }

    public int f() {
        return this.f8070f;
    }

    public boolean g() {
        return this.f8069e;
    }

    public CharSequence h() {
        return this.f8073i;
    }

    public boolean i() {
        return this.f8071g;
    }
}
