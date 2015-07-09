package com.wada811.android_view_drag_and_drop_sample;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import android.view.View.DragShadowBuilder;

public class MyDragShadowBuilder extends DragShadowBuilder {

    public MyDragShadowBuilder(View view){
        super(view);
    }

    @Override
    public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint){
        super.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
    }

    @Override
    public void onDrawShadow(Canvas canvas){
        super.onDrawShadow(canvas);
    }
}
