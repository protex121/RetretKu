package com.example.retretku;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.Object.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminDetailUser extends AppCompatActivity {
    TextView tvEmail, tvNama, tvAlamat, tvTelepon;
    Button btnBan;
    ArrayList<User> list;
    ArrayList<String> id;
    int index;
//    String id;

    //Firebase
    FirebaseDatabase mDat;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_detail_user);

        list = new ArrayList<>();
        id = new ArrayList<>();
        tvEmail = findViewById(R.id.detailUserEmail);
        tvAlamat = findViewById(R.id.detailUserAlamat);
        tvTelepon = findViewById(R.id.detailUserTelepon);
        tvNama = findViewById(R.id.detailUserNama);
        btnBan = findViewById(R.id.detailUserBan);
        Intent intent = getIntent();
        if(intent.hasExtra("index"))index = intent.getIntExtra("index",-1);

        showFirebase();

        tvNama.setText(list.get(index).getNama_user());
        tvEmail.setText(list.get(index).getEmail_user());
        tvTelepon.setText(list.get(index).getTelp_user());
//        tvAlamat.setText(list.get(index).getAlamat_user());

        btnBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list.get(index).getStatus()==1){
                    DatabaseReference ganti = mRef.child("Users").child(id.get(index)).child("status");
                    ganti.setValue(0);
                }
                else if(list.get(index).getStatus()==0){
                    DatabaseReference ganti = mRef.child("Users").child(id.get(index)).child("status");
                    ganti.setValue(1);
                }
//                showFirebase();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showFirebase(){
        //Atur Firebase
        mDat = FirebaseDatabase.getInstance();
        mRef = mDat.getReference("Users");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                id.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    User user = temp.getValue(User.class);
                    list.add(user);
                    id.add(temp.getKey());
                }
//                btnBan.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if(list.get(index).getStatus()==1){
//                            DatabaseReference ganti = mRef.child("Users").child(id.get(index)).child("status");
//                            ganti.setValue(0);
//                        }
//                        else if(list.get(index).getStatus()==0){
//                            DatabaseReference ganti = mRef.child("Users").child(id.get(index)).child("status");
//                            ganti.setValue(1);
//                        }
//                    }
//                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
