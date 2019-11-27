package com.example.retretku;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SewaanPengelola extends Fragment {

    TextView seeMore;

    public SewaanPengelola() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sewaan_pengelola, container, false);
        seeMore = v.findViewById(R.id.seeMoreThumb_SewaanPengelola);
        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityPengelola ap = (ActivityPengelola) getActivity();
                ap.goToGallerySewaan();
            }
        });
        return v;
    }

}
