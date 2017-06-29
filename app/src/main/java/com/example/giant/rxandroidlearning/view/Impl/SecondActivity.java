package com.example.giant.rxandroidlearning.view.Impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.giant.rxandroidlearning.Entity.PieData;
import com.example.giant.rxandroidlearning.R;
import com.example.giant.rxandroidlearning.customView.PieView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<PieData> pieDatas = new ArrayList<>();

    @BindView(R.id.PieView)
    com.example.giant.rxandroidlearning.customView.PieView PieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        initData();
    }

    public void initData() {
        for (int i=0;i<6;i++){
            PieData mData = new PieData("数据"+i,i);
            pieDatas.add(mData);
        }
        initview();
    }
    public void initview(){
        PieView.setData(pieDatas);
    }

}
