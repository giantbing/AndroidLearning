package com.example.giant.rxandroidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.giant.rxandroidlearning.unitl.AnimotionHelper;
import com.example.giant.rxandroidlearning.unitl.StartActivityHelper;
import com.example.giant.rxandroidlearning.view.SecondActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //开启动画
        AnimotionHelper.enableAtcivitytrans(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // RxView.clickEvents(button).throttleFirst(500, TimeUnit.MILLISECONDS) // RxBinding 代码，后面的文章有解释 .throttleFirst(500, TimeUnit.MILLISECONDS) // 设置防抖间隔为 500ms .subscribe(subscriber);
//        Observable.just(1, 2, 3, 4).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d("RXTAG", "this is " + integer);
//                    }
//                });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartActivityHelper.startsecendActivityTraslate(MainActivity.this,AnimotionHelper.sharedelementsbundle(MainActivity.this,button,"shareview"));
            }
        });
    }
}
