package com.example.retretku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.Object.User;
import com.example.retretku.Object.RumahRetret;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
        setContentView(R.layout.activity_login);

        txtemail = findViewById(R.id.txtemail);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
    }

    //method untuk login
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

                    final FirebaseDatabase database = FirebaseDatabase.getInstance();
                    String id = task.getResult().getUser().getUid(); //ini artinya aku ngambil ID user yang sedang login, kembaliannya adalah ID yang gabisa dibaca itu

                    //lihat data dari user dulu
                    DatabaseReference myRef = database.getReference("Users").child(id); //ini artinya aku ngambil dari Database yang ke user trus berdasarkan ID user uang sedang login
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.getValue(User.class) != null){
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
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    //lihat data dari rumah retret
                    myRef = database.getReference("RumahRetret").child(id);
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.getValue(RumahRetret.class) != null){
                                pDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "login as rumah retret", Toast.LENGTH_SHORT).show();
                                //your code down here bobby
                                Intent i = new Intent(getApplicationContext(), ActivityPengelola.class);
                                startActivity(i);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else{
                    Toasty.error(LoginActivity.this, "Email / Password Anda salah!", Toast.LENGTH_SHORT).show();
                    pDialog.dismiss();
                }

            }
        });

    }

    //pindah ke activity daftar user
    public void signup(View v){
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        /*FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUser.getUid()).child("status");
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.getValue(Integer.class) == 0){
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "admin", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }*/
    }


}
