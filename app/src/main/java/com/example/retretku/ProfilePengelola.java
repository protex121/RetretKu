package com.example.retretku;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.retretku.Objects.Rating;
import com.example.retretku.Objects.RumahRetret;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePengelola extends Fragment {
    ImageView ivpp;
    TextView nama,alamat,notelp;
    TextView tRating;
    RatingBar rateBar;
    Button bEdit;
    RecyclerView rv;
    ArrayList<Rating> ratings;

    public ProfilePengelola() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_pengelola, container, false);

        //Filling in the components
        ivpp = v.findViewById(R.id.ivProfilePicture_HomePengelola);
        nama = v.findViewById(R.id.namaRumahRetret_ProfilePengelola);
        alamat = v.findViewById(R.id.alamatRumahRetret_ProfilePengelola);
        notelp = v.findViewById(R.id.notelpRumahRetret_ProfilePengelola);
        tRating = v.findViewById(R.id.tRating_ProfilePengelola);
        rateBar = v.findViewById(R.id.rating_ProfilePengelola);
        bEdit = v.findViewById(R.id.bEditProfile_ProfilePengelola);

        //bEdit onclick
        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityPengelola ap = (ActivityPengelola) getActivity();
                ap.goToEditProfile();
            }
        });

        //Filling in them ratings
        ratings = new ArrayList<>();
        ratings.add(new Rating(new RumahRetret(0,"Geoff","realg","111000"), 4));
        ratings.add(new Rating(new RumahRetret(0,"Reeves","realg","111000"), 3));
        ratings.add(new Rating(new RumahRetret(0,"Uhlan","realg","111000"), 2));
        ratings.add(new Rating(new RumahRetret(0,"Jeffrey","realg","111000"), 1));

        //RecyclerView declaration things
        rv = v.findViewById(R.id.rvRecentRatings_ProfilePengelola);
        rv.setLayoutManager(new LinearLayoutManager(container.getContext()));
        rv.setAdapter(new rvRatingAdapter(ratings));

        return v;
    }

}
