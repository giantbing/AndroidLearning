package com.example.giant.rxandroidlearning.Presenter.Impl;

import android.content.Context;
import android.view.TextureView;

import com.example.giant.rxandroidlearning.Moudle.Impl.MainMoudleImpl;
import com.example.giant.rxandroidlearning.Moudle.MainMoudle;
import com.example.giant.rxandroidlearning.Presenter.MainPresenter;
import com.example.giant.rxandroidlearning.view.MainView;
import com.orhanobut.logger.Logger;

/**@author giant
 * Created by giant on 2017/3/20.
 */

public class MainPresenterImpl implements MainPresenter,MainMoudle.onFinshLisner{

    private MainMoudle mMainMoudle;
    private MainView mMainview;

    public MainPresenterImpl(MainView view) {

        this.mMainview = view;
        mMainMoudle = new MainMoudleImpl((Context) mMainview);

    }

    @Override
    public void onResume() {

        mMainMoudle.loadTexture(this);

    }

    @Override
    public void onDestroy() {
        mMainview = null;
    }

    @Override
    public void onFinsh(TextureView.SurfaceTextureListener TextureListener) {

        if (mMainview != null)

        mMainview.setAdapter(TextureListener);

    }
}
