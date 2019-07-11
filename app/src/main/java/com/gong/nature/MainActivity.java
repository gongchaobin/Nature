package com.gong.nature;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.gong.nature.fragment.RecyclerViewFragment;

public class MainActivity extends BaseActivity {

    private PowerManager.WakeLock mWakeLock;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBaseHandler.sendEmptyMessage(0);

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.ON_AFTER_RELEASE
                | PowerManager.PARTIAL_WAKE_LOCK, "Tag");


        mViewPager = findViewById(R.id.viewpager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

    }

    /**
     * 隐式跳转之前，检测activity是否存在
     * @param url
     * @param nameType
     */
    public void viewUrl(String url,String nameType) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(url),nameType);

        if(getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    class PagerAdapter extends FragmentStatePagerAdapter {
        private RecyclerView.RecycledViewPool mPool = new RecyclerView.RecycledViewPool();


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            RecyclerViewFragment f = new RecyclerViewFragment();
            f.setViewPool(mPool);
            return f;
        }


        @Override
        public int getCount() {
            return 4;
        }
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
