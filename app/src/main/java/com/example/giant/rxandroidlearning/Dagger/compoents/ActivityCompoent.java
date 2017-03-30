package com.example.giant.rxandroidlearning.Dagger.compoents;

import android.app.Activity;

import com.example.giant.rxandroidlearning.Dagger.modules.MainModule;
import com.example.giant.rxandroidlearning.Dagger.scopes.PerActivity;
import com.example.giant.rxandroidlearning.view.Impl.LoginActivity;

import dagger.Component;

/**
 * Created by giant on 2017/3/28.
 */
@PerActivity
@Component(dependencies = AppCompoent.class,modules = MainModule.class)
public interface ActivityCompoent {

    void inject(LoginActivity loginActivity);

    Activity getActivity();
}
