package com.example.retretku;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.Object.RumahRetret;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminDetailRumahRetret extends AppCompatActivity {
    TextView tvNama,tvAlamat,tvJumlah;
    Button btnBan;
    ListView lv;
    ArrayList<RumahRetret> list;
    ArrayList<String> id;
    ArrayAdapter adapter;
    int index = -1;

    //Firebase
    FirebaseDatabase mDat;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_detail_rumah_retret);

        tvNama = findViewById(R.id.detailRumahRetretNama);
        tvAlamat = findViewById(R.id.detailRumahRetretAlamat);
        tvJumlah = findViewById(R.id.detailRumahRetretJumlahOrang);
        btnBan = findViewById(R.id.detailRumahRetretBan);
        lv = findViewById(R.id.lvFasilitas);
        list = new ArrayList<>();
        id = new ArrayList<>();
        Intent intent = getIntent();
        if(intent.hasExtra("index"))index = intent.getIntExtra("index",-1);

        showFirebase();

        tvNama.setText(list.get(index).getRumah_nama());
        tvAlamat.setText("Alamat : " + list.get(index).getRumah_alamat());
        tvJumlah.setText("Jumlah Orang : " + list.get(index).getRumah_kapasitas());
        if(list.get(index).getRumah_status()==1)btnBan.setText("Disabled");
        else btnBan.setText("Enabled");

        //tampilkan fasilitas - fasilitas belum ada di firebase
//        ArrayList<String> fasilitas = list.get(index).getFasilitas();
//        adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,fasilitas);
//        lv.setAdapter(adapter);

        //btnBan dengan Firebase
//        btnBan.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if(list.get(index).getStatus()==1){
//                            DatabaseReference ganti = mRef.child("RumahRetret").child(id.get(index)).child("rumah_status");
//                            ganti.setValue(0);
//                        }
//                        else if(list.get(index).getStatus()==0){
//                            DatabaseReference ganti = mRef.child("RumahRetret").child(id.get(index)).child("rumah_status");
//                            ganti.setValue(1);
//                        }
//                    }
//                });

        //btnBan tanpa firebase
//        btnBan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(list.get(index).getRumah_status()==1){
//                    list.get(index).setRumah_status(0);
//                    btnBan.setText("Enabled");
//                }
//                else {
//                    list.get(index).setRumah_status(1);
//                    btnBan.setText("Disabled");
//                }
//            }
//        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //untuk menampilkan panah back di atas kiri
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showFirebase(){
        //Atur Firebase
        mDat = FirebaseDatabase.getInstance();
        mRef = mDat.getReference("RumahRetret");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                id.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    RumahRetret rumah = temp.getValue(RumahRetret.class);
                    list.add(rumah);
                    id.add(temp.getKey());
                }

//                btnBan.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if(list.get(index).getStatus()==1){
//                            DatabaseReference ganti = mRef.child("RumahRetret").child(id.get(index)).child("rumah_status");
//                            ganti.setValue(0);
//                        }
//                        else if(list.get(index).getStatus()==0){
//                            DatabaseReference ganti = mRef.child("RumahRetret").child(id.get(index)).child("rumah_status");
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
}
