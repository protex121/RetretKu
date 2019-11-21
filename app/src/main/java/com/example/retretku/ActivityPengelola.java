package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityPengelola extends AppCompatActivity implements HomePengelola.OnFragmentInteractionListener{
    //Variable Declarations
    BottomNavigationView nav;
    ImageView ivIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengelola);

        //ImageView in Top Bar
        ivIndicator = findViewById(R.id.lFragment_HomePengelola);

        //Navbar in ActivityPengelola
        nav = findViewById(R.id.navbar_HomePengelola);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.o_home_ActivityPengelola) {
                    loadFragment(new HomePengelola());
                    ivIndicator.setImageResource(R.drawable.ap_home_white);
                } else if (menuItem.getItemId() == R.id.o_sewaan_ActivityPengelola) {
                    loadFragment(new SewaanPengelola());
                    ivIndicator.setImageResource(R.drawable.ap_list_white);
                } else if (menuItem.getItemId() == R.id.o_profile_ActivityPengelola) {
                    loadFragment(new ProfilePengelola());
                    ivIndicator.setImageResource(R.drawable.ap_profile_white);
                }
                return true;
            }
        });

        //Default HomePengelola on default
        loadFragment(new HomePengelola());
    }

    public void loadFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer_HomePengelola, f);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
