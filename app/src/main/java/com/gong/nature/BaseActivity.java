package com.gong.nature;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/22 9:25 PM
 * @desc :
 */
public class BaseActivity extends AppCompatActivity{

    protected BaseHandler mBaseHandler = new BaseHandler(this);

    public static class BaseHandler extends Handler {

        private WeakReference<Activity> mActivityWeakReference;

        public BaseHandler(Activity ac) {
            mActivityWeakReference = new WeakReference<>(ac);
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void handleMessage(Message msg) {
            Activity ac = mActivityWeakReference.get();

            if(null != ac && !ac.isFinishing() && !ac.isDestroyed()) {
                if(ac instanceof BaseActivity) {
                    ((BaseActivity) ac).handleMessage(ac,msg);
                }
            }
        }
    }

    protected void handleMessage(Activity ac,Message msg) {

    }


}
