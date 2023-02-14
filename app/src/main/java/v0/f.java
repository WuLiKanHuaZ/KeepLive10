package v0;

import android.app.Application;
import android.os.Build;

import java.io.BufferedReader;
import java.io.FileReader;


public class f {
    public static String a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return b();
    }

    public static String b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/cmdline"));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
