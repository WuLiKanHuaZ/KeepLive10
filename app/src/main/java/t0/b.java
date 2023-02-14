package t0;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.os.RemoteException;

import com.daemon.common.Keep111Instrumentation;
import com.daemon.core.NativeDaemonApi;
import com.daemon.services.AliveService;
import com.daemon.services.DaemonService;
import com.daemon.services.GuardService;

import java.io.File;

import v0.g;

/* compiled from: ProcessManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f8130a;

    /* compiled from: ProcessManager.java */
    /* loaded from: classes.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final Context f8131a;

        public a(Context context) {
            this.f8131a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {

//            File dir = this.f8131a.getDir("A4757D7419FF3B48E92E90596F0E7548", 0);
//            NativeDaemonApi.dump(b.this.f8130a, new File(dir, "lock5").getAbsolutePath(), new File(dir, "lock6").getAbsolutePath(), new File(dir, "lock7").getAbsolutePath(), new File(dir, "lock8").getAbsolutePath());
        }
    }

    /* compiled from: ProcessManager.java */
    /* renamed from: t0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0100b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final Context f8133a;

        public C0100b(Context context) {
            this.f8133a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
//            File dir = this.f8133a.getDir("A4757D7419FF3B48E92E90596F0E7548", 0);
//            NativeDaemonApi.dump(b.this.f8130a, new File(dir, "lock1").getAbsolutePath(), new File(dir, "lock2").getAbsolutePath(), new File(dir, "lock3").getAbsolutePath(), new File(dir, "lock4").getAbsolutePath());
        }
    }

    /* compiled from: ProcessManager.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f8135a = new b(null);
    }

    /* compiled from: ProcessManager.java */
    /* loaded from: classes.dex */
    public class d extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final Context f8136a;

        public d(Context context) {
            this.f8136a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
//            File dir = this.f8136a.getDir("A4757D7419FF3B48E92E90596F0E7548", 0);
//            NativeDaemonApi.dump(b.this.f8130a, new File(dir, "lock6").getAbsolutePath(), new File(dir, "lock5").getAbsolutePath(), new File(dir, "lock8").getAbsolutePath(), new File(dir, "lock7").getAbsolutePath());
        }
    }

    /* compiled from: ProcessManager.java */
    /* loaded from: classes.dex */
    public class e extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final Context f8138a;

        public e(Context context) {
            this.f8138a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
//            File dir = this.f8138a.getDir("A4757D7419FF3B48E92E90596F0E7548", 0);
//            NativeDaemonApi.dump(b.this.f8130a, new File(dir, "lock2").getAbsolutePath(), new File(dir, "lock1").getAbsolutePath(), new File(dir, "lock4").getAbsolutePath(), new File(dir, "lock3").getAbsolutePath());
        }
    }

    public b(C0100b c0100b) {
        this();
    }

    public static b a() {
        return c.f8135a;
    }

    public void b(Context context) {
        this.f8130a = context;
        t.a.g(context, new Intent(context, GuardService.class),context.getPackageName()+".keep.p3");
        t.a.g(context, new Intent(context, AliveService.class),context.getPackageName()+".keep.p4");
        h(this.f8130a, "listen");
        h(this.f8130a, "loop");
        t.a.g(context, new Intent(context, DaemonService.class),context.getPackageName()+".keep.p0");
    }

    public void c(Context context) {
        this.f8130a = context;
        new a(context).start();
    }

    public void d(Context context) {
        this.f8130a = context;
        new C0100b(context).start();
    }

    public void e(Context context) {
        this.f8130a = context;
        new d(context).start();
    }

    public void f(Context context) {
        this.f8130a = context;
        new e(context).start();
    }

    public void g() {
        this.f8130a.startInstrumentation(new ComponentName(this.f8130a, Keep111Instrumentation.class), null, null);
        t.a.g(this.f8130a, new Intent(this.f8130a, DaemonService.class),f8130a.getPackageName()+".keep.p0");
        t0.c.a();
        Process.killProcess(Process.myPid());
    }

    public void h(Context context, String str) {
        try {
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse(g.a("content://", context.getPackageName(), ".", str)));
            if (acquireUnstableContentProviderClient == null) {
                return;
            }
            acquireUnstableContentProviderClient.call("start", null, null);
            acquireUnstableContentProviderClient.release();
        } catch (RemoteException unused) {
        }
    }

    public b() {
    }
}
