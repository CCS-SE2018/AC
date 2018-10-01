package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewClothes extends AppCompatActivity {
    ListView listView;
    List<clothes> clothesList;
    DatabaseReference databaseClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clothes);

        listView = (ListView) findViewById(R.id.listViewClothes);
        databaseClothes = FirebaseDatabase.getInstance().getReference("clothes");
        clothesList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseClothes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot clothesSnapshot: dataSnapshot.getChildren()){
                    clothes Clothes = clothesSnapshot.getValue(clothes.class);
                    clothesList.add(Clothes);
                }

                ListLayout upperClothesAdapter = new ListLayout(ViewClothes.this, clothesList);
                listView.setAdapter(upperClothesAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
