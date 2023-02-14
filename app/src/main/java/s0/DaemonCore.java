package s0;

import android.content.Context;
import android.content.Intent;

import com.daemon.services.ScheduledService;
import com.daemon.virtualdialog.VirtualDialogHelper;

import t0.c;
import v0.f;
import v0.g;

/* compiled from: DaemonCore.java */
/* loaded from: classes.dex */
public class DaemonCore {
    public static void a(Context context) {
//        Reflection.unseal(context);
    }

    public static void b(Context context) {
        String a2 = f.a();
        String packageName = context.getPackageName();
        if (g.a(packageName, ":", "watch").equals(a2)) {
            t0.b.a().f(context);
        } else if (g.a(packageName, ":", "keep").equals(a2)) {
            t0.b.a().d(context);
        } else if (g.a(packageName, ":", "loop").equals(a2)) {
            t0.b.a().e(context);
        } else if (g.a(packageName, ":", "listen").equals(a2)) {
            t0.b.a().c(context);
        } else {
            t0.b.a().b(context);
        }
    }

    public static boolean c(Context context) {
        b(context);
        c.a();
        VirtualDialogHelper.addVirtualView(context);
        if (context.getPackageName().equals(f.a())) {
            context.startService(new Intent(context, ScheduledService.class));
            return true;
        }
        return false;
    }
}
