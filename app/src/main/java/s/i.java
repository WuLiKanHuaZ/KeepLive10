package s;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;

import androidx.core.graphics.drawable.IconCompat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8101a;

    /* renamed from: b  reason: collision with root package name */
    public final Notification.Builder f8102b;

    /* renamed from: c  reason: collision with root package name */
    public final h f8103c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteViews f8104d;

    /* renamed from: e  reason: collision with root package name */
    public RemoteViews f8105e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f8106f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f8107g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public int f8108h;

    /* renamed from: i  reason: collision with root package name */
    public RemoteViews f8109i;

    public i(h hVar) {
        List<String> list;
        Icon icon;
        this.f8103c = hVar;
        this.f8101a = hVar.f8075a;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8102b = new Notification.Builder(hVar.f8075a, hVar.J);
        } else {
            this.f8102b = new Notification.Builder(hVar.f8075a);
        }
        Notification notification = hVar.P;
        this.f8102b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, hVar.f8083i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(hVar.f8079e).setContentText(hVar.f8080f).setContentInfo(hVar.f8085k).setContentIntent(hVar.f8081g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(hVar.f8082h, (notification.flags & 128) != 0).setLargeIcon(hVar.f8084j).setNumber(hVar.f8086l).setProgress(hVar.f8093s, hVar.f8094t, hVar.f8095u);
        this.f8102b.setSubText(hVar.f8090p).setUsesChronometer(hVar.f8089o).setPriority(hVar.f8087m);
        Iterator<f> it = hVar.f8076b.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        Bundle bundle = hVar.C;
        if (bundle != null) {
            this.f8107g.putAll(bundle);
        }
        int i2 = Build.VERSION.SDK_INT;
        this.f8104d = hVar.G;
        this.f8105e = hVar.H;
        this.f8102b.setShowWhen(hVar.f8088n);
        this.f8102b.setLocalOnly(hVar.f8099y).setGroup(hVar.f8096v).setGroupSummary(hVar.f8097w).setSortKey(hVar.f8098x);
        this.f8108h = hVar.N;
        this.f8102b.setCategory(hVar.B).setColor(hVar.D).setVisibility(hVar.E).setPublicVersion(hVar.F).setSound(notification.sound, notification.audioAttributes);
        if (i2 < 28) {
            list = d(e(hVar.f8077c), hVar.S);
        } else {
            list = hVar.S;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                this.f8102b.addPerson(str);
            }
        }
        this.f8109i = hVar.I;
        if (hVar.f8078d.size() > 0) {
            Bundle bundle2 = hVar.b().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i3 = 0; i3 < hVar.f8078d.size(); i3++) {
                bundle4.putBundle(Integer.toString(i3), j.a(hVar.f8078d.get(i3)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            hVar.b().putBundle("android.car.EXTENSIONS", bundle2);
            this.f8107g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23 && (icon = hVar.R) != null) {
            this.f8102b.setSmallIcon(icon);
        }
        if (i4 >= 24) {
            this.f8102b.setExtras(hVar.C).setRemoteInputHistory(hVar.f8092r);
            RemoteViews remoteViews = hVar.G;
            if (remoteViews != null) {
                this.f8102b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = hVar.H;
            if (remoteViews2 != null) {
                this.f8102b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = hVar.I;
            if (remoteViews3 != null) {
                this.f8102b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i4 >= 26) {
            this.f8102b.setBadgeIconType(hVar.K).setSettingsText(hVar.f8091q).setShortcutId(hVar.L).setTimeoutAfter(hVar.M).setGroupAlertBehavior(hVar.N);
            if (hVar.A) {
                this.f8102b.setColorized(hVar.f8100z);
            }
            if (!TextUtils.isEmpty(hVar.J)) {
                this.f8102b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i4 >= 28) {
            Iterator<l> it2 = hVar.f8077c.iterator();
            while (it2.hasNext()) {
                this.f8102b.addPerson(it2.next().h());
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            this.f8102b.setAllowSystemGeneratedContextualActions(hVar.O);
            this.f8102b.setBubbleMetadata(g.a(null));
        }
        if (hVar.Q) {
            if (this.f8103c.f8097w) {
                this.f8108h = 2;
            } else {
                this.f8108h = 1;
            }
            this.f8102b.setVibrate(null);
            this.f8102b.setSound(null);
            int i6 = notification.defaults & (-2) & (-3);
            notification.defaults = i6;
            this.f8102b.setDefaults(i6);
            if (i5 >= 26) {
                if (TextUtils.isEmpty(this.f8103c.f8096v)) {
                    this.f8102b.setGroup("silent");
                }
                this.f8102b.setGroupAlertBehavior(this.f8108h);
            }
        }
    }

    public static List<String> d(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        List<String> bVar = new ArrayList<>(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    public static List<String> e(List<l> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (l lVar : list) {
            arrayList.add(lVar.g());
        }
        return arrayList;
    }

    public final void a(f fVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        IconCompat d2 = fVar.d();
        if (i2 >= 23) {
            builder = new Notification.Action.Builder(null, fVar.h(), fVar.a());
        } else {
            builder = new Notification.Action.Builder(0, fVar.h(), fVar.a());
        }
        if (fVar.e() != null) {
            for (RemoteInput remoteInput : m.b(fVar.e())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (fVar.c() != null) {
            bundle = new Bundle(fVar.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", fVar.b());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            builder.setAllowGeneratedReplies(fVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", fVar.f());
        if (i3 >= 28) {
//            builder.setSemanticAction(fVar.f());
        }
        if (i3 >= 29) {
            builder.setContextual(fVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", fVar.g());
        builder.addExtras(bundle);
        this.f8102b.addAction(builder.build());
    }

    public Notification b() {
        Objects.requireNonNull(this.f8103c);
        Notification c2 = c();
        RemoteViews remoteViews = this.f8103c.G;
        if (remoteViews != null) {
            c2.contentView = remoteViews;
        }
        return c2;
    }

    public Notification c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f8102b.build();
        }
        if (i2 >= 24) {
            Notification build = this.f8102b.build();
            if (this.f8108h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f8108h == 2) {
                    f(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f8108h == 1) {
                    f(build);
                }
            }
            return build;
        }
        this.f8102b.setExtras(this.f8107g);
        Notification build2 = this.f8102b.build();
        RemoteViews remoteViews = this.f8104d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f8105e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f8109i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f8108h != 0) {
            if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f8108h == 2) {
                f(build2);
            }
            if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f8108h == 1) {
                f(build2);
            }
        }
        return build2;
    }

    public final void f(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }
}
