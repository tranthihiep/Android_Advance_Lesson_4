package com.haha.imagegalleryusingasynctask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by trant on 12/01/2018.
 */

public class ImageAsyncTask extends AsyncTask<Void,Void,ArrayList<Bitmap>> {
    private OnTaskCompleted mOnTask;
    private Activity mActivity;

    ImageAsyncTask(OnTaskCompleted onTaskCompleted, Activity activity) {
        mOnTask = onTaskCompleted;
        mActivity = activity;
    }


    @Override
    protected ArrayList<Bitmap> doInBackground(Void... voids) {
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        String path = Environment.getExternalStorageDirectory().getPath()+"/Download";
        File file = new File(path);
        File files[] = file.listFiles();
        if (files.length==0){return null;}
        else{
            for (int i = 0; i < files.length; i++) {
                bitmaps.add(BitmapFactory.decodeFile(files[i].getPath()));
            }
        }
        return bitmaps;
    }

    @Override
    protected void onPostExecute(ArrayList<Bitmap> bitmaps) {
                  mOnTask.onTaskCompleted(bitmaps);
                  super.onPostExecute(bitmaps);
              }
}

