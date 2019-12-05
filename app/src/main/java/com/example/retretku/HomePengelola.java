package com.example.retretku;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retretku.Objects.RumahRetret;
import com.example.retretku.Objects.Transaksi;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class HomePengelola extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView nama;
    ImageView pp;
    RatingBar ratingbar;
    RecyclerView rv;
    ArrayList<Transaksi> htrans;

    FirebaseAuth mAuth;
    DatabaseReference dataLogged;


    public HomePengelola() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_pengelola, container, false);

        /*mAuth = FirebaseAuth.getInstance();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = rootRef.child("Users").child(mAuth.getUid());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("nama_user").getValue(String.class);
                String email = dataSnapshot.child("email_user").getValue(String.class);
                View hView =  nv.getHeaderView(0);
                TextView nav_user = hView.findViewById(R.id.nav_name);
                TextView nav_email = hView.findViewById(R.id.nav_email);
                nav_user.setText(name);
                nav_email.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        //Finding Components
        nama = v.findViewById(R.id.tProfileNama_HomePengelola);
//        pp = v.findViewById(R.id.ivProfilePicture_HomePengelola);
        ratingbar = v.findViewById(R.id.profileRating_HomePengelola);

        //Database
        mAuth = FirebaseAuth.getInstance();
//        dataLogged = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child(mAuth.getUid());
        dataLogged = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child("XwDWj8OdHUSlzgzcjrrMkNYv5MN2");// HARUS DIUBAH
        dataLogged.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nama.setText(dataSnapshot.child("rumah_nama").getValue(String.class));
//                pp.setImageResource(dataSnapshot.child);
                ratingbar.setRating((float)dataSnapshot.child("rumah_rating").getValue(Integer.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //Variable declarations
        htrans = new ArrayList<>();
        htrans.add(new Transaksi("ID000002",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,0));
        htrans.add(new Transaksi("ID000003",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,1));
        htrans.add(new Transaksi("ID000004",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,2));
        htrans.add(new Transaksi("ID000005",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,3));

        //RecyclerView settings
        rv = v.findViewById(R.id.rvOverview_HomePengelola);
        rv.setLayoutManager(new LinearLayoutManager(container.getContext()));
        rv.setAdapter(new rvHTrans(htrans, this.getContext(), new OnHTRANSClickListener() {
            @Override
            public void onClick(View view, int pos) {
                ActivityPengelola ap = (ActivityPengelola) getActivity();
                ap.goToDetailTransaksi(htrans.get(pos).getId_trans());
            }
        }));

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
