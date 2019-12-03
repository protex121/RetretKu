package com.example.retretku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Objects.Fasilitas;

import java.util.ArrayList;

public class rvFasilitasPengelola extends RecyclerView.Adapter<rvFasilitasPengelola.LFPViewHolder> {

    //Variable declarations
    ArrayList<Fasilitas> facilities;

    public rvFasilitasPengelola(ArrayList<Fasilitas> facilities) {
        this.facilities = facilities;
    }

    @NonNull
    @Override
    public LFPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.l_fasilitas_pengelola, parent,false);
        return new LFPViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LFPViewHolder holder, int position) {
        holder.nama.setText(facilities.get(position).getNama());

        String tempTextHolder = "Qty: " + facilities.get(position).getJumlah();
        holder.jml.setText(tempTextHolder);

        tempTextHolder = "x Rp. " + facilities.get(position).getHarga();
        holder.hrg.setText(tempTextHolder);

        holder.desc.setText(facilities.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return facilities.size();
    }

    public class LFPViewHolder extends RecyclerView.ViewHolder {
        TextView nama,jml,hrg,desc;

        public LFPViewHolder(@NonNull View itemView) {
            super(itemView);

            //Deklarasi untuk komponen di l_fasilitas_pengelola
            nama = itemView.findViewById(R.id.tNamaFasilitas_LFP);
            jml = itemView.findViewById(R.id.tJumlahFasilitas_LFP);
            hrg = itemView.findViewById(R.id.tHargaFasilitas_LFP);
            desc = itemView.findViewById(R.id.tDeskripsi_LFP);
        }
    }
}
