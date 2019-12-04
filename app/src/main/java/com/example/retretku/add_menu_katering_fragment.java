package com.example.retretku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class add_menu_katering_fragment extends Fragment {
    Button btn_add;
    EditText txt_nama,txt_deskripsi;
    RadioButton rb_makanan;
    ImageView imgView;
    StorageReference
    ArrayList<katering_class> list_katering = new ArrayList<katering_class>();
    ArrayList<paket_class> list_paket_makanan = new ArrayList<paket_class>();
    ArrayList<paket_class> list_paket_snack = new ArrayList<paket_class>();
    ArrayList<menu_class> list_menu = new ArrayList<menu_class>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_menu_katering_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list_katering = ((katering)getActivity()).list_katering;
        list_paket_makanan = ((katering)getActivity()).list_paket_makanan;
        list_paket_snack = ((katering)getActivity()).list_paket_snack;
        list_menu = ((katering)getActivity()).list_menu;
        rb_makanan = view.findViewById(R.id.rb_makanan);
        btn_add = view.findViewById(R.id.btn_add);
        txt_nama = view.findViewById(R.id.txt_nama);
        txt_deskripsi = view.findViewById(R.id.text_deskripsi);
        imgView = view.findViewById(R.id.imageView12);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp_nama , tmp_deskripsi;

                tmp_nama = txt_nama.getText().toString();
                tmp_deskripsi = txt_deskripsi.getText().toString();
                int tmp;

                if(rb_makanan.isChecked()){
                    tmp = 0;
                }
                else{
                    tmp=1;
                }

                if(!tmp_nama.equals("") && !tmp_deskripsi.equals("")){
                    int tmp_jml = list_menu.size()+1;
                    String tmp_id="MEN";
                    if(tmp_jml<10){
                        tmp_id+="00"+tmp_jml;
                    }
                    else if(tmp_jml<100){
                        tmp_id+="0"+tmp_jml;
                    }
                    else{
                        tmp_id+=tmp_jml;
                    }
                    list_menu.add(new menu_class(tmp_id,tmp_nama,tmp,tmp_deskripsi));
                    list_katering.get(0).add_menu(tmp_id);
                    Toast.makeText(view.getContext(), "Menu Berhasil ditambahkan", Toast.LENGTH_SHORT).show();


                    ((katering)getActivity()).update(list_katering,list_paket_makanan,list_paket_snack,list_menu);
                }
            }
        });
    }
}
