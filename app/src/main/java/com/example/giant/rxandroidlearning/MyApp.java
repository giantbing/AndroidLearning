package com.example.giant.rxandroidlearning;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**@author giant
 * Created by giant on 2017/3/21.
 */

public class MyApp extends Application {
   @Override public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());

       if (LeakCanary.isInAnalyzerProcess(this)) {
           // This process is dedicated to LeakCanary for heap analysis.
           // You should not init your app in this process.
           return;
       }
       LeakCanary.install(this);
    }

}
