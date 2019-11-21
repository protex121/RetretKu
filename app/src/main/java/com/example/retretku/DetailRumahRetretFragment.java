package com.example.retretku;

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

import com.example.retretku.object.Retret;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import es.dmoral.toasty.Toasty;

public class DetailRumahRetretFragment extends Fragment {

    TextView txtnama,txtalamat;
    Button btnnext;
    private FirebaseAuth mAuth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detailrumahretretfragment_layout, container,false);
        txtnama = v.findViewById(R.id.txtnama);
        txtalamat = v.findViewById(R.id.txtalamat);
        btnnext = v.findViewById(R.id.btnnext);

        Bundle b = getArguments();
        b.getString("nama");
        txtnama.setText(b.getString("nama"));
        txtalamat.setText(b.getString("alamat"));

        mAuth = FirebaseAuth.getInstance();

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = mAuth.getCurrentUser();

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference myRef = db.getReference("Users").child(currentUser.getUid()).child("Retret");
                String id_retret = myRef.push().getKey();
                Retret r = new Retret(id_retret);
                myRef.push().setValue(r);

                Toasty.success(getContext(), "Success Book Rumah!", Toast.LENGTH_SHORT, true).show();

            }
        });

        return v;
    }




}
