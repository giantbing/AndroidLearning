package com.example.giant.rxandroidlearning;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**@author giant
 * Created by giant on 2017/3/21.
 */

public class MyApp extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

}
