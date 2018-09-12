package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newSignUp extends AppCompatActivity {

    Button signup;
    TextView userName, pw;

    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sign_up);

        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        signup = (Button) findViewById(R.id.btn_signup);
        userName = (TextView) findViewById(R.id.tv_username);
        pw = (TextView) findViewById(R.id.tv_password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addUsers();
                Snackbar.make(view, "Successfully Added!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(newSignUp.this, newLogin.class);
                        startActivity(intent);
                    }
                }, 1500);
            }
        });

    }

    private void addUsers(){
        String username = this.userName.getText().toString();
        String password = this.pw.getText().toString();

        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){
            String userID = databaseUsers.push().getKey();

            users users = new users(userID, username, password);

            databaseUsers.child(userID).setValue(users);

            Toast.makeText(this, "Users added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "You should enter a description", Toast.LENGTH_LONG).show();
        }
    }

}
