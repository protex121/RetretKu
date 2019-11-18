package com.example.retretku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityPengelola extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengelola);
    }

    public void toHapus(View view) {
        Intent i = new Intent(this, HapusRumahRetretPengelola.class);
        startActivity(i);
    }
}
