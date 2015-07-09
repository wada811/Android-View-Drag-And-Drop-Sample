package com.wada811.android_view_drag_and_drop_sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ClipChildrenActivity extends AppCompatActivity {

    public static Intent createIntent(Context context){
        return new Intent(context, ClipChildrenActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_children);

        ImageView imageView = (ImageView)findViewById(R.id.ImageView);
        imageView.bringToFront();
        imageView.getParent().bringChildToFront(imageView);
//        ((ViewGroup)imageView.getParent()).bringToFront();

    }
}
