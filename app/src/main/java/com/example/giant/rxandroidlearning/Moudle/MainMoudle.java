package com.example.giant.rxandroidlearning.Moudle;

/*
 * Created by giant on 2017/3/20.
 */


import android.view.Surface;

public interface MainMoudle {
    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }
    void FillTexture(Surface surfaceTexture);

    void StopTexture(Surface surfaceTexture);

    void Login(String username,String password,OnLoginFinishedListener loginFinishedListener);
}
