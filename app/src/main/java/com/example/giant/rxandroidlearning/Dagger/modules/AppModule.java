package com.example.giant.rxandroidlearning.Dagger.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by giant on 2017/3/28.
 */
@Module
public class AppModule {

    private Application mapplication;

    public AppModule(Application mapplication) {
        this.mapplication = mapplication;
    }
    @Provides
    @Singleton
    Context getAppContext(){
        return mapplication;
    }
}
