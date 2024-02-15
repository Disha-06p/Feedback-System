package com.example.activities;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.R;
import com.example.utilities.Constants;
import com.example.utilities.PreferenceManager;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class signup extends AppCompatActivity {
    private PreferenceManager preferenceManager;
    EditText unamesign,uemailsign,upasswordsign,uconfirmpasswordsign,ucardnosign;
    Button usignbtn;
    TextView ualreadysign;
    private String encodedImage;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        preferenceManager = new PreferenceManager(getApplicationContext());
        usignbtn=(Button) findViewById(R.id.usignbtn);
        unamesign=(EditText) findViewById(R.id.unamesign);
        uemailsign=(EditText) findViewById(R.id.uemailsign);
        upasswordsign=(EditText) findViewById(R.id.upasswordsign);
        uconfirmpasswordsign=(EditText) findViewById(R.id.uconfirmpasswordsign);
        ucardnosign=(EditText) findViewById(R.id.ucardnosign);
        ualreadysign=(TextView) findViewById(R.id.ualreadysign);

    }
    private void setListener(){
        ualreadysign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup.this,login.class);
                startActivity(i);
            }
        });
        usignbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidsignupDetails()){
                    SignUp();
                }
            }
        });
    }

        private void showToast(String message){
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

        }
        private void SignUp(){
            FirebaseFirestore database = FirebaseFirestore.getInstance();
            HashMap<String, Object> user = new HashMap<>();
            user.put(Constants.KEY_NAME, unamesign.getText().toString());
            user.put(Constants.KEY_EMAIL, uemailsign.getText().toString());
            user.put(Constants.KEY_PHONE_NUMBER, ucardnosign.getText().toString());
            user.put(Constants.KEY_PASSWORD, upasswordsign.getText().toString());
            database.collection(Constants.KEY_COLLECTION_USERS)
                    .add(user)
                    .addOnSuccessListener(documentReference -> {
                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN,true);
                        preferenceManager.putString(Constants.KEY_EMAIL,uemailsign.getText().toString());
                        preferenceManager.putString(Constants.KEY_USER_ID, documentReference.getId());
                        preferenceManager.putString(Constants.KEY_NAME, unamesign.getText().toString());
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    })
                    .addOnFailureListener(exception ->{
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                    });


        }
        private Boolean isValidsignupDetails(){
            if (unamesign.getText().toString().trim().isEmpty()) {
                showToast("Enter Name");
                return false;
            } else if (uemailsign.getText().toString().trim().isEmpty()) {
                showToast("Enter Email");
                return false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(uemailsign.getText().toString()).matches()) {
                showToast("Enter Valid email");
                return false;
            } else if (ucardnosign.getText().toString().trim().isEmpty()) {
                showToast("Enter Phone Number");
                return false;
            } else if (upasswordsign.getText().toString().trim().isEmpty()) {
                showToast("Enter Password");
                return false;
            } else if (uconfirmpasswordsign.getText().toString().trim().isEmpty()) {
                showToast("ReEnter Password");
                return false;
            } else if (!upasswordsign.getText().toString().equals(uconfirmpasswordsign.getText().toString())) {
                showToast("Passwords do not Match");
                return false;
            }else{
                return true;
            }
        }
}