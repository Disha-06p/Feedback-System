package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.home.R;

public class MainActivity extends AppCompatActivity {

     Button feedback1,complaint1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedback1=(Button) findViewById(R.id.feedback1);
        complaint1=(Button) findViewById(R.id.complaint1);
        feedback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b1=new Bundle();
                Intent i1=new Intent(MainActivity.this,feedback.class);
                i1.putExtras(b1);
                startActivity(i1);
            }
        });
        complaint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b1=new Bundle();
                Intent i2=new Intent(MainActivity.this, comlaint.class);

                i2.putExtras(b1);
                startActivity(i2);
            }
        });
    }
}