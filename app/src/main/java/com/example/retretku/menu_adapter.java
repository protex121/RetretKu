package com.example.retretku;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class menu_adapter extends RecyclerView.Adapter<menu_adapter.menuViewHolder> {

    ArrayList<menu_class> list_menu;
    FirebaseAuth mAuth;

    @NonNull
    @Override
    public menu_adapter.menuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_menu,parent,false);
        menuViewHolder holder = new menuViewHolder(view);
        return holder;
    }

    public menu_adapter(ArrayList<menu_class> list_menu) {
        this.list_menu = list_menu;
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onBindViewHolder(@NonNull final menu_adapter.menuViewHolder holder, int position) {
        final menu_class tmp = list_menu.get(position);

        holder.txt_nama.setText(tmp.getNama());
        holder.txt_deskripsi.setText(tmp.getDeskripsi());

        //ini cara ambil gambar
        StorageReference gsReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://retretku.appspot.com/images/"+mAuth.getCurrentUser().getUid()+".jpg");
        gsReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(holder.imgView);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class menuViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nama, txt_deskripsi;
        ImageView imgView;

        public menuViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nama = itemView.findViewById(R.id.txt_nama_menu);
            txt_deskripsi = itemView.findViewById(R.id.txt_deskripsi);
            imgView = itemView.findViewById(R.id.imageView19);
        }
    }
}
