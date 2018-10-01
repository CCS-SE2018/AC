package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class newLogin extends AppCompatActivity {

    private TextView textview, username, password;
    private Button button;

    DatabaseReference databaseUsers;
    DatabaseReference databaseClothes;
    FirebaseDatabase database;
    DatabaseReference userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);

        databaseClothes = FirebaseDatabase.getInstance().getReference("clothes");
        databaseUsers = FirebaseDatabase.getInstance().getReference("users");
        database = FirebaseDatabase.getInstance();
        userLogin = database.getReference("users");
        username = (TextView) findViewById(R.id.tv_username);
        password = (TextView) findViewById(R.id.tv_password);
        button = (Button) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString(),password.getText().toString());
//                Toast.makeText(newLogin.this, "clicked", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(newLogin.this, MainActivity.class);
//                startActivity(intent);
            }
        });

        textview = (TextView) findViewById(R.id.opensignup);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(newLogin.this, newSignUp.class);
                startActivity(intent);
            }
        });

    }

    private void login(final String username, final String password) {
        userLogin.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(username).exists()){
                    if (!username.isEmpty()){
                        users login = dataSnapshot.child(username).getValue(users.class);
                        if(login.getPassword().equals(password)){
                            Toast.makeText(newLogin.this, "Success Login", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(newLogin.this, MainActivity.class);
                            startActivity(intent);
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//
//
//                            }
//                        }, 1500);
                        }
                    }
                    else{
                        Toast.makeText(newLogin.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(newLogin.this, "Username is not registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
