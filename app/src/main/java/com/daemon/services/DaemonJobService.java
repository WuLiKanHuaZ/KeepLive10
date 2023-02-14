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


public class DaemonJobService extends JobService {

    public static int f3171a = -1;

    public static long f3172b = 60000;

    public static long f3173c = 60000;

    public static void a(Context context) {
        try {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            int i2 = f3171a;
            if (i2 != -1) {
                jobScheduler.cancel(i2);
            }
            if (jobScheduler.getAllPendingJobs().size() > NotificationIdConst.f8126b.intValue()) {
                jobScheduler.cancelAll();
            }
            ComponentName componentName = new ComponentName(context, DaemonJobService.class);
            f3171a = new Random().nextInt(Integer.MAX_VALUE);
            JobInfo.Builder persisted = new JobInfo.Builder(f3171a, componentName).setBackoffCriteria(30000L, 0).setRequiresCharging(false).setRequiresDeviceIdle(false).setMinimumLatency(f3172b).setOverrideDeadline(f3173c).setPersisted(true);
            if (Build.VERSION.SDK_INT >= 26) {
                persisted.setRequiresBatteryNotLow(false).setRequiresStorageNotLow(false);
            }
            jobScheduler.schedule(persisted.build());
        } catch (Exception unused) {
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        t.a.g(this, new Intent(this, DaemonService.class),getApplicationContext().getPackageName()+".keep.p0");
        jobFinished(jobParameters, true);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
