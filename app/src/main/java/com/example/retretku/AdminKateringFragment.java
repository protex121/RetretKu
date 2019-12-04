package com.example.retretku;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Adapter.KateringAdapter;
import com.example.retretku.Interface.KateringOnClickListener;
import com.example.retretku.Object.Katering;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminKateringFragment extends Fragment {
    RecyclerView rvKatering;
    KateringAdapter adapter;
    ArrayList<Katering> list;
    TextView tvJumlah;

    //Firebase
    FirebaseDatabase mDat;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_katering_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvJumlah = view.findViewById(R.id.kateringAdminJumlah);
        rvKatering = view.findViewById(R.id.rvKateringAdmin);
        list = new ArrayList<>();

        //Atur Firebase
        mDat = FirebaseDatabase.getInstance();
        mRef = mDat.getReference("Katering");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    Katering rumah = temp.getValue(Katering.class);
                    list.add(rumah);
                }
                showAdapter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void showAdapter(){
        rvKatering.setHasFixedSize(true);
        adapter = new KateringAdapter(getContext(),list);
        rvKatering.setLayoutManager(new LinearLayoutManager(getContext()));
        rvKatering.setAdapter(adapter);

        adapter.setKateringOnClickListener(new KateringOnClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Intent intent = new Intent(getContext(),AdminDetailKatering.class);
                intent.putExtra("index",position);
                startActivityForResult(intent,1);
            }
        });
    }
}
