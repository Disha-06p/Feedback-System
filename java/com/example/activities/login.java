package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.home.R;

public class login extends AppCompatActivity {
  private
    EditText uemaillog,upasswordlog;
    Button ulogbtn;
    TextView newuser1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uemaillog=(EditText)findViewById(R.id.uemaillog);
        upasswordlog=(EditText) findViewById(R.id.upasswordlog);
        ulogbtn=(Button) findViewById(R.id.ulogbtn);
        newuser1=(TextView) findViewById(R.id.newuser1);
        ulogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(login.this,MainActivity.class);
                startActivity(i1);
            }
        });
        newuser1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(login.this,signup.class);
                startActivity(i2);
            }
        }));

    }
}