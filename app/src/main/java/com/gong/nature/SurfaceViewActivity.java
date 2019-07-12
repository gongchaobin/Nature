package com.gong.nature;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;

import com.gong.nature.view.SurfaceViewAnimation;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/7/12 2:30 PM
 * @desc :
 */
public class SurfaceViewActivity extends AppCompatActivity{

    private SurfaceViewAnimation mSurfaceViewAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfaceview);

        SurfaceView surfaceView = findViewById(R.id.surfaceview);
        mSurfaceViewAnimation = new SurfaceViewAnimation.Builder(surfaceView,"gold_card").build();
        mSurfaceViewAnimation.setFrameInterval(50);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSurfaceViewAnimation.start();
            }
        }, 100);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSurfaceViewAnimation.kill();
    }

    Handler mHandler = new Handler();

}
