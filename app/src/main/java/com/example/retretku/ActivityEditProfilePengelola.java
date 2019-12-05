package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retretku.Object.RumahRetret;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityEditProfilePengelola extends AppCompatActivity {
    EditText nama, password, alamat, nomor, kapasitas, deskripsi;
    Button save;

    //Ngambil datanya yg login
    String id_temp, email_temp;
    Double longitude, latitude;

    FirebaseAuth mAuth;
    DatabaseReference user;

    /*mAuth = FirebaseAuth.getInstance();
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
        });*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_pengelola);

        mAuth = FirebaseAuth.getInstance();

        //Finding them views
        nama = findViewById(R.id.eNama_EditProfilePengelola);
        password = findViewById(R.id.ePassword_EditProfilePengelola);
        alamat = findViewById(R.id.eAlamat_EditProfilePengelola);
        nomor = findViewById(R.id.eNomor_EditProfilePengelola);
        kapasitas = findViewById(R.id.eKapasitas_EditProfilePengelola);
        deskripsi = findViewById(R.id.eDeskripsi_EditProfilePengelola);
        save = findViewById(R.id.bSave_EditProfilePengelola);

        //Users
//        user = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child(mAuth.getUid());

        user = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child("XwDWj8OdHUSlzgzcjrrMkNYv5MN2");
        user.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                id_temp = dataSnapshot.child("rumah_id").getValue(String.class);
                email_temp = dataSnapshot.child("rumah_email").getValue(String.class);
                longitude = dataSnapshot.child("longitude").getValue(Double.class);
                latitude = dataSnapshot.child("latitude").getValue(Double.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                public RumahRetret(rumah_id, String rumah_nama, String rumah_email,
//              String rumah_pass, String rumah_alamat, String rumah_notelp, double longitude,double latitude, int kapasitas)

                RumahRetret rr = new RumahRetret(id_temp, nama.getText().toString(), email_temp, password.getText().toString(), alamat.getText().toString(), nomor.getText().toString(),longitude,latitude,Integer.parseInt(kapasitas.getText().toString()));

                user.setValue(rr);
            }
        });
    }

    public void toActivityPengelola(View view) {
        Intent i = new Intent(this, ActivityPengelola.class);
        startActivity(i);
        finish();
    }
}
