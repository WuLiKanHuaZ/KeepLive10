package u0;

import android.accounts.Account;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.RemoteException;

import reflection.BootstrapClass;

/* compiled from: SyncAdapterImpl.java */
/* loaded from: classes.dex */
public class f extends d {
    public void a(c cVar, String str, Account account, Bundle bundle) throws RemoteException {
        BootstrapClass.exemptAll();
        if (bundle != null) {
            try {
                if (bundle.getBoolean("force", false)) {
                    if (bundle.getBoolean("ignore_backoff", false)) {
                        if (cVar != null) {
                            cVar.c(SyncResult.ALREADY_IN_PROGRESS);
                            return;
                        }
                        return;
                    }
                    if (cVar != null) {
                        cVar.c(new SyncResult());
                    }
                    t0.c.c();
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (cVar != null) {
            cVar.c(new SyncResult());
        }
    }

    public void f(c cVar) {
        t0.c.c();
    }

    public void g(b bVar) {
        try {
            bVar.b(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
