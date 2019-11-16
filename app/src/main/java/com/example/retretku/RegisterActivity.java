package com.example.retretku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retretku.object.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    Button btnsignup;
    EditText txtemail,txpassword,txtnama,txttelp;

    private FirebaseAuth mAuth;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnsignup = findViewById(R.id.btnsignup);
        txtemail = findViewById(R.id.txtemail);
        txpassword = findViewById(R.id.txtpass);
        txtnama = findViewById(R.id.nav_name);
        txttelp = findViewById(R.id.txtnotelp);


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
                pDialog.setMessage("Memuat");
                pDialog.show();

                mAuth.createUserWithEmailAndPassword(email, pass).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){

                                    String nama = txtnama.getText().toString();
                                    String no = txttelp.getText().toString();
                                    String email = txtemail.getText().toString();
                                    String password = txpassword.getText().toString();
                                    String id = task.getResult().getUser().getUid();
                                    User u = new User(id, password,nama,no,1,email);

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                                    // data disimpan ke users-->uid-->datanya
                                    //nanti password harus di hash
                                    DatabaseReference myRef = database.getReference("Users").child(u.getId_user());

                                    myRef.setValue(u);

                                    pDialog.dismiss();
                                    Toast.makeText(RegisterActivity.this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show();

                                }
                                else{
                                    Toast.makeText(RegisterActivity.this, "Gagal Mendaftar", Toast.LENGTH_SHORT).show();
                                    pDialog.dismiss();
                                }
                            }
                        });
            }
        });/*</btnsignup onlclick>*/
    }

    public void signin(View v){
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }


}
