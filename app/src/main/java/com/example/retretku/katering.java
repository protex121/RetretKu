package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class katering extends AppCompatActivity {
    Fragment fr = new home_katering_fragment();
    BottomNavigationView bnv;
    ImageView ImgSideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_katering);

        ImgSideMenu = findViewById(R.id.imgsidemenu2);
        bnv = findViewById(R.id.bottomNavigationView);



        ImgSideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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