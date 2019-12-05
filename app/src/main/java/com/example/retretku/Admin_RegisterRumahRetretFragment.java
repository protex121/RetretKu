package com.example.retretku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.retretku.Object.RumahRetret;
import com.example.retretku.Objects.Transaksi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

import es.dmoral.toasty.Toasty;

public class Admin_RegisterRumahRetretFragment extends Fragment {

    TextView txtemail,txtnama,txtpassword,txtalamat, txtnotelp;
    Button btnsubmit,btnsearch;
    private FirebaseAuth mAuth;
    private ProgressDialog pDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.admin_registerrumahretret_layout, container,false);
        txtemail = v.findViewById(R.id.txtemail);
        txtnama = v.findViewById(R.id.txtnama);
        txtpassword = v.findViewById(R.id.txtpassword);
        txtalamat = v.findViewById(R.id.txtalamat);
        txtnotelp = v.findViewById(R.id.tNotelp_AdminRegisterRumahRetret);
        btnsubmit = v.findViewById(R.id.btnsubmit);
        btnsearch = v.findViewById(R.id.button);

        mAuth = FirebaseAuth.getInstance();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = txtemail.getText().toString();
                final String nama = txtnama.getText().toString();
                final String pass = txtpassword.getText().toString();
                final String alamat = txtalamat.getText().toString();
                final String notelp = txtnotelp.getText().toString();

                pDialog = new ProgressDialog(getContext());
                pDialog.setMessage("Memuat");
                pDialog.show();

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            String id = task.getResult().getUser().getUid();
                            RumahRetret r = new RumahRetret(id,nama,email,pass,alamat,notelp,0,0);

                            ArrayList<Transaksi> htrans = new ArrayList<>();
                            htrans.add(new Transaksi("ID000002",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,0));
                            htrans.add(new Transaksi("ID000003",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,1));
                            htrans.add(new Transaksi("ID000004",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,2));
                            htrans.add(new Transaksi("ID000005",new Date(2019, 11, 10), new Date(2019, 11, 17),16000000,3));

                            r.setTransaksi(htrans);

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("RumahRetret").child(r.getRumah_id());
                            myRef.setValue(r);

                            pDialog.dismiss();
                            Toasty.success(getContext(), "Berhasil Mendaftarkan rumah retret", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toasty.error(getContext(),"Gagal mendaftarkan rumah retret",Toasty.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),MapsActivity.class);
                startActivity(i);
            }
        });




        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}
