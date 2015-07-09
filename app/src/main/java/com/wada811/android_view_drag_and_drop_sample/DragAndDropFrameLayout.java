package com.wada811.android_view_drag_and_drop_sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class DragAndDropFrameLayout extends FrameLayout {

    public static final String TAG = DragAndDropFrameLayout.class.getSimpleName();

    public DragAndDropFrameLayout(Context context){
        super(context);
    }

    public DragAndDropFrameLayout(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public DragAndDropFrameLayout(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(VERSION_CODES.LOLLIPOP)
    public DragAndDropFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onDragEvent(DragEvent event){
        switch(event.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(TAG, "View: " + this.toString());
                Log.d(TAG, "DragEvent.ACTION_DRAG_STARTED");
                return true;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(TAG, "View: " + this.toString());
                Log.d(TAG, "DragEvent.ACTION_DRAG_ENTERED");
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
//                Log.d(TAG, "View: " + this.toString());
//                Log.d(TAG, "DragEvent.ACTION_DRAG_LOCATION");
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(TAG, "View: " + this.toString());
                Log.d(TAG, "DragEvent.ACTION_DRAG_EXITED");
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(TAG, "View: " + this.toString());
                Log.d(TAG, "DragEvent.ACTION_DRAG_ENDED");
                return true;
            case DragEvent.ACTION_DROP:
                Log.d(TAG, "View: " + this.toString());
                Log.d(TAG, "DragEvent.ACTION_DROP");
                View view = (View)event.getLocalState();
                MarginLayoutParams layoutParams = (MarginLayoutParams)view.getLayoutParams();
                layoutParams.leftMargin = (int)event.getX() - 50;
                layoutParams.topMargin = (int)event.getY() - 50;
                if(view.getParent().equals(this)){
                    view.setLayoutParams(layoutParams);
                }else{
                    ((ViewGroup)view.getParent()).removeView(view);
                    addView(view, layoutParams);
                }
                return true;
        }
        return super.onDragEvent(event);
    }
}
