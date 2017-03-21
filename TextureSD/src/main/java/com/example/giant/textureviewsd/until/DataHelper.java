package com.example.giant.textureviewsd.until;

import android.hardware.Camera;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;

import java.io.IOException;

/**
 * Created by giant on 2017/3/21.
 */

public class DataHelper {
    private static MediaPlayer mediaPlayer;
    private static Camera mCamera;
    /*
 * 播放路径视屏
 * */
    public static void playvideo(String path, Surface mSurface ){

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
    /*
* 播放路径视屏
* */
    public static void Stopvideo(Surface mSurface ){

        mSurface = null;
        mediaPlayer.stop();
        mediaPlayer.release();

    }

    public static void previewCamra(TextureView myTexture, SurfaceTexture  mSurface ){

        mediaPlayer = new MediaPlayer();
        try {
            mCamera = Camera.open();
            Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
            myTexture.setLayoutParams(new FrameLayout.LayoutParams(
                    previewSize.width, previewSize.height, Gravity.CENTER));
            try {
                mCamera.setPreviewTexture(mSurface);
            } catch (IOException t) {
            }
            mCamera.startPreview();
            myTexture.setAlpha(1.0f);
            myTexture.setRotation(90.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /*
* 播放路径视屏
* */
    public static void StopPreview(SurfaceTexture mSurface ){

        mCamera.stopPreview();
        mCamera.release();

    }
}
