package com.example.retretku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {

    TextView tvSweet, tvSweetSub, tvCate, tvRare, tvItemOne, tvItemPriceOne,tvItemTwo, tvItemPriceTwo, tvItemThree, tvItemPriceThree;
    Animation fromtopbottom, fromtopbottomtwo, fromtopbottomthree;
    LinearLayout itemOne, itemTwo, itemThree;
    HorizontalScrollView categoryItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_home);

        fromtopbottom = AnimationUtils.loadAnimation(this, R.anim.fromtopbottom);
        fromtopbottomtwo = AnimationUtils.loadAnimation(this, R.anim.fromtopbottomtwo);
        fromtopbottomthree = AnimationUtils.loadAnimation(this, R.anim.fromtopbottomthree);

        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        itemOne = (LinearLayout) findViewById(R.id.itemOne);
        itemTwo = (LinearLayout) findViewById(R.id.itemTwo);
        itemThree = (LinearLayout) findViewById(R.id.itemThree);

        categoryItem = (HorizontalScrollView) findViewById(R.id.feed);


        tvSweet = (TextView) findViewById(R.id.txtjudul);
        tvSweetSub = (TextView) findViewById(R.id.txtsubjudul);
        tvCate = (TextView) findViewById(R.id.txtfeed);

        tvRare = (TextView) findViewById(R.id.txtpopular);
        tvItemOne = (TextView) findViewById(R.id.tvItemOne);
        tvItemPriceOne = (TextView) findViewById(R.id.tvItemPriceOne);

        tvItemTwo = (TextView) findViewById(R.id.tvItemTwo);
        tvItemPriceTwo = (TextView) findViewById(R.id.tvItemPriceTwo);

        tvItemThree = (TextView) findViewById(R.id.tvItemThree);
        tvItemPriceThree = (TextView) findViewById(R.id.tvItemPriceThree);

        tvSweet.setTypeface(MMedium);
        tvSweetSub.setTypeface(MLight);
        tvCate.setTypeface(MMedium);

        tvRare.setTypeface(MMedium);
        tvItemOne.setTypeface(MRegular);
        tvItemPriceOne.setTypeface(MLight);

        tvItemTwo.setTypeface(MRegular);
        tvItemPriceTwo.setTypeface(MLight);

        tvItemThree.setTypeface(MRegular);
        tvItemPriceThree.setTypeface(MLight);


        tvSweet.startAnimation(fromtopbottom);
        tvSweetSub.startAnimation(fromtopbottom);

        tvCate.startAnimation(fromtopbottom);
        tvRare.startAnimation(fromtopbottom);

        categoryItem.startAnimation(fromtopbottom);

        itemOne.startAnimation(fromtopbottom);
        itemTwo.startAnimation(fromtopbottomtwo);
        itemThree.startAnimation(fromtopbottomthree);

    }

    public void pesan(View v){
        Intent i = new Intent(getApplicationContext(), detail_tempat_retret.class);
        startActivity(i);
    }


}
