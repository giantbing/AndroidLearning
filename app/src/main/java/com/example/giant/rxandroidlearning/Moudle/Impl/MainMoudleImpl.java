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
import com.example.giant.rxandroidlearning.Presenter.MainPresenter;
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
    private MediaPlayer mediaPlayer;

    public MainMoudleImpl(Context context) {
        this.context = context;
    }

   @Override
    public void FillTexture(Surface surfaceTexture) {
        //FileHelper.copyFilesFromRaw(context,R.raw.testvideo,"testvideo.mp4",FileHelper.getInerSDPath()+"/"+"giant");
        playvideo(FileHelper.getInerSDPath()+"/"+"giant/testvideo.mp4",surfaceTexture);
    }

    @Override
    public void StopTexture(Surface surfaceTexture) {
        surfaceTexture = null;
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    /*
    * 播放路径视屏
    * */
    private void playvideo(String path,Surface mSurface){

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
