package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.home.R;

public class MainActivity2 extends AppCompatActivity {
    Button feedback2,complaint2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        feedback2=(Button) findViewById(R.id.feedback2);
        complaint2=(Button) findViewById(R.id.complaint2);
        feedback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity2.this,viewfeedback.class);
                startActivity(i1);
            }
        });
        complaint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MainActivity2.this,viewcomplaint.class);
                startActivity(i2);
            }
        });
    }
}