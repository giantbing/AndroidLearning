package com.example.giant.rxandroidlearning.Moudle;

/*
 * Created by giant on 2017/3/20.
 */

import android.view.TextureView;

public interface MainMoudle {

    interface onFinshLisner {

        void onFinsh(TextureView.SurfaceTextureListener TextureListener);

    }

    void loadTexture(onFinshLisner finshLisner);
}
