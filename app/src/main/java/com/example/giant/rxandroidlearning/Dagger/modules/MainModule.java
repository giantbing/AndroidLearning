package com.example.giant.rxandroidlearning.Dagger.modules;

import android.app.Activity;


import com.example.giant.rxandroidlearning.Dagger.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 233
 * Created by giant on 2017/3/28.
 */
@Module
public class MainModule {

    private final Activity activity;

    public MainModule(Activity activity) {
        this.activity = activity;
    }
    @Provides@PerActivity
    public Activity getActivity(){
        return this.activity;
    }


}
