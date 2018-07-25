package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
            @Override

            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.login);
        button.setOnClickListener(new OnClickListener(){
            @Override

            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        imageview = (ImageView) findViewById(R.id.iv_ManageClothes);
        imageview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, manageClothes.class);
                startActivity(intent);
            }
        });

        imageview = (ImageView) findViewById(R.id.iv_MatchClothes);
        imageview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, matchOutfit.class);
                startActivity(intent);
            }
        });
    }
}
