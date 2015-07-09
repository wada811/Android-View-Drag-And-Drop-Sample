package com.wada811.android_view_drag_and_drop_sample;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import java.util.Arrays;
import java.util.List;

public class RecyclerDragAndDropActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    public static Intent createIntent(Context context){
        return new Intent(context, RecyclerDragAndDropActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_drag_and_drop);

        recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter<>(Arrays.asList("1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1")));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new RecyclerViewDecoration(this));
    }


    public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder>
        implements OnLongClickListener {

        private final List<T> items;

        public RecyclerViewAdapter(List<T> items){
            super();
            this.items = items;
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            parent.setClipChildren(false);
            parent.setClipToPadding(false);
            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.list_item_drag_and_drop, parent, false);
            ((ViewGroup)view).setClipChildren(false);
            ((ViewGroup)view).setClipToPadding(false);


            ImageView imageView = new ImageView(getBaseContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            imageView.setOnLongClickListener(this);
            LayoutParams layoutParams = new LayoutParams(48 * 3, 48 * 3);
            ((ViewGroup)view).addView(imageView, layoutParams);

            RecyclerViewHolder viewHolder = new RecyclerViewHolder(getBaseContext(), view);
            view.setTag(viewHolder);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position){

        }

        @Override
        public int getItemCount(){
            return items.size();
        }

        @Override
        public boolean onLongClick(View view){
            ClipData clipData = ClipData.newPlainText(view.toString(), view.toString());
            view.startDrag(clipData, new MyDragShadowBuilder(view), view, 0);
            return false;
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        FrameLayout frameLayout1;
        FrameLayout frameLayout2;

        public RecyclerViewHolder(Context context, View itemView){
            super(itemView);

            frameLayout1 = (FrameLayout)itemView.findViewById(R.id.FrameLayout1);
            frameLayout2 = (FrameLayout)itemView.findViewById(R.id.FrameLayout2);
        }
    }

    public class RecyclerViewDecoration extends RecyclerView.ItemDecoration implements OnLongClickListener {

        private final Context context;

        public RecyclerViewDecoration(Context context){
            this.context = context;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state){
            super.getItemOffsets(outRect, view, parent, state);
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, State state){
            super.onDraw(c, parent, state);
            Log.d("onDraw" + System.currentTimeMillis(), "state: " + state.toString());
            Log.d("onDraw" , "parent.getChildCount() : " + parent.getChildCount());
            for(int i = 0, count = parent.getChildCount(); i < count; i++){
                View view = parent.getChildAt(i);
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.mipmap.ic_launcher);
                imageView.setOnLongClickListener(this);
                LayoutParams layoutParams = new LayoutParams(48 * 3, 48 * 3);
                ((ViewGroup)view).addView(imageView, layoutParams);
            }
        }

        @Override
        public boolean onLongClick(View view){
            ClipData clipData = ClipData.newPlainText(view.toString(), view.toString());
            view.startDrag(clipData, new MyDragShadowBuilder(view), view, 0);
            return false;
        }
    }

}
