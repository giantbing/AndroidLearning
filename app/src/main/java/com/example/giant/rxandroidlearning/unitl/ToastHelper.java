package com.example.giant.rxandroidlearning.unitl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**@author giant
 * Created by giant on 2017/3/27.
 */

public class ToastHelper {

    private static int LENGTH_SHORT;
    private static int LENGTH_LONG;
    static {
        LENGTH_SHORT = Toast.LENGTH_SHORT;
        LENGTH_LONG = Toast.LENGTH_LONG;
    }
    /**
     * @param withIcon 是否开启图标
     */
    public static void error(Context mContext,String msg,int Length,Boolean withIcon){
        Toasty.error(mContext, msg, Length, withIcon).show();
    }
    /**
     * @param withIcon 是否开启图标
     */
    public static void success(Context mContext,String msg,int Length,Boolean withIcon){
        Toasty.success(mContext, msg, Length, withIcon).show();
    }
    /**
     * @param withIcon 是否开启图标
     */
    public static void info(Context mContext,String msg,int Length,Boolean withIcon){
        Toasty.info(mContext, msg, Length, withIcon).show();
    }
    /**
     * @param withIcon 是否开启图标
     */
    public static void warning(Context mContext,String msg,int Length,Boolean withIcon){
        Toasty.warning(mContext, msg, Length, withIcon).show();
    }

    public static void normal(Context mContext,String msg){
        Toasty.normal(mContext, msg).show();
    }

    public static void normal(Context mContext, String msg, Drawable mdrawable){
        Toasty.normal(mContext,msg, mdrawable).show();
    }
    /**
     * @param withIcon 是否显示tint
     */
    public static void custom(@NonNull Context mContext, @NonNull CharSequence msg, @DrawableRes int iconRes, @ColorInt int textColor, @ColorInt int tintColor, int duration, boolean withIcon, boolean shouldTint){
        Toasty.custom(mContext, msg, iconRes, textColor, tintColor, duration, withIcon, shouldTint).show();
    }
}
