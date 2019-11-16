package com.example.retretku.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.LoginActivity;
import com.example.retretku.MainActivity;

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
