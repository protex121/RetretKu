package com.example.retretku.Holder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.R;

public class RumahRetretHolder extends RecyclerView.ViewHolder {

    public TextView tv_txtnamarumah;
    public ImageView iv_gambarrumah;
    public Button btn_detail;

    public RumahRetretHolder(@NonNull View itemView) {
        super(itemView);
        tv_txtnamarumah = itemView.findViewById(R.id.tv_txtnamarumah);
        iv_gambarrumah = itemView.findViewById(R.id.iv_gambarrumah);
        btn_detail = itemView.findViewById(R.id.btn_detail);
    }
}
