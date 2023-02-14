package v0;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: EmulatorUtil.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a() {
        String f2 = f();
        return f2.contains("intel") || f2.contains("amd");
    }

    public static boolean b() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.toLowerCase().contains("vbox") && !str.toLowerCase().contains("test-keys")) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(Context context) {
        if ((d() && e(context)) || b()) {
            return true;
        }
        return a();
    }

    public static boolean d() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter == null || TextUtils.isEmpty(defaultAdapter.getName());
    }

    public static boolean e(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) == null;
    }

    public static String f() {
        try {
            Process start = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
