package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    ImageView img_more;
    Fragment fragment = new AdminUserFragment();
    BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.activity_dashboard);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        navbar = findViewById(R.id.AdminNavbar);
        navbar.setOnNavigationItemSelectedListener(bottomNavListener);
        openFragment(fragment);

        img_more = findViewById(R.id.imgMore_DashboardActivity);
        img_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop = new PopupMenu(getApplicationContext(),view);
                pop.inflate(R.menu.popup_dashboard);
                pop.show();
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.pda_registerRumahRetret){
                            fragment = new Admin_RegisterRumahRetretFragment();
                            openFragment(fragment);
                        } else if (menuItem.getItemId() == R.id.pda_logout) {
                            finish();
                        }

                        return true;
                    }
                });
            }
        });
    }

    public void logout(View v){
        finish();
    }

    private void openFragment(Fragment fr){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.AdminFrame,fr);
        ft.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.itemUser:
                    fragment = new AdminUserFragment();
                    break;
                case R.id.itemRumahRetret:
                    fragment = new AdminRumahRetretFragment();
                    break;
                case R.id.itemKatering:
                    fragment = new AdminKateringFragment();
                    break;
                case R.id.itemContact:
                    fragment = new AdminContactFragment();
                    break;
                case R.id.itemReport:
                    fragment = new AdminReportFragment();
                    break;
            }
            openFragment(fragment);
            return true;
        }
    };
}
