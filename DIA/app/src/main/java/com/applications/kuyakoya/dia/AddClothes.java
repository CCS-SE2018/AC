package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddClothes extends AppCompatActivity {

    TextView textView;
    Spinner spin_type;
    Spinner spin_kind;
    Spinner spin_available;
    Button btnAdd;
    Button btnChoose;
    ImageView image;

    private Uri filePath;
    private static final int PICK_IMAGE_REQUEST = 2;


    DatabaseReference databaseUsers;
    DatabaseReference databaseClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);

        databaseClothes = FirebaseDatabase.getInstance().getReference("clothes");
        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnChoose = (Button) findViewById(R.id.btn_choose);
        textView = (TextView) findViewById(R.id.desc);
        spin_kind = (Spinner) findViewById(R.id.spn_kind);
        spin_type = (Spinner) findViewById(R.id.spn_type);
        spin_available = (Spinner) findViewById(R.id.spn_available);
        image = (ImageView) findViewById(R.id.addImage);


        ArrayAdapter<CharSequence> adapterType;

        String[] type = {"UPPER", "LOWER", "FOOTWEAR"};

        adapterType = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,type);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_type.setAdapter(adapterType);

        ArrayAdapter<CharSequence> adapterAvailable =  ArrayAdapter
                .createFromResource(AddClothes.this, R.array.available,
                        android.R.layout.simple_spinner_dropdown_item);
        spin_available.setAdapter(adapterAvailable);

        spin_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                adapterView.getItemAtPosition(pos);
                if (pos == 0) {
                    ArrayAdapter<CharSequence> adapterKind =  ArrayAdapter
                            .createFromResource(AddClothes.this, R.array.kind_upper,
                                    android.R.layout.simple_spinner_dropdown_item);
                    spin_kind.setAdapter(adapterKind);
                } else if (pos == 1) {
                    ArrayAdapter<CharSequence> adapterKind = ArrayAdapter
                            .createFromResource(AddClothes.this, R.array.kind_lower,
                                    android.R.layout.simple_spinner_dropdown_item);
                    spin_kind.setAdapter(adapterKind);
                } else if (pos == 2) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter
                            .createFromResource(AddClothes.this, R.array.kind_footwear,
                                    android.R.layout.simple_spinner_dropdown_item);
                    spin_kind.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFilesChooser();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addClothes();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(AddClothes.this, manageClothes.class);
                        startActivity(intent);
                    }
                }, 1500);
            }
        });
    }

    private void addClothes(){
        String desc = this.textView.getText().toString().trim();
        String type = this.spin_type.getSelectedItem().toString();
        String kind = this.spin_kind.getSelectedItem().toString();
        String available = this.spin_available.getSelectedItem().toString();
        String imgPath = this.filePath.getPath();

        if(!TextUtils.isEmpty(desc)){
            String id = databaseClothes.push().getKey();
            String userID;

            clothes clothes = new clothes(id, type, kind, desc, available, imgPath);

            databaseClothes.child(type).setValue(clothes);

            Toast.makeText(this, "Successfully Added Item to database", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "You should enter a description", Toast.LENGTH_LONG).show();
        }
    }

    private void showFilesChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select an Image"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
