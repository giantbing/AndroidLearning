package com.example.giant.rxandroidlearning.Presenter;

/*
 * Created by giant on 2017/3/20.
 */

import android.view.Surface;

public interface MainPresenter {



     void onResume();

     void onDestroy();

     void onTextureReady(Surface surfaceTexture);

     void onTextureDestroy(Surface surfaceTexture);
}
