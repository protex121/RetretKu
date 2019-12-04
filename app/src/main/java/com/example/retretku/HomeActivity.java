package com.example.retretku;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class HomeActivity extends AppCompatActivity {

    //firebase
    private FirebaseAuth mAuth;
    //nav drawer
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private NavigationView nv;

    private int k = 0;

    Fragment fragment = new UserProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //atur toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //drawer menu setting
        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true); //menyalakan hamburgermenu
        toggle.syncState();

        nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.nav_home){
                    Toast.makeText(HomeActivity.this, "home", Toast.LENGTH_SHORT).show();
                }
                //lanjukan nanti
                return false;
            }
        });

        //Atur Nav drawer berdasarkan data dari database
        mAuth = FirebaseAuth.getInstance();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = rootRef.child("Users").child(mAuth.getUid());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("nama_user").getValue(String.class);
                String email = dataSnapshot.child("email_user").getValue(String.class);
                View hView =  nv.getHeaderView(0);
                TextView nav_user = hView.findViewById(R.id.nav_name);
                TextView nav_email = hView.findViewById(R.id.nav_email);
                nav_user.setText(name);
                nav_email.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cetak_log();
        //buka fragment
        openFragment(fragment);
    }

    private void openFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_logout){
            mAuth.signOut();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        k++;
        if(k == 1) {
            Toasty.info(getApplicationContext(),"Back 1 kali lagi untuk menutup aplikasi", Toast.LENGTH_SHORT).show();
        } else {
            finishAndRemoveTask();
            System.exit(0);
        }
    }

    //untuk coba"
    private void cetak_log(){
        //coddingan dibawah ini untuk mendapatkan data dari user yang sedang login
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String id_user = currentUser.getUid(); //mendapatkan ID user yang sedang login

        DatabaseReference myRef = database.getReference("Users").child(id_user).child("daftar_retret");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Retret r = snapshot.getValue(Retret.class);
                    System.out.println("=======");
                    System.out.println(r.getId_retret());
                    System.out.println(r.getDeksripsi());
                    System.out.println("=======");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        //coddingan dibawah untuk mendapatkan data dari user lain
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");
        final ArrayList<String> id_user = new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    id_user.add(snapshot.getKey());
                }
                DatabaseReference tes = myRef.child(id_user.get(2)).child("status");
                tes.setValue(4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


}
