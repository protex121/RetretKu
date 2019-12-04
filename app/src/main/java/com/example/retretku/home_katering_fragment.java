package com.example.retretku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class home_katering_fragment extends Fragment {
    ArrayList<katering_class> list_katering = new ArrayList<katering_class>();
    private ArrayList<paket_class> list_paket_makanan = new ArrayList<paket_class>();
    private ArrayList<paket_class> list_paket_snack = new ArrayList<paket_class>();
    private ArrayList<menu_class> list_menu = new ArrayList<menu_class>();
    ArrayList<menu_class> tmp_menu = new ArrayList<menu_class>();

    RecyclerView lv_menu;

    RecyclerView lv_order;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_katering_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_menu = view.findViewById(R.id.rv_menu);
        list_katering = ((katering)getActivity()).list_katering;
        list_paket_makanan = ((katering)getActivity()).list_paket_makanan;
        list_paket_snack = ((katering)getActivity()).list_paket_snack;
        list_menu = ((katering)getActivity()).list_menu;

        tmp_menu.clear();

        for(int i=0;i<list_katering.get(0).getList_menu().size();i++){
            for (int j=0;j<list_menu.size();j++){
                if(list_menu.get(j).getId().equals(list_katering.get(0).getList_menu().get(i))){
                    tmp_menu.add(list_menu.get(j));
                }
            }
        }

        ArrayAdapter adapt = new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,tmp_menu);

        //lv_menu.setAdapter(adapt);
    }
}
