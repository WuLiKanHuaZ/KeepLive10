package s;

import android.os.Bundle;

import androidx.core.graphics.drawable.IconCompat;

/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f8110a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f8111b = new Object();

    public static Bundle a(f fVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat d2 = fVar.d();
        bundle2.putInt("icon",  0);
        bundle2.putCharSequence("title", fVar.h());
        bundle2.putParcelable("actionIntent", fVar.a());
        if (fVar.c() != null) {
            bundle = new Bundle(fVar.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", fVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", c(fVar.e()));
        bundle2.putBoolean("showsUserInterface", fVar.g());
        bundle2.putInt("semanticAction", fVar.f());
        return bundle2;
    }

    public static Bundle b(m mVar) {
        new Bundle();
        throw null;
    }

    public static Bundle[] c(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            m mVar = mVarArr[i2];
            bundleArr[i2] = b(null);
        }
        return bundleArr;
    }
}
