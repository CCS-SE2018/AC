package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class AddClothes extends AppCompatActivity {

    TextView textView;
    Spinner spin_type;
    Spinner spin_kind;
    Button button;


    DatabaseReference databaseClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);

        databaseClothes = FirebaseDatabase.getInstance().getReference("clothes");

        textView = (TextView) findViewById(R.id.tv_desc);
        button = (Button) findViewById(R.id.btn_add);
        spin_kind = (Spinner) findViewById(R.id.spn_kind);
        spin_type = (Spinner) findViewById(R.id.spn_type);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addClothes();
                Snackbar.make(view, "Successfully Added!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

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
        String desc = textView.getText().toString().trim();
        String type = spin_type.getSelectedItem().toString();
        String kind = spin_kind.getSelectedItem().toString();

        if(!TextUtils.isEmpty(desc)){
            String id = databaseClothes.push().getKey();

            clothes clothes = new clothes(id, type, desc, kind);

            databaseClothes.child(id).setValue(clothes);

            Toast.makeText(this, "Clothes added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "You should enter a description", Toast.LENGTH_LONG).show();
        }
    }
}
