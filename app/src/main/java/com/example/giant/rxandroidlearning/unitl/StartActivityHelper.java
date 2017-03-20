package com.example.giant.rxandroidlearning.unitl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

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


}
