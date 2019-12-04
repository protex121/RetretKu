package com.example.retretku;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.Object.Rating;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailTempatRetretActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    TextView tv_nama,tv_alamat,tv_deskripsi;
    Button btn_book;
    RatingBar rb_rating;


    String id_rumah;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat_retret);

        id_rumah = getIntent().getStringExtra("id");
        rb_rating = findViewById(R.id.ratingBar);

        tv_nama = findViewById(R.id.tv_nama);
        tv_alamat = findViewById(R.id.tv_alamat);
        tv_deskripsi = findViewById(R.id.tv_deskripsi);

        //ini dilempar dari fragment User_homefragment
        tv_nama.setText(getIntent().getStringExtra("nama"));
        tv_deskripsi.setText(getIntent().getStringExtra("deskripsi"));
        tv_alamat.setText(getIntent().getStringExtra("alamat"));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);

        mAuth = FirebaseAuth.getInstance();

        btn_book = findViewById(R.id.btnBook);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pesan rumahnya belum
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("RumahRetret").child(id_rumah).child("Rating");

                //String id_retret = myRef.push().getKey();
                //Rating rating = new Rating(id_retret, mAuth.getUid(),rb_rating.getRating());
                //myRef.push().setValue(rating);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ArrayList<Rating> arrrating = new ArrayList<>();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Rating r = snapshot.getValue(Rating.class);
                            arrrating.add(r);
                        }

                        float total = 0;
                        for (int i = 0; i < arrrating.size(); i++) {
                            total += arrrating.get(i).getRating();
                        }

                        float hasil = total/arrrating.size();
                        System.out.println("=====");
                        System.out.println(hasil);
                        System.out.println("=====");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(-7.688811,112.651379);
        mMap.addMarker(new MarkerOptions().position(latLng).title("BDI"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

        LatLng latLng2 = new LatLng(-7.291306,112.7566403);
        mMap.addMarker(new MarkerOptions().position(latLng2).title("STTS"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

        PolylineOptions line = new PolylineOptions();
        line.color(Color.RED);
        line.width(5f);

        String url = getURL(latLng, latLng2);

        //String result = URL.

        //mMap.addPolyline(line);
    }

    private String getURL(LatLng sumber,LatLng tujuan){
        String origin = "origin=" + sumber.latitude + "," + tujuan.longitude;
        String dest = "destination=" + tujuan.latitude + "," + tujuan.longitude;
        String sensor = "sensor=false";
        String params = "$origin&$dest&$sensor";
        return "https://maps.googleapis.com/maps/api/directions/json?$params";
    }

    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((int) (((double) lat / 1E5) * 1E6),
                    (int) (((double) lng / 1E5) * 1E6));
            poly.add(p);
        }

        return poly;
    }


}
