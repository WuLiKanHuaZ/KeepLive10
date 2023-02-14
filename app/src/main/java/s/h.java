package s;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.util.ArrayList;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class h {
    public boolean A;
    public String B;
    public Bundle C;
    public Notification F;
    public RemoteViews G;
    public RemoteViews H;
    public RemoteViews I;
    public String J;
    public String L;
    public long M;
    public boolean O;
    public Notification P;
    public boolean Q;
    public Icon R;
    @Deprecated
    public ArrayList<String> S;

    /* renamed from: a  reason: collision with root package name */
    public Context f8075a;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f8079e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f8080f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f8081g;

    /* renamed from: h  reason: collision with root package name */
    public PendingIntent f8082h;

    /* renamed from: i  reason: collision with root package name */
    public RemoteViews f8083i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f8084j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f8085k;

    /* renamed from: l  reason: collision with root package name */
    public int f8086l;

    /* renamed from: m  reason: collision with root package name */
    public int f8087m;

    /* renamed from: o  reason: collision with root package name */
    public boolean f8089o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f8090p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f8091q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence[] f8092r;

    /* renamed from: s  reason: collision with root package name */
    public int f8093s;

    /* renamed from: t  reason: collision with root package name */
    public int f8094t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f8095u;

    /* renamed from: v  reason: collision with root package name */
    public String f8096v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f8097w;

    /* renamed from: x  reason: collision with root package name */
    public String f8098x;

    /* renamed from: z  reason: collision with root package name */
    public boolean f8100z;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<f> f8076b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<l> f8077c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<f> f8078d = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    public boolean f8088n = true;

    /* renamed from: y  reason: collision with root package name */
    public boolean f8099y = false;
    public int D = 0;
    public int E = 0;
    public int K = 0;
    public int N = 0;

    public h(Context context, String str) {
        Notification notification = new Notification();
        this.P = notification;
        this.f8075a = context;
        this.J = str;
        notification.when = System.currentTimeMillis();
        this.P.audioStreamType = -1;
        this.f8087m = 0;
        this.S = new ArrayList<>();
        this.O = true;
    }

    public Notification a() {
        return new i(this).b();
    }

    public Bundle b() {
        if (this.C == null) {
            this.C = new Bundle();
        }
        return this.C;
    }

    public h c(RemoteViews remoteViews) {
        this.P.contentView = remoteViews;
        return this;
    }

    public h d(RemoteViews remoteViews) {
        this.H = remoteViews;
        return this;
    }

    public h e(RemoteViews remoteViews) {
        this.G = remoteViews;
        return this;
    }

    public h f(RemoteViews remoteViews) {
        this.I = remoteViews;
        return this;
    }

    public h g(int i2) {
        Notification notification = this.P;
        notification.defaults = i2;
        if ((i2 & 4) != 0) {
            notification.flags |= 1;
        }
        return this;
    }

    public final void h(int i2, boolean z2) {
        if (z2) {
            Notification notification = this.P;
            notification.flags = i2 | notification.flags;
            return;
        }
        Notification notification2 = this.P;
        notification2.flags = (~i2) & notification2.flags;
    }

    public h i(PendingIntent pendingIntent, boolean z2) {
        this.f8082h = pendingIntent;
        h(128, z2);
        return this;
    }

    public h j(boolean z2) {
        h(2, z2);
        return this;
    }

    public h k(int i2) {
        this.f8087m = i2;
        return this;
    }

    public h l(int i2) {
        this.P.icon = i2;
        return this;
    }

    public h m(Uri uri) {
        Notification notification = this.P;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        return this;
    }

    public h n(long[] jArr) {
        this.P.vibrate = jArr;
        return this;
    }

    public h o(long j2) {
        this.P.when = j2;
        return this;
    }
}
