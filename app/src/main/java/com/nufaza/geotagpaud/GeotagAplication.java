package com.nufaza.geotagpaud;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

public class GeotagAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        FlowManager.destroy();
    }
}
