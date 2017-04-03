package com.example.giant.rxandroidlearning.unitl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.giant.rxandroidlearning.view.Impl.LoginActivity;
import com.example.giant.rxandroidlearning.view.Impl.SecondActivity;

/*
 * Created by giant on 2017/3/17.
 */

public class StartActivityHelper {
    public StartActivityHelper() {
     }
    public static void startsecendActivityTraslate(Context context ,Bundle bundle){
        Intent intent = new Intent(context, SecondActivity.class) ;
        context.startActivity(intent, bundle);
    }
    public static void startLoginActivityTraslate(Context context ,Bundle bundle){
        Intent intent = new Intent(context, LoginActivity.class) ;
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent, bundle);
    }

}
