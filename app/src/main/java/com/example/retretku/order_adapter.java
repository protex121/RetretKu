package com.example.retretku;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class order_adapter extends RecyclerView.Adapter<order_adapter.orderViewHolder> {
    @NonNull
    @Override
    public orderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull orderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class orderViewHolder extends RecyclerView.ViewHolder {
        public orderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
