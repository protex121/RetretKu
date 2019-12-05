package com.example.retretku;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.example.retretku.Objects.RumahRetret;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GallerySewaan extends AppCompatActivity {
    static int PICK_IMAGE_FROM_GALLERY = 1;
    Button addPic;
    RecyclerView rv;
    RumahRetret rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_sewaan);

        addPic = findViewById(R.id.bAddPic_GallerySewaan);
        addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), PICK_IMAGE_FROM_GALLERY);
            }
        });

        rv = findViewById(R.id.rvGallery_GallerySewaan);
        rv.setLayoutManager(new GridLayoutManager(this,2));

        rr = new RumahRetret(R.drawable.person, "Jonny", "123123", "081645");
        rr.getImages().add(R.drawable.cateone);
        rr.getImages().add(R.drawable.catetwo);
        rr.getImages().add(R.drawable.catethree);
        rv.setAdapter(new rvGallerySewaanAdapter(rr));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if(requestCode == PICK_IMAGE_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
