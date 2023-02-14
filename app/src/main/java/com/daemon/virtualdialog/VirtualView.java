package com.daemon.virtualdialog;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

public class VirtualView extends Presentation {

    public VirtualView(Context outerContext, Display display) {
        super(outerContext, display);
    }

    public VirtualView(Context outerContext, Display display, int theme) {
        super(outerContext, display, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new View(getContext()));

    }
}
