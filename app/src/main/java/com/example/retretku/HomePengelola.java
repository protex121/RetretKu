package com.example.retretku;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.retretku.Objects.Transaksi;

import java.util.ArrayList;
import java.util.Date;

public class HomePengelola extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView nama, tipe, since;
    ImageView pp;
    RatingBar ratingbar;
    RecyclerView rv;
    ArrayList<Transaksi> htrans;


    public HomePengelola() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_pengelola, container, false);

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
