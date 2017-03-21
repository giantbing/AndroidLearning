package com.example.giant.rxandroidlearning.Presenter.Impl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

import com.example.giant.rxandroidlearning.Moudle.Impl.MainMoudleImpl;
import com.example.giant.rxandroidlearning.Moudle.MainMoudle;
import com.example.giant.rxandroidlearning.Presenter.MainPresenter;
import com.example.giant.rxandroidlearning.view.MainView;
import com.orhanobut.logger.Logger;

/**@author giant
 * Created by giant on 2017/3/20.
 */

public class MainPresenterImpl implements MainPresenter{

    private MainMoudle mMainMoudle;
    private MainView mMainview;

    public MainPresenterImpl(MainView view) {

        this.mMainview = view;
        mMainMoudle = new MainMoudleImpl((Context) mMainview);

    }

    @Override
    public void onResume() {


    }

    @Override
    public void onDestroy() {
        mMainview = null;
    }

    @Override
    public void onTextureReady(Surface surfaceTexture) {

        mMainMoudle.FillTexture(surfaceTexture);

    }

    @Override
    public void onTextureDestroy(Surface surfaceTexture) {

        mMainMoudle.StopTexture(surfaceTexture);

    }




}
