package com.example.retretku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.object.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {

    EditText txtemail,password;
    private FirebaseAuth mAuth;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        txtemail = findViewById(R.id.txtemail);
        password = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();
    }

    public void Login(View v){
        String email = txtemail.getText().toString();
        String pass = password.getText().toString();

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Memuat");
        pDialog.show();

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    String id = task.getResult().getUser().getUid();
                    DatabaseReference myRef = database.getReference("Users").child(id);

                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            User u = dataSnapshot.getValue(User.class);
                            if(u.getStatus() == 0){
                                //0 itu user
                                pDialog.dismiss();
                                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(i);
                                Toasty.success(getApplicationContext(),"Berhasil Login",Toast.LENGTH_SHORT).show();
                            }
                            else if(u.getStatus() == 1){
                                //1 itu admin
                                pDialog.dismiss();
                                Toasty.info(getApplicationContext(),"Admin",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                else{
                    Toasty.error(LoginActivity.this, "Email/Password Anda salah!", Toast.LENGTH_SHORT).show();
                    pDialog.dismiss();
                }

            }
        });
    }

    public void signup(View v){
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //if(currentUser != null){
            //Intent i = new Intent(getApplicationContext(), HomeActivity.class);
            //startActivity(i);
        //}
        //updateUI(currentUser);
    }


}
