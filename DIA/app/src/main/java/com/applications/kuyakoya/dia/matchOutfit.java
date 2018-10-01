package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class matchOutfit extends AppCompatActivity{

    private Button match;
    ImageView imageView;
    ImageView imgView;
    ImageView imagesView;
    private ImageView collageImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_outfit);

//        collageImage =(ImageView)findViewById(R.id.combineView);

        match = (Button)findViewById(R.id.matchButton);
        match.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Bitmap top = BitmapFactory.decodeResource(getResources(),R.id.iv_upper);
                Bitmap bottom = BitmapFactory.decodeResource((getResources()), R.id.iv_lower);
                Bitmap footwear = BitmapFactory.decodeResource(getResources(),R.id.iv_foot);

                Bitmap merged = createSingleImageFromMultipleImages(top, bottom,footwear);
                collageImage.setImageBitmap(merged);

                match.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openMatchClothes();
                    }
                });
            }
        });

        imageView = (ImageView)findViewById(R.id.iv_upper);
        imageView.setTag(1);
        imageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if(imageView.getTag().equals(1)){
                    imageView.setImageResource(R.drawable.shirt_1);
                    imageView.setTag(2);
                }else if (imageView.getTag().equals(2)){
                    imageView.setImageResource(R.drawable.shirt_2);
                    imageView.setTag(3);
                }else{
                    imageView.setImageResource(R.drawable.shirt_3);
                    imageView.setTag(1);
                }
            }
        });

        imgView = (ImageView)findViewById(R.id.iv_lower);
        imgView.setTag(1);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if(imgView.getTag().equals(1)){
                    imgView.setImageResource(R.drawable.pants_1);
                    imgView.setTag(2);
                }else if (imgView.getTag().equals(2)){
                    imgView.setImageResource(R.drawable.pants_2);
                    imgView.setTag(3);
                }else{
                    imgView.setImageResource(R.drawable.pants_3);
                    imgView.setTag(1);
                }
            }
        });

        imagesView = (ImageView)findViewById(R.id.iv_foot);
        imagesView.setTag(1);
        imagesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if(imagesView.getTag().equals(1)){
                    imagesView.setImageResource(R.drawable.shoe_1);
                    imagesView.setTag(2);
                }else if (imagesView.getTag().equals(2)){
                    imagesView.setImageResource(R.drawable.shoe_2);
                    imagesView.setTag(3);
                }else{
                    imagesView.setImageResource(R.drawable.shoe_3);
                    imagesView.setTag(1);
                }
            }
        });
    }

    private Bitmap createSingleImageFromMultipleImages(Bitmap first, Bitmap second, Bitmap third){
        Bitmap result = Bitmap.createBitmap(first.getWidth(), first.getHeight(), first.getConfig());
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(first, 0f,0f, null);
        canvas.drawBitmap(second, 10,10,null);
        canvas.drawBitmap(third,20,20,null);

        return result;
    }

    public void openMatchClothes (){
        Intent intent = new Intent(matchOutfit.this, ViewClothes.class);
        startActivity(intent);
    }

}
