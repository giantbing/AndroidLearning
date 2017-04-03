package com.example.giant.rxandroidlearning.view.Impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.giant.rxandroidlearning.Base.Impl.BaseActivity;
import com.example.giant.rxandroidlearning.R;
import com.example.giant.rxandroidlearning.unitl.AnimotionHelper;
import com.example.giant.rxandroidlearning.unitl.StartActivityHelper;
import com.example.giant.rxandroidlearning.unitl.ToastHelper;
import com.example.giant.rxandroidlearning.unitl.permission.PermissionReq;
import com.example.giant.rxandroidlearning.unitl.permission.PermissionResult;
import com.example.giant.rxandroidlearning.unitl.permission.Permissions;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                PermissionReq.with(SplashActivity.this).permissions(Permissions.STORAGE).result(new PermissionResult() {
                    @Override
                    public void onGranted() {
                        StartActivityHelper.startLoginActivityTraslate(SplashActivity.this, AnimotionHelper.slidebundle(SplashActivity.this));
                        finish();
                    }

                    @Override
                    public void onDenied() {
                        ToastHelper.error(getApplicationContext(),"需要读取权限",ToastHelper.LENGTH_SHORT,true);
                        finish();
                    }
                }).request();
            }
        }, 1000);

    }
}
