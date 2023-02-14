package s;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class o implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Intent> f8123a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final Context f8124b;

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        Intent g();
    }

    public o(Context context) {
        this.f8124b = context;
    }

    public static o d(Context context) {
        return new o(context);
    }

    public o a(Intent intent) {
        this.f8123a.add(intent);
        return this;
    }

    public o b(Activity activity) {
        Intent g2 = activity instanceof a ? ((a) activity).g() : null;
        if (g2 == null) {
            g2 = e.a(activity);
        }
        if (g2 != null) {
            ComponentName component = g2.getComponent();
            if (component == null) {
                component = g2.resolveActivity(this.f8124b.getPackageManager());
            }
            c(component);
            a(g2);
        }
        return this;
    }

    public o c(ComponentName componentName) {
        int size = this.f8123a.size();
        try {
            Intent b2 = e.b(this.f8124b, componentName);
            while (b2 != null) {
                this.f8123a.add(size, b2);
                b2 = e.b(this.f8124b, b2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {

            throw new IllegalArgumentException(e2);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (!this.f8123a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f8123a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (t.a.f(this.f8124b, intentArr, bundle)) {
                return;
            }
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f8124b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f8123a.iterator();
    }
}
