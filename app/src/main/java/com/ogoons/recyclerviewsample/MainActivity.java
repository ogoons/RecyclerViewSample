package com.ogoons.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ogoons.recyclerviewsample.model.Item;
import com.ogoons.recyclerviewsample.model.ItemA;
import com.ogoons.recyclerviewsample.model.ItemB;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Item> items = new ArrayList<>();
        items.add(new ItemA("RED"));
        items.add(new ItemB("BLUE"));

        mAdapter = new MyRecyclerViewAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
    }
}
