package u0;

import android.content.SyncResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISyncContext.java */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* compiled from: ISyncContext.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {

        /* compiled from: ISyncContext.java */
        /* renamed from: u0.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0106a implements c {

            /* renamed from: b  reason: collision with root package name */
            public static c f8175b;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f8176a;

            public C0106a(IBinder iBinder) {
                this.f8176a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8176a;
            }

            @Override // u0.c
            public void c(SyncResult syncResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.content.ISyncContext");
                    if (syncResult != null) {
                        obtain.writeInt(1);
                        syncResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f8176a.transact(2, obtain, obtain2, 0) && a.d() != null) {
                        a.d().c(syncResult);
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static c d() {
            return C0106a.f8175b;
        }

        public static c h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.content.ISyncContext");
            if (!(queryLocalInterface instanceof c)) {
                return new C0106a(iBinder);
            }
            return (c) queryLocalInterface;
        }
    }

    void c(SyncResult syncResult) throws RemoteException;
}
