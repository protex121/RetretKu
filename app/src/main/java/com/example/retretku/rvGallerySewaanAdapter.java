package com.example.retretku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Object.RumahRetret;


public class rvGallerySewaanAdapter extends RecyclerView.Adapter<rvGallerySewaanAdapter.rvGalleryViewholder> {
    RumahRetret rr;

    public rvGallerySewaanAdapter(RumahRetret rr) {
        this.rr = rr;
    }

    @NonNull
    @Override
    public rvGalleryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.l_gallery_sewaan, parent, false);
        return new rvGalleryViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull rvGalleryViewholder holder, int position) {
        holder.iv.setImageURI(rr.getImages().get(position));
    }

    @Override
    public int getItemCount() {
        return rr.getImages().size();
    }

    public class rvGalleryViewholder extends RecyclerView.ViewHolder {
        ImageView iv;
        public rvGalleryViewholder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.ivGallery_LGS);
        }
    }
}
