package s;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;

public class a extends t.a {

    public static class RunnableC0098a implements Runnable {

        public final Activity f8045a;

        public RunnableC0098a(Activity activity) {
            this.f8045a = activity;
        }

        @Override
        public void run() {
            if (this.f8045a.isFinishing() || b.i(this.f8045a)) {
                return;
            }
            this.f8045a.recreate();
        }
    }

    public static void h(Activity activity) {
        activity.finishAffinity();
    }

    public static void i(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            activity.recreate();
        } else if (i2 <= 23) {
            new Handler(activity.getMainLooper()).post(new RunnableC0098a(activity));
        } else if (b.i(activity)) {
        } else {
            activity.recreate();
        }
    }
}
