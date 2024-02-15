package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.home.R;

public class admlogin extends AppCompatActivity {
    EditText aemaillog,apasswordlog;
    Button alogbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admlogin);
        aemaillog=(EditText)findViewById(R.id.aemaillog);
        apasswordlog=(EditText) findViewById(R.id.apasswordlog);
        alogbtn=(Button) findViewById(R.id.alogbtn);
        alogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(admlogin.this, MainActivity2.class);
                startActivity(i1);

            }
        });
    }
}