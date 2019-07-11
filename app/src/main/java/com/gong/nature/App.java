package com.gong.nature;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import java.util.List;

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

        boolean isMainProcess = isMainProcess();
        if(isMainProcess) {

        }

    }

    private boolean isMainProcess() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = android.os.Process.myPid();

        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }


}
