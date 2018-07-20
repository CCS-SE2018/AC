package com.applications.kuyakoya.dia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
            @Override

            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, test.class);
                startActivity(intent);
            }
        });
    }
}
