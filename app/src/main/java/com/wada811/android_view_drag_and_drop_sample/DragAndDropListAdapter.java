package com.wada811.android_view_drag_and_drop_sample;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;

public class DragAndDropListAdapter extends BindableAdapter<String> {

    public DragAndDropListAdapter(Context context, List<String> list){
        super(context, list);
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container){
        container.setClipChildren(false);
        container.setClipToPadding(false);
        View view = inflater.inflate(R.layout.list_item_drag_and_drop, container, false);
        ((ViewGroup)view).setClipChildren(false);
        ((ViewGroup)view).setClipToPadding(false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(String item, int position, View view){
        ViewHolder holder = (ViewHolder)view.getTag();
        view.bringToFront();
    }

    private class ViewHolder implements OnLongClickListener {

        FrameLayout frameLayout1;
        FrameLayout frameLayout2;
        ImageView imageView;

        @TargetApi(VERSION_CODES.LOLLIPOP)
        public ViewHolder(View view){
            frameLayout1 = (FrameLayout)view.findViewById(R.id.FrameLayout1);
            frameLayout2 = (FrameLayout)view.findViewById(R.id.FrameLayout2);
            imageView = new ImageView(getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            imageView.setOnLongClickListener(this);
            imageView.setCameraDistance(1000f);
            LayoutParams layoutParams = new LayoutParams(48 * 3, 48 * 3);
            ((ViewGroup)view).addView(imageView, layoutParams);
        }

        @Override
        public boolean onLongClick(View view){
            ClipData clipData = ClipData.newPlainText(view.toString(), view.toString());
            view.startDrag(clipData, new MyDragShadowBuilder(view), view, 0);
            return false;
        }
    }
}
