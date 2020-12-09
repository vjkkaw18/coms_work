package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//import android.widget.Button;

public class LoginSuccessfulActivity extends AppCompatActivity {

 //   Button appInfo;
    Button LogoutButton;
    Button MapsButton;
    Button hospitals;
    Button hospitallist;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_successful_activity);
        //everything above this is the default
        //list any functions you are writing on this activity
        //simply the function calls, and the function descriptions will be listed below

       userInterface();
       changesides();

    }

    private void userInterface() {
        LogoutButton = findViewById(R.id.LogoutButton);
        MapsButton = findViewById(R.id.MapsButton);
        hospitals = findViewById(R.id.hospitals);
        hospitallist = findViewById(R.id.hospitallist);
    }


    private void changesides() {
 //       LogoutButton.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View view) {
  //              Intent intent = new Intent(LoginSuccessfulActivity.this, LoginActivity.class);
 //               startActivity(intent);
 //               finish();
 //           }
 //       });

        MapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, GoogleMapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        hospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, Arcgis.class);
                startActivity(intent);
                finish();
            }
        });

        hospitallist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, HospitalList.class);
                startActivity(intent);
                finish();
            }
        });
    }




}
