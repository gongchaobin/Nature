package com.gong.nature;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/7/11 11:14 AM
 * @desc :
 */
public class HandlerThreadActivity extends AppCompatActivity{

    private static final String TAG = HandlerThreadActivity.class.getSimpleName();

    int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    int KEEP_ALIVE_TIME = 1;
    TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
    ExecutorService mExecutorService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hander_thread);

        mExecutorService = new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES*2, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, taskQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        HandlerThread handlerThread = new HandlerThread("TEST");
        handlerThread.start();
        Handler childHandler = new Handler(handlerThread.getLooper(),new ChildCallBack());
        for(int i=0;i<7;i++) {
            childHandler.sendEmptyMessageDelayed(i,1000);
        }

    }

    /**
     * CallBack运行在子线程中
     */
    class ChildCallBack implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            Log.i(TAG,"what: " + msg.what);
            return false;
        }
    }


}
