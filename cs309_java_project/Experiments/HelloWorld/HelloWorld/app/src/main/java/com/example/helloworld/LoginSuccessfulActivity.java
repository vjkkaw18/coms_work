package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import android.widget.Button;

/**
 * initial page for patients/general users upon logging in successfully
 */
public class LoginSuccessfulActivity extends AppCompatActivity {

 //   Button appInfo;
    Button LogoutButton;
    Button MapsButton;
    Button hospitals;
    Button hospitallist;
    Button covidassessment;
    Button testLoc;
    Button personal;
    Button scan;
    Button appointment;

    TextView tv;

    String id;
    String firstName;
    String lastName;
    String email;
    String userType;
    String password;
    //String store;

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
        covidassessment = findViewById(R.id.covidassessment);
        testLoc = findViewById(R.id.testLoc);
        tv = findViewById(R.id.tv);
        personal = findViewById(R.id.personal);
        scan = findViewById(R.id.scan);
        appointment = findViewById(R.id.button6);

        Intent i = getIntent();

        id = i.getStringExtra("id");
        firstName = i.getStringExtra("firstName");
        lastName = i.getStringExtra("lastName");
        email = i.getStringExtra("email");
        password = i.getStringExtra("password");
        userType = i.getStringExtra("userType");

        //tv.setText(userType);
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

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, Personal.class);
                intent.putExtra("id",id);
                intent.putExtra("firstName",firstName);
                intent.putExtra("lastName",lastName);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                intent.putExtra("userType",userType);
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

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, CodeScanner.class);
                startActivity(intent);
                finish();
            }
        });

        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, Appointment.class);
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

        covidassessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, CovidAssessmentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        testLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessfulActivity.this, TestLocationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }




}
