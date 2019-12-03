package com.example.retretku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Objects.Rating;

import java.util.ArrayList;

public class rvRatingAdapter extends RecyclerView.Adapter<rvRatingAdapter.LRTPViewHolder> {
    ArrayList<Rating> ratings;

    public rvRatingAdapter(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    @NonNull
    @Override
    public LRTPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.l_rating_to_pengelola, parent,false);
        return new LRTPViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LRTPViewHolder holder, int position) {
        holder.nama.setText(ratings.get(position).getRater().getNama());
        holder.iv.setImageResource(ratings.get(position).getRater().getImgAddress());
        holder.rate.setRating(ratings.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return ratings.size();
    }

    public class LRTPViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        RatingBar rate;
        ImageView iv;

        public LRTPViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tNama_LRTP);
            iv = itemView.findViewById(R.id.ivPP_LRTP);
            rate = itemView.findViewById(R.id.rating_LRTP);
        }
    }
}
