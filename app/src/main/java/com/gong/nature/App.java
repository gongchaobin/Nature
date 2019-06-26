package com.gong.nature;

import android.app.Application;
import android.os.StrictMode;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/23 8:09 AM
 * @desc :
 */
public class App extends Application{

    @Override
    public void onCreate() {
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites()
                .detectNetwork().penaltyLog()
                .build());
        super.onCreate();
    }


}
