package com.ogoons.recyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogoons.recyclerviewsample.model.Item;
import com.ogoons.recyclerviewsample.model.ItemA;
import com.ogoons.recyclerviewsample.model.ItemB;

import java.util.ArrayList;

/**
 * Created by OGOONS on 2017. 3. 1..
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_A = 0;
    private static final int ITEM_B = 1;

    private ArrayList<Item> mItems;

    public MyRecyclerViewAdapter(ArrayList<Item> items) {
        mItems = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_a, parent, false);
                holder = new HolderA(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_b, parent, false);
                holder = new HolderB(view);
                break;
        }
        return holder;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (mItems.get(position).itemType) {
            case A:
                return ITEM_A;
            case B:
                return ITEM_B;
            default:
                return ITEM_A;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                HolderA holderA = (HolderA) holder;
                ItemA itemA = (ItemA) mItems.get(position);
                holderA.textView.setText(itemA.name);
                break;
            case 1:
                HolderB holderB = (HolderB) holder;
                ItemB itemB = (ItemB) mItems.get(position);
                holderB.textView.setText(itemB.name);
                break;
        }

    }

    private static class HolderA extends RecyclerView.ViewHolder {
        public TextView textView;
        public HolderA(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.tv);
        }
    }

    private static class HolderB extends RecyclerView.ViewHolder {
        public TextView textView;
        public HolderB(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.tv);
        }
    }
}
