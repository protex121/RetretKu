package com.example.retretku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class login extends AppCompatActivity {

    EditText txtemail,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login);

        txtemail = findViewById(R.id.txtemail);
        password = findViewById(R.id.password);

    }

    public void klik(View v){

        if(txtemail.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Intent i = new Intent(this,admin.class);
            startActivity(i);
        }
        else if(txtemail.getText().toString().equals("a") && password.getText().toString().equals("a")){
            Intent i = new Intent(this,katering.class);
            startActivity(i);
        }
        else{
            Intent i = new Intent(this, home.class);
            startActivity(i);
        }


    }

}
