package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    private Button button;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

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
                Intent intent = new Intent(MainActivity.this, newLogin.class);
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
