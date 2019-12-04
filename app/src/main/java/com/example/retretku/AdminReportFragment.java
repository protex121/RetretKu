package com.example.retretku;

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

import com.example.retretku.Adapter.ReportAdapter;
import com.example.retretku.Interface.ReportOnClickListener;
import com.example.retretku.Object.Report;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminReportFragment extends Fragment {
    ArrayList<Report> list;
    RecyclerView rvReport;
    ReportAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_report_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvReport = view.findViewById(R.id.rvReport);
        list = new ArrayList<>();

        //Firebase
        FirebaseDatabase mDat = FirebaseDatabase.getInstance();
        DatabaseReference mRef = mDat.getReference("Report");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot temp : dataSnapshot.getChildren()){
                    Report report = temp.getValue(Report.class);
                    list.add(report);
                }
                showAdapter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void showAdapter(){
        rvReport.setHasFixedSize(true);
        adapter = new ReportAdapter(getContext(),list);
        rvReport.setLayoutManager(new LinearLayoutManager(getContext()));
        rvReport.setAdapter(adapter);

        adapter.setReportOnClickListener(new ReportOnClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Intent intent = new Intent(getContext(),AdminDetailReport.class);
                intent.putExtra("index",position);
                startActivityForResult(intent,1);
            }
        });
    }
}
