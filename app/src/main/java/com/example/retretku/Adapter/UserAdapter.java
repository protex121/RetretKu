package com.example.retretku.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Interface.UserOnClickListener;
import com.example.retretku.R;
import com.example.retretku.Object.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context context;
    private ArrayList<User> list;
    private UserOnClickListener userOnClickListener;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    public void setUserOnClickListener(UserOnClickListener userOnClickListener) {
        this.userOnClickListener = userOnClickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_user,parent,false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User temp = list.get(position);
        holder.tvNama.setText(temp.getNama_user());
        if(temp.getStatus() == 1)holder.tvStatus.setText("Enabled");
        else holder.tvStatus.setText("Disabled");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvStatus;
        public UserViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvDetailUserNama);
            tvStatus = itemView.findViewById(R.id.tvDetailUserStatus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(userOnClickListener!=null){
                        userOnClickListener.OnClick(itemView, getAdapterPosition());
                    }
                }
            });
        }
    }
}
