package com.example.giant.rxandroidlearning.unitl;


import javax.inject.Inject;

/**@author giant
 * Created by giant on 2017/3/27.
 */

public class DaggerTest {
    private int i ;
    @Inject
    public DaggerTest() {
        i = 1;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public  DaggerTest(int i){

        this. i = i;

    }
}
