package com.gong.nature;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;

public class MainActivity extends BaseActivity {

    private PowerManager.WakeLock mWakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBaseHandler.sendEmptyMessage(0);

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.ON_AFTER_RELEASE
                | PowerManager.PARTIAL_WAKE_LOCK, "Tag");

    }

    @Override
    protected void onResume() {
        mWakeLock.acquire();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mWakeLock.release();
        super.onPause();
    }

    @Override
    protected void handleMessage(Activity ac, Message msg) {
        super.handleMessage(ac, msg);
    }

}
