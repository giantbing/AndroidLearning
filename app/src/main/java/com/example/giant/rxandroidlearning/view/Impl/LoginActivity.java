package com.example.giant.rxandroidlearning.view.Impl;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.giant.rxandroidlearning.Base.BaseView;
import com.example.giant.rxandroidlearning.Base.Impl.BaseActivity;
import com.example.giant.rxandroidlearning.Dagger.compoents.ActivityCompoent;
import com.example.giant.rxandroidlearning.Dagger.compoents.DaggerActivityCompoent;
import com.example.giant.rxandroidlearning.Dagger.compoents.DaggerMainCompoent;
import com.example.giant.rxandroidlearning.Dagger.modules.MainModule;
import com.example.giant.rxandroidlearning.MyApp;
import com.example.giant.rxandroidlearning.Presenter.Impl.MainPresenterImpl;
import com.example.giant.rxandroidlearning.Presenter.MainPresenter;
import com.example.giant.rxandroidlearning.R;
import com.example.giant.rxandroidlearning.unitl.AnimotionHelper;
import com.example.giant.rxandroidlearning.unitl.DaggerTest;
import com.example.giant.rxandroidlearning.unitl.StartActivityHelper;
import com.example.giant.rxandroidlearning.unitl.ToastHelper;
import com.example.giant.rxandroidlearning.view.LoginView;
import com.orhanobut.logger.Logger;
import com.pnikosis.materialishprogress.ProgressWheel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends BaseActivity implements LoginView,BaseView {

    @BindView(R.id.mainTextureView)
    TextureView mainTextureView;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.progress_wheel)
    ProgressWheel progressWheel;
    @Inject
    DaggerTest daggerTest;

    private MainPresenter mPresenter;
    private Surface mSurface;
    private ActivityCompoent activityCompoent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenterImpl(this);
        //开启动画
        AnimotionHelper.enableAtcivitytrans(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // 使用Dagger2生成的类 生成组件进行构造，并注入
        activityCompoent = DaggerActivityCompoent.builder().appCompoent(((MyApp)getApplication()).getAppCompoent()).mainModule(new MainModule(this)).build();

        initclick();
        mainTextureView.setSurfaceTextureListener(VideoListener);
        progressWheel.stopSpinning();
        //ToastHelper.info(this,""+daggerTest.getI(),ToastHelper.LENGTH_SHORT,true);
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



    @Override
    public void showNameErro() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void showPsdErro() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void showMainView() {
        StartActivityHelper.startsecendActivityTraslate(LoginActivity.this, AnimotionHelper.sharedelementsbundle(LoginActivity.this, profileImage, "shareview"));
    }

    @Override
    public void showWaitDiaLog() {
        progressWheel.spin();
    }

    @Override
    public void hideWaitDiaLog() {
        progressWheel.stopSpinning();
    }

    void initclick(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.validateCredentials(username.getText().toString(),password.getText().toString());
            }
        });
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
