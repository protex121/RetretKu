package com.example.retretku.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Interface.ReportOnClickListener;
import com.example.retretku.R;
import com.example.retretku.Object.Report;

import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {
    private Context context;
    private ArrayList<Report> listReport;
    private ReportOnClickListener reportOnClickListener;

    public ReportAdapter(Context context, ArrayList<Report> listReport) {
        this.context = context;
        this.listReport = listReport;
    }

    public void setReportOnClickListener(ReportOnClickListener reportOnClickListener) {
        this.reportOnClickListener = reportOnClickListener;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_report,parent,false);
        ReportViewHolder holder = new ReportViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Report report = listReport.get(position);
        holder.tvBy.setText(report.getReportBy());
        holder.tvDate.setText(report.getDate());
        holder.tvText.setText(report.getReportText());
        if(report.getStatus()==1)holder.tvStatus.setText("Not Deleted");
        else holder.tvStatus.setText("Deleted");
    }

    @Override
    public int getItemCount() {
        return listReport.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView tvBy, tvText, tvStatus, tvDate;
        public ReportViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvBy = itemView.findViewById(R.id.tvReportBy);
            tvText = itemView.findViewById(R.id.tvReportText);
            tvDate = itemView.findViewById(R.id.tvDetailReportDate);
            tvStatus = itemView.findViewById(R.id.tvDetailReportStatus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(reportOnClickListener!=null){
                        reportOnClickListener.OnClick(itemView,getAdapterPosition());
                    }
                }
            });
        }
    }
}
