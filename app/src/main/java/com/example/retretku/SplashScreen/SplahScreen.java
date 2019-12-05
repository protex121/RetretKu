package com.example.retretku.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.LoginActivity;

public class SplahScreen extends AppCompatActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        },1000);

    }

}
