package com.example.retretku;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class add_paket_katering_fragment extends Fragment {

    RadioButton radioButton1, radioButton2;
    EditText txt_nama, txt_deskripsi, txt_harga;
    Button btn_add_paket,btn_add_menu;
    ArrayList<katering_class> list_katering = new ArrayList<katering_class>();
    ArrayList<paket_class> list_paket_makanan = new ArrayList<paket_class>();
    ArrayList<paket_class> list_paket_snack = new ArrayList<paket_class>();
    ArrayList<menu_class> list_menu = new ArrayList<menu_class>();
    ArrayList<menu_class> list_paket = new ArrayList<menu_class>();
    ArrayList<menu_class> tmp_menu = new ArrayList<menu_class>();
    ListView lv;
    Spinner sp;
    ArrayAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_paket_katering_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = view.findViewById(R.id.lv_menu);
        list_katering = ((katering)getActivity()).list_katering;
        list_paket_makanan = ((katering)getActivity()).list_paket_makanan;
        list_paket_snack = ((katering)getActivity()).list_paket_snack;
        list_menu = ((katering)getActivity()).list_menu;
        btn_add_paket = view.findViewById(R.id.btn_add_paket);
        txt_nama = view.findViewById(R.id.txt_nama);
        txt_deskripsi = view.findViewById(R.id.txt_deskripsi);
        txt_harga = view.findViewById(R.id.txt_harga);
        btn_add_menu = view.findViewById(R.id.btn_add_menu);
        radioButton2 = view.findViewById(R.id.radioButton3);
        radioButton1 = view.findViewById(R.id.radioButton2);


        tmp_menu.clear();

        for(int i=0;i<list_katering.get(0).getList_menu().size();i++){
            for (int j=0;j<list_menu.size();j++){
                if(list_menu.get(j).getId().equals(list_katering.get(0).getList_menu().get(i))){
                    tmp_menu.add(list_menu.get(j));
                }
            }
        }

        sp = view.findViewById(R.id.spinner_menu);
        ArrayAdapter adapt = new ArrayAdapter(view.getContext(),android.R.layout.simple_spinner_dropdown_item,tmp_menu);
        adapter = new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,list_paket);

        lv.setAdapter(adapter);
        sp.setAdapter(adapt);

        btn_add_paket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp_nama, tmp_deskripsi;
                int tmp_harga;
                tmp_nama = txt_nama.getText().toString();
                tmp_deskripsi = txt_deskripsi.getText().toString();
                tmp_harga = Integer.parseInt(txt_harga.getText().toString());
                if(!tmp_nama.equals("") && !tmp_deskripsi.equals("") && tmp_harga>-1 && radioButton1.isChecked()){
                    list_paket_makanan.add(new paket_class(list_paket_makanan.size()+1+"",tmp_harga,tmp_nama,tmp_deskripsi));
                    list_katering.get(0).add_paket_makanan(list_paket_makanan.size()+"");

                    for(int i=0;i<list_paket.size();i++){
                        list_paket_makanan.get(list_paket_makanan.size()-1).add_menu(list_paket.get(i).getId());
                    }

                    Toast.makeText(view.getContext(), "Paket Berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                    ((katering)getActivity()).update(list_katering,list_paket_makanan,list_paket_snack,list_menu);
                }
                else if(!tmp_nama.equals("") && !tmp_deskripsi.equals("") && tmp_harga>-1 && radioButton2.isChecked()){
                    list_paket_snack.add(new paket_class(list_paket_snack.size()+1+"",tmp_harga,tmp_nama,tmp_deskripsi));
                    list_katering.get(0).add_paket_snack(list_paket_snack.size()+"");

                    for(int i=0;i<list_paket.size();i++){
                        list_paket_snack.get(list_paket_snack.size()-1).add_menu(list_paket.get(i).getId());
                    }

                    Toast.makeText(view.getContext(), "Paket Berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                    ((katering)getActivity()).update(list_katering,list_paket_makanan,list_paket_snack,list_menu);
                }
            }
        });

        btn_add_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = sp.getSelectedItem().toString();
                int idx = -1;

                for(int i=0;i<list_menu.size();i++){
                    if(tmp.equals(list_menu.get(i).getNama())){
                        idx = i;
                        break;
                    }
                }

                if(idx!=-1){
                    list_paket.add(list_menu.get(idx));
                }

                adapter.notifyDataSetChanged();
            }
        });
    }
}
