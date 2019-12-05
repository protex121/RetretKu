package com.example.retretku;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SearchView sv_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        sv_maps = findViewById(R.id.sv_location); //searchview
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);

        sv_maps.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                String location = sv_maps.getQuery().toString();
                List<Address> addressList = null;

                if(location != null || location.equals("")){
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try{
                        addressList = geocoder.getFromLocationName(location,1);
                        if(addressList!=null && addressList.size()>0){
                            Address address = addressList.get(0);
                            LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }



}
