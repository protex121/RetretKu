package com.example.retretku;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class rvRatingAdapter extends RecyclerView.Adapter<rvRatingAdapter.LRTPViewHolder> {
    @NonNull
    @Override
    public LRTPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LRTPViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LRTPViewHolder extends RecyclerView.ViewHolder {
        public LRTPViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
