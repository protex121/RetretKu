package com.example.retretku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailTransaksi extends AppCompatActivity {

    String id_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaksi);

        id_trans = getIntent().getStringExtra("id_trans");
    }
}
