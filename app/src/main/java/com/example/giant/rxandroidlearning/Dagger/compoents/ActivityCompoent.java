package com.example.giant.rxandroidlearning.Dagger.compoents;

import com.example.giant.rxandroidlearning.Dagger.scopes.PerActivity;

import dagger.Component;

/**
 * Created by giant on 2017/3/28.
 */
@PerActivity
@Component(dependencies = AppCompoent.class)
public interface ActivityCompoent {
}
