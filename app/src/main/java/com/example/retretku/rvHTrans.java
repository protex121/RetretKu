package com.example.retretku;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class rvHTrans extends RecyclerView.Adapter<rvHTrans.HTransViewHolder> {
    OnHTRANSClickListener onHTransClickListener;
    ArrayList<HTrans> htrans;
    Context parentActivity;

    public rvHTrans(ArrayList<HTrans> htrans, Context parentActivity, OnHTRANSClickListener ohcl) {
        this.htrans = htrans;
        this.parentActivity = parentActivity;
        onHTransClickListener = ohcl;
    }

    @NonNull
    @Override
    public HTransViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.l_h_transaksi, parent,false);
        return new HTransViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HTransViewHolder holder, int position) {
        holder.idTrans.setText(htrans.get(position).getId_trans());

        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd MMM yyyy");
        String strDt = simpleDate.format(htrans.get(position).getCin());
        holder.cin.setText(strDt);

        strDt = simpleDate.format(htrans.get(position).getCout());
        holder.cout.setText(strDt);

        String tempTextHolder = "Rp. " + htrans.get(position).getTotal() + ",-";
        holder.total.setText(tempTextHolder);

        if(htrans.get(position).getStatus() == 0){
            holder.status.setText("Pending");
        }
        else if(htrans.get(position).getStatus() == 1){
            holder.status.setText("Ongoing");
            holder.status.setTextColor(Color.BLUE);
        }
        else if(htrans.get(position).getStatus() == 2){
            holder.status.setText("Done");
            holder.status.setTextColor(parentActivity.getResources().getColor(R.color.colorPrimaryDark));
        }
        else if(htrans.get(position).getStatus() == 3){
            holder.status.setText("Rejected");
            holder.status.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return htrans.size();
    }

    public class HTransViewHolder extends RecyclerView.ViewHolder {
        TextView idTrans, cin, cout, status, total;

        public HTransViewHolder(@NonNull final View itemView) {
            super(itemView);

            idTrans = itemView.findViewById(R.id.tIdTransaksi_LHT);
            cin = itemView.findViewById(R.id.textTanggalCheckIn_LHT);
            cout = itemView.findViewById(R.id.textTanggalCheckOut_LHT);
            status = itemView.findViewById(R.id.tStatus_LHT);
            total = itemView.findViewById(R.id.tTotal_LHT);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onHTransClickListener.onClick(itemView,getAdapterPosition());
                }
            });
        }
    }
}
