package com.example.giant.rxandroidlearning;

import android.app.Application;

import com.example.giant.rxandroidlearning.Dagger.compoents.AppCompoent;
import com.example.giant.rxandroidlearning.Dagger.compoents.DaggerAppCompoent;
import com.example.giant.rxandroidlearning.Dagger.modules.AppModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**@author giant
 * Created by giant on 2017/3/21.
 */

public class MyApp extends Application {

    private static AppCompoent appCompoent = null;

    @Override public void onCreate() {
        super.onCreate();
       /*
       *
       * ===========注入========
       * */

        if (appCompoent == null){

            appCompoent = DaggerAppCompoent.builder()
                    .appModule(new AppModule(MyApp.this))
                    .build();

        }

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

    public AppCompoent getAppCompoent(){
        //向外界的依赖提供这个AppComponent
        return appCompoent;

    }

}
