package com.knight.cleaning

import android.app.Application
import android.content.Intent
import com.blankj.utilcode.util.ProcessUtils
import com.blankj.utilcode.util.Utils
import com.daemon.services.AliveService
import com.daemon.virtualdialog.VirtualDialogHelper
import s0.DaemonCore

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)

        //启动保活
        if (DaemonCore.c(this)) {
            startService(Intent(this, AliveService::class.java))
        }
        if (ProcessUtils.isMainProcess()){
            VirtualDialogHelper.addVirtualView(this)
        }

    }

}