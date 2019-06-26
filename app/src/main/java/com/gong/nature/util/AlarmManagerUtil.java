package com.gong.nature.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/24 9:13 PM
 * @desc : 开启定时任务
 */
public class AlarmManagerUtil {

    public static AlarmManager getAlarmManager(Context context) {
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    /**
     * 发送定时广播
     * @param context
     * @param requestCode 请求码
     * @param type AlarmManager启动类型
     * @param triggerAtTime 定时任务开启的时间，毫秒为单位
     * @param clz
     */
    public static void sendAlarmBroadcast(Context context,int requestCode,int type,long triggerAtTime,Class clz) {
        AlarmManager alarmManager = getAlarmManager(context);
        PendingIntent pi = getPendingIntent(context,requestCode,clz);
        alarmManager.set(type,triggerAtTime,pi);
    }

    /**
     * 取消定时任务
     * @param context
     * @param requestCode
     * @param clz
     */
    public static void cancelAlarmBroadcast(Context context,int requestCode,Class clz) {
        AlarmManager alarmManager = getAlarmManager(context);
        PendingIntent pi = getPendingIntent(context,requestCode,clz);
        alarmManager.cancel(pi);
    }

    /**
     * 周期性执行定时任务
     * @param context
     * @param requestCode
     * @param type
     * @param startTime
     * @param cycleTime
     * @param clz
     */
    public static void sendRepeatAlarmBroadcast(Context context,
                                                int requestCode, int type, long startTime, long cycleTime, Class clz) {
        AlarmManager mgr = getAlarmManager(context);
        PendingIntent pi = getPendingIntent(context,requestCode,clz);
        mgr.setRepeating(type, startTime, cycleTime, pi);
    }

    /**
     *
     * @param context
     * @param requestCode
     * @param clz
     * @return
     */
    public static PendingIntent getPendingIntent(Context context,int requestCode,Class clz) {
        Intent i = new Intent(context,clz);
        PendingIntent pi = PendingIntent.getBroadcast(context,requestCode,i,0);
        return pi;
    }


}
