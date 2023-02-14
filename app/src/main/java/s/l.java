package s;

import android.app.Person;
import android.os.Build;

import androidx.core.graphics.drawable.IconCompat;

/* compiled from: Person.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f8117a;

    /* renamed from: b  reason: collision with root package name */
    public IconCompat f8118b;

    /* renamed from: c  reason: collision with root package name */
    public String f8119c;

    /* renamed from: d  reason: collision with root package name */
    public String f8120d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8121e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8122f;

    public IconCompat a() {
        return this.f8118b;
    }

    public String b() {
        return this.f8120d;
    }

    public CharSequence c() {
        return this.f8117a;
    }

    public String d() {
        return this.f8119c;
    }

    public boolean e() {
        return this.f8121e;
    }

    public boolean f() {
        return this.f8122f;
    }

    public String g() {
        String str = this.f8119c;
        if (str != null) {
            return str;
        }
        if (this.f8117a != null) {
            return "name:" + ((Object) this.f8117a);
        }
        return "";
    }

    public Person h() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            return new Person.Builder().setName(c()).setIcon(null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
        }
        return null;
    }
}
