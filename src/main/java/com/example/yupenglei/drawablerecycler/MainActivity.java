package com.example.yupenglei.drawablerecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleItemTouchAdapter adapter = new SimpleItemTouchAdapter();
        recyclerView.setAdapter(adapter);

        //创建回调
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        //创建ItemTouchHelper
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        //ItemTouchHelper绑定到RecyclerView
        helper.attachToRecyclerView(recyclerView);
    }

}
