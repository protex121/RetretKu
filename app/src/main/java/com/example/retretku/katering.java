package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class katering extends AppCompatActivity {
    Fragment fr = new home_katering_fragment();
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katering);

        bnv = findViewById(R.id.bottomNavigationView);
        bnv.setOnNavigationItemSelectedListener(bnvListener);
        openFragment(fr);
    }

    public void openFragment(Fragment frag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,frag);
        ft.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bnvListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch(menuItem.getItemId()){
                case R.id.menu_home:
                    fr = new home_katering_fragment();
                    break;
                case R.id.menu_add_menu:
                    fr = new add_menu_katering_fragment();
                    break;
                case R.id.menu_add_paket:
                    fr = new add_paket_katering_fragment();
                    break;
            }
            openFragment(fr);
            return true;
        }
    };
}
