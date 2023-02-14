package t0;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.PeriodicSync;
import android.os.Build;
import android.os.Bundle;

import com.daemon.providerrrrrrs.DaemonProvider;
import com.daemon.sync.provider.AccountProvider;
import com.daemon.sync.provider.AccountProvider1;
import com.knight.cleaning.R;

import java.util.List;

/* compiled from: SyncManager.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f8140a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f8141b;

    /* renamed from: c  reason: collision with root package name */
    public static String f8142c;

    /* renamed from: d  reason: collision with root package name */
    public static String f8143d;

    /* renamed from: e  reason: collision with root package name */
    public static String f8144e;

    /* renamed from: f  reason: collision with root package name */
    public static Account f8145f;

    /* renamed from: g  reason: collision with root package name */
    public static Account f8146g;

    /* renamed from: h  reason: collision with root package name */
    public static String f8147h = AccountProvider.a();

    /* renamed from: i  reason: collision with root package name */
    public static String f8148i = AccountProvider1.a();

    static {
        Context b2 = DaemonProvider.b();
        f8141b = b2;
        f8142c = b2.getString(R.string.auth_name);
        f8144e = f8141b.getString(R.string.auth_type);
        f8140a = f8141b.getString(R.string.auth_name1);
        f8143d = f8141b.getString(R.string.auth_type1);
        f8145f = new Account(f8142c, f8144e);
        f8146g = new Account(f8140a, f8143d);
    }

    public static void a() {
        b(f8144e, f8145f, f8147h);
        b(f8143d, f8146g, f8148i);
    }

    public static void b(String str, Account account, String str2) {
        try {
            AccountManager accountManager = AccountManager.get(f8141b);
            Account[] accountsByType = accountManager.getAccountsByType(str);
            Bundle bundle = Bundle.EMPTY;
            ContentResolver.removePeriodicSync(account, str2, bundle);
            if (accountsByType == null || accountsByType.length <= 0) {
                accountManager.addAccountExplicitly(account, null, bundle);
                ContentResolver.setIsSyncable(account, str2, 1);
                ContentResolver.setSyncAutomatically(account, str2, true);
                ContentResolver.setMasterSyncAutomatically(true);
            }
            if (!ContentResolver.isSyncPending(account, str2)) {
                d(account, str2);
            }
            List<PeriodicSync> periodicSyncs = ContentResolver.getPeriodicSyncs(account, str2);
            if (periodicSyncs == null || periodicSyncs.isEmpty()) {
                ContentResolver.addPeriodicSync(account, str2, bundle, Build.VERSION.SDK_INT >= 24 ? 900L : 3600L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c() {
        d(f8145f, f8147h);
        d(f8146g, f8148i);
    }

    public static void d(Account account, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            bundle.putBoolean("expedited", true);
            bundle.putBoolean("require_charging", false);
            ContentResolver.requestSync(account, str, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
