package u0;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISyncAdapter.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: ISyncAdapter.java */
    /* renamed from: u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0104a extends Binder implements a {
        public AbstractBinderC0104a() {
            attachInterface(this, "android.content.ISyncAdapter");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("android.content.ISyncAdapter");
                IBinder e2 = e();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(e2);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("android.content.ISyncAdapter");
                a(c.a.h(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("android.content.ISyncAdapter");
                f(c.a.h(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i2 == 4) {
                parcel.enforceInterface("android.content.ISyncAdapter");
                g(b.a.h(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("android.content.ISyncAdapter");
                return true;
            }
        }
    }

    void a(c cVar, String str, Account account, Bundle bundle) throws RemoteException;

    IBinder e() throws RemoteException;

    void f(c cVar) throws RemoteException;

    void g(b bVar) throws RemoteException;
}
