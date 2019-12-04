package com.example.retretku.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Interface.RumahRetretOnClickListener;
import com.example.retretku.R;
import com.example.retretku.Object.RumahRetret;

import java.util.ArrayList;

public class RumahRetretAdapter extends RecyclerView.Adapter<RumahRetretAdapter.RumahRetretViewHolder> {
    private Context context;
    private ArrayList<RumahRetret> list;
    private RumahRetretOnClickListener rumahRetretOnClickListener;

    public RumahRetretAdapter(Context context, ArrayList<RumahRetret> list) {
        this.context = context;
        this.list = list;
    }

    public void setRumahRetretOnClickListener(RumahRetretOnClickListener rumahRetretOnClickListener) {
        this.rumahRetretOnClickListener = rumahRetretOnClickListener;
    }

    @NonNull
    @Override
    public RumahRetretViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_rumah_retret,parent,false);
        RumahRetretViewHolder holder = new RumahRetretViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RumahRetretViewHolder holder, int position) {
        RumahRetret temp = list.get(position);
        holder.tvNama.setText(temp.getRumah_nama());
        if(temp.getRumah_status()==1){
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

    public class RumahRetretViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvStatus;
        public RumahRetretViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvRumahRetretNama);
            tvStatus = itemView.findViewById(R.id.tvRumahRetretStatus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rumahRetretOnClickListener!=null){
                        rumahRetretOnClickListener.OnClick(itemView,getAdapterPosition());
                    }
                }
            });
        }
    }
}
