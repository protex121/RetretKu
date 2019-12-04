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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    DatabaseReference dbReff;

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
        dbReff = FirebaseDatabase.getInstance().getReference().child("katering");

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

        dbReff = FirebaseDatabase.getInstance().getReference().child("katering");
        for(int i=0;i<list_katering.size();i++){
            dbReff.child(list_katering.get(i).getNama_katering()).setValue(list_katering.get(i));
        }

        dbReff = FirebaseDatabase.getInstance().getReference().child("menu");
        for(int i=0;i<list_menu.size();i++){
            dbReff.child(list_menu.get(i).getId()).setValue(list_menu.get(i));
        }

        dbReff = FirebaseDatabase.getInstance().getReference().child("paket_makanan");
        for(int i=0;i<list_paket_makanan.size();i++){
            dbReff.child(list_paket_makanan.get(i).getId()).setValue(list_paket_makanan.get(i));
        }

        dbReff = FirebaseDatabase.getInstance().getReference().child("paket_snack");
        for(int i=0;i<list_paket_snack.size();i++){
            dbReff.child(list_paket_snack.get(i).getId()).setValue(list_paket_snack.get(i));
        }
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
