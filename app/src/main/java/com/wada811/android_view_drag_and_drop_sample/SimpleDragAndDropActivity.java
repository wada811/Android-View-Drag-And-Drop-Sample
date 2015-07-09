package com.wada811.android_view_drag_and_drop_sample;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class SimpleDragAndDropActivity extends AppCompatActivity implements OnLongClickListener {

    public static final String TAG = SimpleDragAndDropActivity.class.getSimpleName();

    DragAndDropFrameLayout frameLayout1;
    DragAndDropFrameLayout frameLayout2;

    public static Intent createIntent(Context context){
        return new Intent(context, SimpleDragAndDropActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_drag_and_drop);

        frameLayout1 = (DragAndDropFrameLayout)findViewById(R.id.FrameLayout1);
        frameLayout2 = (DragAndDropFrameLayout)findViewById(R.id.FrameLayout2);

        frameLayout1.setClipChildren(false);
        frameLayout1.setClipToPadding(false);
        frameLayout2.setClipChildren(false);
        frameLayout2.setClipToPadding(false);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        imageView.setOnLongClickListener(this);

        LayoutParams layoutParams = new LayoutParams(48 * 3, 48 * 3);
        frameLayout1.addView(imageView, layoutParams);
    }

    @Override
    public boolean onLongClick(View view){
        ClipData clipData = ClipData.newPlainText(view.toString(), view.toString());
        view.startDrag(clipData, new MyDragShadowBuilder(view), view, 0);
        return false;
    }

}
