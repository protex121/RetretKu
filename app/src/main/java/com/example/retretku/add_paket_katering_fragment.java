package com.example.retretku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class add_paket_katering_fragment extends Fragment {
    EditText txt_nama, txt_deskripsi, txt_harga;
    Button btn_add_paket;
    ArrayList<katering_class> list_katering = new ArrayList<katering_class>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_paket_katering_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list_katering = ((katering)getActivity()).list_katering;
        btn_add_paket = view.findViewById(R.id.btn_add_paket);
        txt_nama = view.findViewById(R.id.txt_nama);
        txt_deskripsi = view.findViewById(R.id.txt_deskripsi);
        txt_harga = view.findViewById(R.id.txt_harga);

        btn_add_paket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp_nama, tmp_deskripsi;
                int tmp_harga;
                tmp_nama = txt_nama.getText().toString();
                tmp_deskripsi = txt_deskripsi.getText().toString();
                tmp_harga = Integer.parseInt(txt_harga.getText().toString());
                if(!tmp_nama.equals("") && !tmp_deskripsi.equals("") && tmp_harga>-1){
                    list_katering.get(0).add_paket_makanan(new paket_class(tmp_harga,tmp_nama,tmp_deskripsi));

                    Toast.makeText(view.getContext(), "Paket Berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                    ((katering)getActivity()).update(list_katering);
                }
            }
        });
    }
}
