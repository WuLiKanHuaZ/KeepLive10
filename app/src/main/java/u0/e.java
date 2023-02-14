package u0;

import android.accounts.Account;
import android.content.SyncResult;
import android.os.Bundle;

/* compiled from: SyncAdapterImpl1.java */
/* loaded from: classes.dex */
public class e extends f {
    @Override // u0.f, u0.a
    public void a(c cVar, String str, Account account, Bundle bundle) {
        if (cVar != null) {
            try {
                cVar.c(new SyncResult());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // u0.f, u0.a
    public void f(c cVar) {
    }

    @Override // u0.f, u0.a
    public void g(b bVar) {
        try {
            bVar.b(false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
