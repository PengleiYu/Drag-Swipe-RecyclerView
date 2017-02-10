package com.example.yupenglei.drawablerecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yupenglei on 17/2/10.
 */
public class SimpleItemTouchAdapter extends RecyclerView.Adapter<SimpleItemTouchAdapter.VH> implements
        SimpleItemTouchHelperCallback.ItemTouchHelperAdapter {
    private List<String> mItems;

    public SimpleItemTouchAdapter() {
        mItems = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mItems.add("What are you fucking? x" + i);
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.mTextView.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     * 拖动时数据集变化
     */
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    /**
     * 滑动时数据集变化
     */
    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public class VH extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public VH(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
