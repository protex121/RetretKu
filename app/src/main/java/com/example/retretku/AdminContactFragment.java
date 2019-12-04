package com.example.retretku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.retretku.Object.Contact;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminContactFragment extends Fragment {
    RadioButton rbPembicara, rbTransportasi;
    EditText etNama, etTelepon;
    Button btnAdd;
    ListView lvContact;
    ArrayList<Contact> list;
    ArrayAdapter adapter;

    //Firebase
    FirebaseDatabase mDat;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_contact_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etNama = view.findViewById(R.id.contactNama);
        etTelepon = view.findViewById(R.id.contactTelepon);
        btnAdd = view.findViewById(R.id.contactAdd);
        lvContact = view.findViewById(R.id.lvContact);
        rbPembicara = view.findViewById(R.id.rbPembicara);
        rbTransportasi = view.findViewById(R.id.rbTransportasi);
        list = new ArrayList<>();
        adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,list);
        lvContact.setAdapter(adapter);

        mDat = FirebaseDatabase.getInstance();
        mRef = mDat.getReference("Contact");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    Contact contact = temp.getValue(Contact.class);
                    list.add(contact);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String telepon = etTelepon.getText().toString();
                String jenis = "";
                if(rbPembicara.isChecked())jenis = "Pembicara";
                else jenis = "Transportasi";
                Contact temp = new Contact(nama,jenis,telepon);
                mRef.push().setValue(temp);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
