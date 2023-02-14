package com.daemon.services;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.util.Random;

import s0.NotificationIdConst;

/* loaded from: classes.dex */
public class ListenerJobService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public static int f3178a = -1;

    public static void a(Context context) {
        try {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            int i2 = f3178a;
            if (i2 != -1) {
                jobScheduler.cancel(i2);
            }
            if (jobScheduler.getAllPendingJobs().size() > NotificationIdConst.f8126b.intValue()) {
                jobScheduler.cancelAll();
            }
            ComponentName componentName = new ComponentName(context, ListenerJobService.class);
            f3178a = new Random().nextInt(Integer.MAX_VALUE);
            JobInfo.Builder persisted = new JobInfo.Builder(f3178a, componentName).setBackoffCriteria(30000L, 0).setRequiresCharging(false).setRequiresDeviceIdle(false).setPeriodic(900000L).setPersisted(true);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                persisted.setPeriodic(JobInfo.getMinPeriodMillis(), JobInfo.getMinFlexMillis());
            }
            if (i3 >= 26) {
                persisted.setRequiresBatteryNotLow(false).setRequiresStorageNotLow(false);
            }
            jobScheduler.schedule(persisted.build());
        } catch (Exception unused) {
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        t.a.g(this, new Intent(this, DaemonService.class),getApplicationContext().getPackageName()+".keep.p0");
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
