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

import com.example.retretku.Adapter.UserAdapter;
import com.example.retretku.Interface.UserOnClickListener;
import com.example.retretku.Object.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminUserFragment extends Fragment {
    ArrayList<User> list;
    RecyclerView rvUser;
    UserAdapter adapter;
    TextView tvJumlah;

    //Firebase
    FirebaseDatabase mDat;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_user_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUser = view.findViewById(R.id.rvUserAdmin);
        tvJumlah = view.findViewById(R.id.userAdminJumlah);
        list = new ArrayList<>();

        //Atur Firebase
        mDat = FirebaseDatabase.getInstance();
        mRef = mDat.getReference("Users");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    User user = temp.getValue(User.class);
                    list.add(user);
                }
                showAdapter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        showAdapter();
    }

    public void showAdapter(){
        rvUser.setHasFixedSize(true);
        rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UserAdapter(getContext(),list);
        rvUser.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tvJumlah.setText("Jumlah user : " + list.size());

        adapter.setUserOnClickListener(new UserOnClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Intent intent = new Intent(getContext(), AdminDetailUser.class);
                intent.putExtra("index",position);
                startActivityForResult(intent,1);
            }
        });
    }
}
