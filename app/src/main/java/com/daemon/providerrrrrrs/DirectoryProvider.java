package com.daemon.providerrrrrrs;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.knight.cleaning.R;

public class DirectoryProvider extends ContentProvider {

    public static final Uri f3162c;

    public static final Uri f3163d;

    public static final Uri f3164e;

    public static final Uri f3165f;

    public SharedPreferences f3166a;

    public final UriMatcher f3167b = new UriMatcher(-1);

    static {
        Uri parse = Uri.parse("content://com.android.cts.contact.directory.provider");
        f3163d = Uri.withAppendedPath(parse, "photo/primary_thumbnail");
        f3162c = Uri.withAppendedPath(parse, "photo/primary_photo");
        f3165f = Uri.withAppendedPath(parse, "photo/managed_thumbnail");
        f3164e = Uri.withAppendedPath(parse, "photo/managed_photo");
    }

    public final String a() {
        return this.f3166a.getString("set_prefix", "");
    }

    public final boolean b() {
        return "Managed".equals(a());
    }

    @Override
    public Bundle call(String str, String str2, Bundle bundle) {
        if (str.equals("set_prefix")) {
            this.f3166a.edit().putString("set_prefix", str2).apply();
            long clearCallingIdentity = Binder.clearCallingIdentity();
            getContext().getContentResolver().update(ContactsContract.Directory.CONTENT_URI, new ContentValues(), null, null);
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return new Bundle();
    }

    @Override
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean onCreate() {
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "directories", 0);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "contacts/filter/*", 1);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "contacts/lookup/*/entities", 2);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "contacts/lookup/*/#/entities", 3);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "data/emails/filter/*", 4);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "data/phones/filter/*", 5);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "phone_lookup/*", 6);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "data/callables/filter/*", 7);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "data/emails/lookup/*", 8);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "photo/primary_thumbnail", 9);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "photo/primary_photo", 10);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "photo/managed_thumbnail", 11);
        this.f3167b.addURI("com.android.cts.contact.directory.provider", "photo/managed_photo", 12);
        this.f3166a = getContext().getSharedPreferences("config", 0);
        return true;
    }

    @Override
    public AssetFileDescriptor openAssetFile(Uri uri, String str) {
        int i2;
        if (str.equals("r")) {
            switch (this.f3167b.match(uri)) {
                case 9:
                    if (!b()) {
                        i2 = R.raw.clean_img_link;
                        break;
                    }
                    i2 = -1;
                    break;
                case 10:
                    if (!b()) {
                        i2 = R.raw.clean_img_sys;
                        break;
                    }
                    i2 = -1;
                    break;
                case 11:
                    if (b()) {
                        i2 = R.raw.clean_img_tool;
                        break;
                    }
                    i2 = -1;
                    break;
                case 12:
                    if (b()) {
                        i2 = R.raw.clean_img_menu;
                        break;
                    }
                    i2 = -1;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (i2 == -1) {
                return null;
            }
            return getContext().getResources().openRawResourceFd(i2);
        }
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        char c2;
        char c3;
        String a2 = a();
        switch (this.f3167b.match(uri)) {
            case 0:
                MatrixCursor matrixCursor = new MatrixCursor(strArr);
                Account[] accountsByType = ((AccountManager) getContext().getSystemService(Context.ACCOUNT_SERVICE)).getAccountsByType("com.android.cts.test");
                if (accountsByType != null) {
                    for (Account account : accountsByType) {
                        Object[] objArr = new Object[strArr.length];
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            String str3 = strArr[i2];
                            str3.hashCode();
                            switch (str3.hashCode()) {
                                case -1315438423:
                                    if (str3.equals("shortcutSupport")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -771083909:
                                    if (str3.equals("exportSupport")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 865966680:
                                    if (str3.equals("accountName")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 866168583:
                                    if (str3.equals("accountType")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1459432611:
                                    if (str3.equals("typeResourceId")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1714148973:
                                    if (str3.equals("displayName")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    objArr[i2] = 0;
                                    break;
                                case 1:
                                    objArr[i2] = 1;
                                    break;
                                case 2:
                                    objArr[i2] = account.name;
                                    break;
                                case 3:
                                    objArr[i2] = "com.android.cts.test";
                                    break;
                                case 4:
                                    objArr[i2] = Integer.valueOf(R.string.directory_resource_id);
                                    break;
                                case 5:
                                    objArr[i2] = a2 + "Directory";
                                    break;
                            }
                        }
                        matrixCursor.addRow(objArr);
                    }
                }
                return matrixCursor;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                MatrixCursor matrixCursor2 = new MatrixCursor(strArr);
                Object[] objArr2 = new Object[strArr.length];
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    String str4 = strArr[i3];
                    str4.hashCode();
                    switch (str4.hashCode()) {
                        case -847656481:
                            if (str4.equals("photo_uri")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 94650:
                            if (str4.equals("_id")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1615086568:
                            if (str4.equals("display_name")) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 2132372918:
                            if (str4.equals("photo_thumb_uri")) {
                                c3 = 3;
                                break;
                            }
                            c3 = 65535;
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    switch (c3) {
                        case 0:
                            objArr2[i3] = (b() ? f3164e : f3162c).toString();
                            break;
                        case 1:
                            objArr2[i3] = -1;
                            break;
                        case 2:
                            objArr2[i3] = a2 + "DirectoryContact";
                            break;
                        case 3:
                            objArr2[i3] = (b() ? f3165f : f3163d).toString();
                            break;
                        default:
                            objArr2[i3] = null;
                            break;
                    }
                }
                matrixCursor2.addRow(objArr2);
                return matrixCursor2;
            default:
                return null;
        }
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 1;
    }
}
