package com.example.retretku.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Interface.KateringOnClickListener;
import com.example.retretku.R;
import com.example.retretku.Object.Katering;

import java.util.ArrayList;

public class KateringAdapter extends RecyclerView.Adapter<KateringAdapter.KateringViewHolder> {
    private Context context;
    private ArrayList<Katering> list;
    private KateringOnClickListener kateringOnClickListener;

    public KateringAdapter(Context context, ArrayList<Katering> list) {
        this.context = context;
        this.list = list;
    }

    public void setKateringOnClickListener(KateringOnClickListener kateringOnClickListener) {
        this.kateringOnClickListener = kateringOnClickListener;
    }

    @NonNull
    @Override
    public KateringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_katering,parent,false);
        KateringViewHolder holder = new KateringViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KateringViewHolder holder, int position) {
        Katering temp = list.get(position);
        holder.tvNama.setText(temp.getNama_katering());
        if(temp.getStat()==1){
            holder.tvStatus.setText("Enabled");
            holder.tvStatus.setTextColor(Color.GREEN);
        }
        else {
            holder.tvStatus.setText("Disabled");
            holder.tvStatus.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class KateringViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvStatus;
        public KateringViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvKateringNama);
            tvStatus = itemView.findViewById(R.id.tvKateringStatus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(kateringOnClickListener!=null){
                        kateringOnClickListener.OnClick(itemView,getAdapterPosition());
                    }
                }
            });
        }
    }
}
