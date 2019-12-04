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

import com.example.retretku.Adapter.RumahRetretAdapter;
import com.example.retretku.Interface.RumahRetretOnClickListener;
import com.example.retretku.Object.RumahRetret;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminRumahRetretFragment extends Fragment {
    RecyclerView rvRumahRetret;
    RumahRetretAdapter adapter;
    ArrayList<RumahRetret> list;
    TextView tvJumlah;

    //Firebase
    FirebaseDatabase mDat;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_rumah_retret_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvJumlah = view.findViewById(R.id.rumahRetretAdminJumlah);
        rvRumahRetret = view.findViewById(R.id.rvRumahRetretAdmin);
        list = new ArrayList<>();

        //Atur Firebase
        mDat = FirebaseDatabase.getInstance();
        mRef = mDat.getReference("RumahRetret");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    RumahRetret rumah = temp.getValue(RumahRetret.class);
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
        rvRumahRetret.setHasFixedSize(true);
        adapter = new RumahRetretAdapter(getContext(),list);
        rvRumahRetret.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRumahRetret.setAdapter(adapter);

        adapter.setRumahRetretOnClickListener(new RumahRetretOnClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Intent intent = new Intent(getContext(),AdminDetailRumahRetret.class);
                intent.putExtra("index",position);
                startActivityForResult(intent,1);
            }
        });
    }
}
