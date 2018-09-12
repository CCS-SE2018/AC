package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class manageClothes extends AppCompatActivity {

    private Button button;
    private ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_clothes);

        imageview = (ImageView) findViewById(R.id.add_clothes);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manageClothes.this, AddClothes.class);
                startActivity(intent);
            }
        });

        imageview = (ImageView) findViewById(R.id.edit_clothes);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manageClothes.this, EditClothes.class);
                startActivity(intent);
            }
        });

        imageview = (ImageView) findViewById(R.id.delete_clothes);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manageClothes.this, DeleteClothes.class);
                startActivity(intent);
            }
        });

        imageview = (ImageView) findViewById(R.id.view_clothes);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manageClothes.this, ViewClothes.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(manageClothes.this, MainActivity.class);
                    startActivity(intent);
                }
        });
    }

}
