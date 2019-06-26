package com.gong.nature.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/23 10:42 AM
 * @desc :
 */
public class BitmapUtil {

    public static Bitmap decodeFile(String filePath) {
        if(TextUtils.isEmpty(filePath)) {
            return null;
        }
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
            return BitmapFactory.decodeStream(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
