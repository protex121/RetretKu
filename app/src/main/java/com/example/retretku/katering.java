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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class katering extends AppCompatActivity {
    Fragment fr = new home_katering_fragment();
    BottomNavigationView bnv;
    ImageView ImgSideMenu;

    ArrayList<katering_class> list_katering = new ArrayList<katering_class>();
    ArrayList<paket_class> list_paket_makanan = new ArrayList<paket_class>();
    ArrayList<paket_class> list_paket_snack = new ArrayList<paket_class>();
    ArrayList<menu_class> list_menu = new ArrayList<menu_class>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        list_katering.add(new katering_class("a@b.c","a","AAA","FOOD","081235250435"));
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_katering);

        ImgSideMenu = findViewById(R.id.imgsidemenu2);
        bnv = findViewById(R.id.bottomNavigationView);

        ImgSideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bnv.setOnNavigationItemSelectedListener(bnvListener);
        openFragment(fr);
    }

    public void update(ArrayList<katering_class> a, ArrayList<paket_class> b, ArrayList<paket_class> d, ArrayList<menu_class> c){
        list_katering = a;
        list_paket_makanan = b;
        list_menu = c;
        list_paket_snack = d;
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
