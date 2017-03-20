package com.example.giant.rxandroidlearning.Moudle.Impl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.view.Surface;
import android.view.TextureView;

import com.example.giant.rxandroidlearning.Moudle.MainMoudle;
import com.example.giant.rxandroidlearning.R;
import com.example.giant.rxandroidlearning.unitl.FileHelper;
import com.orhanobut.logger.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Created by giant on 2017/3/20.
 */

public class MainMoudleImpl implements MainMoudle {

    private  Context context ;
    private Surface mSurface;
    private MediaPlayer mediaPlayer;

    public MainMoudleImpl(Context context) {
        this.context = context;
    }

    @Override
    public void loadTexture(onFinshLisner finshLisner) {
        FileHelper.copyFilesFromRaw(context,R.raw.testvideo,"testvideo.mp4",FileHelper.getInerSDPath()+"/"+"giant");
        finshLisner.onFinsh(TextureListener);
        Logger.d("onFinsh");


    }

    /*
     * 创建SurfaceListener提供数据
     *
     */
    private TextureView.SurfaceTextureListener TextureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
            mSurface = new Surface(surfaceTexture);

            playvideo(FileHelper.getInerSDPath()+"/"+"giant/testvideo.mp4");
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            mSurface = null;
            mediaPlayer.stop();
            mediaPlayer.release();
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }
    };


    /*
    * 播放路径视屏
    * */
    private void playvideo(String path){

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setSurface(mSurface);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
