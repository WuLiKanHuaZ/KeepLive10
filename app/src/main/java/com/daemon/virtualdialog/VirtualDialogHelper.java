package com.daemon.virtualdialog;


import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Handler;

public class VirtualDialogHelper {

    public static void addVirtualView(Context application){
        DisplayManager displayManager = (DisplayManager) application.getSystemService(Context.DISPLAY_SERVICE);
        try {
            VirtualDisplay display = displayManager.createVirtualDisplay(application.getPackageName(),2,2,2,null,0);
            new VirtualView(application,display.getDisplay()).show();
        }catch (Exception e){

        }
    }

}
