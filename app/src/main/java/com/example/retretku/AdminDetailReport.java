package com.example.retretku;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.Object.Report;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminDetailReport extends AppCompatActivity {
    TextView tvUsername, tvDate,tvText;
    Button btnDelete;
    ArrayList<Report> list;
    ArrayList<String> id;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_detail_report);

        list = new ArrayList<>();
        id = new ArrayList<>();
        index = -1;
        Intent intent = getIntent();
        if(intent.hasExtra("index"))index = intent.getIntExtra("index",-1);

        tvUsername = findViewById(R.id.detailReportUsername);
        tvText = findViewById(R.id.detailReportText);
        tvDate = findViewById(R.id.detailReportDate);
        btnDelete = findViewById(R.id.detailReportDelete);

        //Firebase
        FirebaseDatabase mDat = FirebaseDatabase.getInstance();
        final DatabaseReference mRef = mDat.getReference("Report");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                id.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    Report report = temp.getValue(Report.class);
                    list.add(report);
                    id.add(temp.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        tvUsername.setText(list.get(index).getReportBy());
        tvDate.setText(list.get(index).getDate());
        tvText.setText(list.get(index).getReportText());
        if(list.get(index).getStatus()==0){
            btnDelete.setText("Deleted");
            btnDelete.setEnabled(false);
        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list.get(index).getStatus()==1){
                    DatabaseReference ganti = mRef.child(id.get(index)).child("status");
                    ganti.setValue(0);
                    btnDelete.setText("Deleted");
                    btnDelete.setEnabled(false);
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //untuk menampilkan panah back di atas kiri
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
