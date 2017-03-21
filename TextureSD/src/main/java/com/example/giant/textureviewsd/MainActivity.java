package com.example.giant.textureviewsd;

import android.app.Activity;
import android.hardware.Camera;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.giant.textureviewsd.until.DataHelper;
import com.example.giant.textureviewsd.until.FileHelper;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity  {

    @BindView(R.id.MainTextureview)
    android.view.TextureView MainTextureview;

    private Surface mSurface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainTextureview.setSurfaceTextureListener(VideoListener);

    }



    TextureView.SurfaceTextureListener VideoListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {

            mSurface = new Surface(surfaceTexture);
            DataHelper.playvideo(FileHelper.getInerSDPath()+"/"+"giant/testvideo.mp4",mSurface);
          // DataHelper.previewCamra(MainTextureview,surfaceTexture);


        }



        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {

           DataHelper.Stopvideo(mSurface);
           // DataHelper.StopPreview(surfaceTexture);
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }
    };





}
