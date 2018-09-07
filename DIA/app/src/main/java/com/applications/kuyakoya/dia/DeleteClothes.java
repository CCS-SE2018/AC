package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class DeleteClothes extends AppCompatActivity {

    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_clothes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageview = (ImageView) findViewById(R.id.iv_upper);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeleteClothes.this, upperClothes.class);
                startActivity(intent);
            }
        });
        imageview = (ImageView) findViewById(R.id.iv_lower);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeleteClothes.this, lowerClothes.class);
                startActivity(intent);
            }
        });
        imageview = (ImageView) findViewById(R.id.iv_foot);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeleteClothes.this, footwear.class);
                startActivity(intent);
            }
        });
    }

}
