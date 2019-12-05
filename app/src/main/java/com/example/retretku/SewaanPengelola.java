package com.example.retretku;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.retretku.Object.Fasilitas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SewaanPengelola extends Fragment {

    TextView namaSewaan, deskripsiSewaan ,seeMore;
    ArrayList<com.example.retretku.Object.Fasilitas> facilities;
    Button bUbah;
    RecyclerView rv;

    FirebaseAuth mAuth;
    DatabaseReference dataLogged;

    public SewaanPengelola() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sewaan_pengelola, container, false);

        //Component finding
        namaSewaan = v.findViewById(R.id.tNamaSewaan_SewaanPengelola);
        deskripsiSewaan = v.findViewById(R.id.tDeskripsiSewaan_SewaanPengelola);
        rv = v.findViewById(R.id.rvFasilitas_SewaanPengelola);
        bUbah = v.findViewById(R.id.bTambahFas_SewaanPengelola);

        //Declare facilities
        facilities = new ArrayList<>();

        //Fillin up the database
        mAuth = FirebaseAuth.getInstance();
        dataLogged = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child("XwDWj8OdHUSlzgzcjrrMkNYv5MN2");
//        dataLogged = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child(mAuth.getUid());
        dataLogged.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Ngisi ArrayList e rv
                /*for (DataSnapshot d : dataSnapshot.getChildren() ) {
                    Fasilitas temp = d.getValue(Fasilitas.class);
                    facilities.add(temp);
                }*/
                namaSewaan.setText(dataSnapshot.child("rumah_nama").getValue(String.class));
                deskripsiSewaan.setText(dataSnapshot.child("rumah_deskripsi").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //seeMore configurations
        seeMore = v.findViewById(R.id.seeMoreThumb_SewaanPengelola);
        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityPengelola ap = (ActivityPengelola) getActivity();
                ap.goToGallerySewaan();
            }
        });

        //bUbah
        bUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityPengelola ap = (ActivityPengelola) getActivity();
                ap.goToUbahFasilitas();
            }
        });

        //RecyclerView things
        rv.setLayoutManager(new LinearLayoutManager(container.getContext()));
        rv.setAdapter(new rvFasilitasPengelola(facilities));

        return v;
    }

}
