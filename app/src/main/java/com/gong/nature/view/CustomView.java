package com.gong.nature.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/7/12 9:17 AM
 * @desc :
 */
public class CustomView extends android.support.v7.widget.AppCompatTextView{

    private static final String TAG = CustomView.class.getSimpleName();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.i(TAG,"onFinishInflate");
    }


}
