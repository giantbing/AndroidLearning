package com.example.giant.rxandroidlearning.view.Impl;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import com.example.giant.rxandroidlearning.Presenter.Impl.MainPresenterImpl;
import com.example.giant.rxandroidlearning.Presenter.MainPresenter;
import com.example.giant.rxandroidlearning.R;
import com.example.giant.rxandroidlearning.unitl.AnimotionHelper;
import com.example.giant.rxandroidlearning.unitl.DataHelper;
import com.example.giant.rxandroidlearning.unitl.FileHelper;
import com.example.giant.rxandroidlearning.unitl.StartActivityHelper;
import com.example.giant.rxandroidlearning.view.MainView;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements MainView {

    @BindView(R.id.mainTextureView)
    TextureView mainTextureView;

    @BindView(R.id.button)
    Button button;

    private MainPresenter mPresenter;
    private Surface mSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenterImpl(this);
        //开启动画
        AnimotionHelper.enableAtcivitytrans(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainTextureView.setSurfaceTextureListener(VideoListener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartActivityHelper.startsecendActivityTraslate(MainActivity.this, AnimotionHelper.sharedelementsbundle(MainActivity.this, button, "shareview"));
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    TextureView.SurfaceTextureListener VideoListener = new TextureView.SurfaceTextureListener() {

        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {

            mSurface = new Surface(surfaceTexture);
            mPresenter.onTextureReady(mSurface);
        }



        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {

            mPresenter.onTextureDestroy(mSurface);
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }
    };
}
