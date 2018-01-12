package com.haha.imagegalleryusingasynctask;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by trant on 12/01/2018.
 */

public interface OnTaskCompleted{
    void onTaskCompleted(ArrayList<Bitmap> bitmapList);
}
