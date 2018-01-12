package com.haha.imagegalleryusingasynctask;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted {
        private RecyclerView mRecyclerView;
        private ArrayList<Bitmap> mImageGallery = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            ImageAsyncTask imageAsyncTask = new ImageAsyncTask(this, this);
            imageAsyncTask.execute();
            initView(mRecyclerView);
        }

        private void initView(RecyclerView recyclerView){
            recyclerView.setHasFixedSize(true);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                    StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            AdapterImage adapter = new AdapterImage(mImageGallery,this);
            mRecyclerView.setAdapter(adapter);
            AdapterImage mAdapterHero = new AdapterImage(mImageGallery,getApplicationContext());
            recyclerView.setAdapter(mAdapterHero);
        }
    @Override
    public void onTaskCompleted(ArrayList<Bitmap> bitmapList) {
        mImageGallery.addAll(bitmapList);
    }
}
