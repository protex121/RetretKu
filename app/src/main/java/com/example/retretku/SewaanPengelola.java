package com.example.retretku;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retretku.Objects.Fasilitas;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SewaanPengelola extends Fragment {

    TextView seeMore;
    ArrayList<Fasilitas> facilities;
    RecyclerView rv;

    public SewaanPengelola() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sewaan_pengelola, container, false);

        //Component finding
        rv = v.findViewById(R.id.rvFasilitas_SewaanPengelola);

        //Declare facilities
        facilities = new ArrayList<>();
        facilities.add(new Fasilitas("123456","King Size Bed","ZONK", 450000, 3));
        facilities.add(new Fasilitas("123456","Sofa 5 Orang","ZONK", 120000, 4));
        facilities.add(new Fasilitas("123456","Toilet","ZONK", 300000, 3));

        //seeMore configurations
        seeMore = v.findViewById(R.id.seeMoreThumb_SewaanPengelola);
        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityPengelola ap = (ActivityPengelola) getActivity();
                ap.goToGallerySewaan();
            }
        });

        //RecyclerView things
        rv.setLayoutManager(new LinearLayoutManager(container.getContext()));
        rv.setAdapter(new rvFasilitasPengelola(facilities));

        return v;
    }

}
