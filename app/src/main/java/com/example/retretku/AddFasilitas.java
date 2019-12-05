package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.retretku.Object.Fasilitas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddFasilitas extends AppCompatActivity {
    EditText name,harga,jumlah,deskripsi;
    Button tambah,edit,delete;
    RecyclerView rv;
    FirebaseAuth mAuth;
    DatabaseReference dataLogged;


    ArrayList<Fasilitas> fasilitas;

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
        setContentView(R.layout.activity_add_fasilitas);

        //Finding stuff
        name = findViewById(R.id.tNamaFas_AddFasilitas);
        harga = findViewById(R.id.tHargaFas_AddFasilitas);
        jumlah = findViewById(R.id.tJmlFas_AddFasilitas);
        deskripsi = findViewById(R.id.tDeskripsiFas_AddFasilitas);
        tambah = findViewById(R.id.bAdd_AddFasilitas);
        edit = findViewById(R.id.bUpdate_AddFasilitas);
        delete = findViewById(R.id.bDelete_AddFasilitas);

        fasilitas = new ArrayList<>();

        //RecyclerView
        rv = findViewById(R.id.rvFasilitas_AddFasilitas);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //Database Stuff
        mAuth = FirebaseAuth.getInstance();
        dataLogged = FirebaseDatabase.getInstance().getReference().child("XwDWj8OdHUSlzgzcjrrMkNYv5MN2");// HARUS DIUBAH
//        dataLogged = FirebaseDatabase.getInstance().getReference().child(mAuth.getUid());
        dataLogged.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Ngisi ArrayList e rv
                for (DataSnapshot d : dataSnapshot.getChildren() ) {
                    Fasilitas temp = d.getValue(Fasilitas.class);
                    fasilitas.add(temp);
                }
                rv.setAdapter(new rvFasilitasPengelola(fasilitas));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child(mAuth.getUid());
                DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child("RumahRetret").child("XwDWj8OdHUSlzgzcjrrMkNYv5MN2"); //HARUS DIUBAH
                fasilitas.add(new Fasilitas(name.getText().toString(),deskripsi.getText().toString(),Long.valueOf(harga.getText().toString()),Integer.parseInt(jumlah.getText().toString())));
                dr.child("fasilitas").setValue(fasilitas);
            }
        });
    }
}
