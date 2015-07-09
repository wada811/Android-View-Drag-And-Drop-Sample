package com.wada811.android_view_drag_and_drop_sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;

public class ListDragAndDropActivity extends AppCompatActivity {

    public static final String TAG = ListDragAndDropActivity.class.getSimpleName();

    public static Intent createIntent(Context context){
        return new Intent(context, ListDragAndDropActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_drag_and_drop);

        ListView listView = (ListView)findViewById(R.id.ListView);
        List<String> list = Arrays.asList("1", "1", "1", "1", "1", "1", "1");
        listView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        listView.setAdapter(new DragAndDropListAdapter(this, list));
        listView.invalidate();
    }

}
