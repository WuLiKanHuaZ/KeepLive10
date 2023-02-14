package u0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISyncAdapterUnsyncableAccountCallback.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: ISyncAdapterUnsyncableAccountCallback.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: ISyncAdapterUnsyncableAccountCallback.java */
        /* renamed from: u0.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0105a implements b {

            /* renamed from: b  reason: collision with root package name */
            public static b f8173b;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f8174a;

            public C0105a(IBinder iBinder) {
                this.f8174a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8174a;
            }

            @Override // u0.b
            public void b(boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.content.ISyncAdapterUnsyncableAccountCallback");
                    obtain.writeInt(z2 ? 1 : 0);
                    if (!this.f8174a.transact(1, obtain, obtain2, 0) && a.d() != null) {
                        a.d().b(z2);
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b d() {
            return C0105a.f8173b;
        }

        public static b h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.content.ISyncAdapterUnsyncableAccountCallback");
            if (!(queryLocalInterface instanceof b)) {
                return new C0105a(iBinder);
            }
            return (b) queryLocalInterface;
        }
    }

    void b(boolean z2) throws RemoteException;
}
