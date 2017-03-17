package com.example.giant.rxandroidlearning.unitl;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;

import com.example.giant.rxandroidlearning.view.SecondActivity;

/**
 * Created by giant on 2017/3/17.
 */

public class StartActivityHelper {
    private Context mContext ;
    public StartActivityHelper() {
     }
    public static void startsecendActivityTraslate(Context context ,Bundle bundle){
        Intent intent = new Intent(context, SecondActivity.class) ;
        context.startActivity(intent, bundle);
    }


}
