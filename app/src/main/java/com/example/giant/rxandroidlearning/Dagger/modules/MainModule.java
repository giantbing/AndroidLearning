package com.example.giant.rxandroidlearning.Dagger.modules;

import com.example.giant.rxandroidlearning.unitl.DaggerTest;

import dagger.Module;
import dagger.Provides;

/**233
 * Created by giant on 2017/3/28.
 */
@Module
public class MainModule {

    @Provides
    public DaggerTest provideMainModule (int i) {

        return  new DaggerTest(i);

    }
    @Provides
    public int providei(){

        return 2;

    }
}
