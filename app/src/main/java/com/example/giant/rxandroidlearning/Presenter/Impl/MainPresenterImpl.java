package com.example.giant.rxandroidlearning.Presenter.Impl;

import android.content.Context;
import android.view.Surface;

import com.example.giant.rxandroidlearning.Moudle.Impl.MainMoudleImpl;
import com.example.giant.rxandroidlearning.Moudle.MainMoudle;
import com.example.giant.rxandroidlearning.Presenter.MainPresenter;
import com.example.giant.rxandroidlearning.view.LoginView;

/**@author giant
 * Created by giant on 2017/3/20.
 */

public class MainPresenterImpl implements MainPresenter,MainMoudle.OnLoginFinishedListener{

    private MainMoudle mMainMoudle;
    private LoginView mMainview;

    public MainPresenterImpl(LoginView view) {

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

    @Override
    public void validateCredentials(String username, String password) {
        mMainview.showWaitDiaLog();
        mMainMoudle.Login(username,password,this);
    }


    @Override
    public void onUsernameError() {
        mMainview.hideWaitDiaLog();
        mMainview.showNameErro();
    }

    @Override
    public void onPasswordError() {
        mMainview.hideWaitDiaLog();
        mMainview.showPsdErro();

    }

    @Override
    public void onSuccess() {
        mMainview.hideWaitDiaLog();
        mMainview.showMainView();
    }
}
