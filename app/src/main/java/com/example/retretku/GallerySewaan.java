package com.example.retretku;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retretku.Objects.RumahRetret;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class GallerySewaan extends AppCompatActivity {
    static int PICK_IMAGE_FROM_GALLERY = 1;
    Button addPic;
    RecyclerView rv;
    RumahRetret rr;
    FirebaseAuth mAuth;
    ArrayList<Uri> list_uri = new ArrayList<Uri>();
    rvGallerySewaanAdapter tmp;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_sewaan);

        addPic = findViewById(R.id.bAddPic_GallerySewaan);
        addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"pilih gambar"),1);
            }
        });

        mAuth = FirebaseAuth.getInstance();

        rv = findViewById(R.id.rvGallery_GallerySewaan);
        rv.setLayoutManager(new GridLayoutManager(this,2));

        rr = new RumahRetret(R.drawable.person, "Jonny", "123123", "081645");
        rr.getImages().add(R.drawable.cateone);
        rr.getImages().add(R.drawable.catetwo);
        rr.getImages().add(R.drawable.catethree);
        tmp = new rvGallerySewaanAdapter(rr);
        rv.setAdapter(tmp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if(requestCode == 1 && resultCode == RESULT_OK){
            Uri selectedImage = data.getData();
            //iv_gambar.setImageURI(selectedImage);
            upload(selectedImage);
        }
    }

    //method untuk upload gambar
    public void upload(final Uri selectedImage){
        final Uri file  = selectedImage;
        StorageReference ref = mStorageRef.child("images/"+mAuth.getCurrentUser().getUid()+list_uri.size()+".jpg");
        ref.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                list_uri.add(file);
                tmp.notifyDataSetChanged();
            }
        });
    }

    public void goToActivityPengelola(View view) {
        Intent i = new Intent(this, ActivityPengelola.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, ActivityPengelola.class);
        startActivity(i);
        finish();
    }
}
