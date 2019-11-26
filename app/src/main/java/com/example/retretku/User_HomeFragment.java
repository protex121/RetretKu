package com.example.retretku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Holder.RumahRetretHolder;
import com.example.retretku.object.RumahRetret;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User_HomeFragment extends Fragment {

    RecyclerView rv_rumahretret;
    FirebaseRecyclerOptions<RumahRetret> options;
    FirebaseRecyclerAdapter<RumahRetret, RumahRetretHolder> adapter;
    DatabaseReference myRef;
    private ProgressDialog pDialog;

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.user_homefragment_layout, container,false);

        myRef = FirebaseDatabase.getInstance().getReference().child("RumahRetret");
        myRef.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<RumahRetret>().setQuery(myRef,RumahRetret.class).build();

        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Sabar ya");
        pDialog.show();
        adapter = new FirebaseRecyclerAdapter<RumahRetret, RumahRetretHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull RumahRetretHolder holder, int position, @NonNull final RumahRetret model) {
                holder.tv_txtnamarumah.setText(model.getRumah_nama());
                holder.iv_gambarrumah.setImageResource(R.drawable.cateone);
                holder.btn_detail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lihat_detail_rumah(model);
                    }
                });
            }

            @NonNull
            @Override
            public RumahRetretHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rumahretret,parent,false);
                return new RumahRetretHolder(view);
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
                if (pDialog != null) {
                    pDialog.dismiss();
                }
            }

        };

        rv_rumahretret = v.findViewById(R.id.rv_rumahretret);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv_rumahretret.setLayoutManager(manager);
        rv_rumahretret.setHasFixedSize(true);
        rv_rumahretret.setAdapter(adapter);

        return v;
    }

    private void lihat_detail_rumah(RumahRetret r){
        //method untuk pindah
        Intent i = new Intent(getContext(),DetailTempatRetretActivity.class);
        startActivity(i);
    }






}
