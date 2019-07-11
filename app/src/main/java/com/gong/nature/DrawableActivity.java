package com.gong.nature;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import static android.graphics.drawable.GradientDrawable.LINEAR_GRADIENT;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/7/11 3:22 PM
 * @desc :
 */
public class DrawableActivity extends AppCompatActivity{

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        ImageView iv = (ImageView) findViewById(R.id.imageview);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setStroke(10, Color.RED);
        drawable.setGradientType(LINEAR_GRADIENT);
        drawable.setColors(new int[]{Color.RED,Color.BLUE});

        iv.setBackground(drawable);

    }


}
