package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    Button btnsignup;
    EditText txtemail,txpassword;

    private FirebaseAuth mAuth;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnsignup = findViewById(R.id.btnsignup);
        txtemail = findViewById(R.id.txtemail);
        txpassword = findViewById(R.id.txtpass);
        mAuth = FirebaseAuth.getInstance();

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = txtemail.getText().toString().trim();
                final String pass = txpassword.getText().toString().trim();

                if (email.isEmpty()) {
                    txtemail.setError("Email Belum Diisi");
                    txtemail.requestFocus();
                    return;
                }

                if (pass.isEmpty()) {
                    txpassword.setError("password harus diisi");
                    txpassword.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    txtemail.setError("Masukan Valid Email");
                    txtemail.requestFocus();
                    return;
                }

                pDialog = new ProgressDialog(RegisterActivity.this);
                pDialog.setMessage("Tunggu Sebentar");
                pDialog.show();

                mAuth.createUserWithEmailAndPassword(email, pass).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference myRef = database.getReference("User");
                                    myRef.setValue("Hello, World!");

                                    pDialog.dismiss();
                                    Toast.makeText(RegisterActivity.this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(RegisterActivity.this, "Gagal Mendaftar", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });/*</btnsignup onlclick>*/
    }


}
