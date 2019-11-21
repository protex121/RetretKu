package com.example.retretku;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailTempatRetretActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btn_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat_retret);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);

        btn_book = findViewById(R.id.btnBook);
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
    }
}
