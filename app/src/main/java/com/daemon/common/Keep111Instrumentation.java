package com.daemon.common;

import android.app.Application;
import android.app.Instrumentation;
import android.os.Bundle;

public class Keep111Instrumentation extends Instrumentation {
    @Override
    public void callApplicationOnCreate(Application application) {
        super.callApplicationOnCreate(application);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
