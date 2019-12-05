package com.example.retretku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class AdminDetailKatering extends AppCompatActivity {
    TextView tvNama, tvAlamat, tvTelepon;
    Button btnBan;
    Spinner spinPaket;
    ListView lvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_detail_katering);
    }
}
