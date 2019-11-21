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

import java.util.ArrayList;

public class home_katering_fragment extends Fragment {
    ArrayList<katering_class> list_katering = new ArrayList<katering_class>();
    ListView lv_menu;

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

        ArrayAdapter adapt = new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,list_katering.get(0).getList_menu());

        lv_menu.setAdapter(adapt);
    }
}
