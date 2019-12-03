package com.example.retretku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityEditProfilePengelola extends AppCompatActivity {
    EditText nama, password, alamat, nomor, kapasitas, deskripsi;

    DatabaseReference user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_pengelola);

        //Finding them views
        nama = findViewById(R.id.eNama_EditProfilePengelola);
        password = findViewById(R.id.ePassword_EditProfilePengelola);
        alamat = findViewById(R.id.eAlamat_EditProfilePengelola);
        nomor = findViewById(R.id.eNomor_EditProfilePengelola);
        kapasitas = findViewById(R.id.eKapasitas_EditProfilePengelola);
        deskripsi = findViewById(R.id.eDeskripsi_EditProfilePengelola);

        //Users
        user = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    public void toActivityPengelola(View view) {
        Intent i = new Intent(this, ActivityPengelola.class);
        startActivity(i);
        finish();
    }
}
