package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HospitalList extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spin1;
    private Button submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        submit = findViewById(R.id.submit);
        // protected void onCreate(Bundle savedInstanceState) {
        //        super.onCreate(savedInstanceState);
        //        //everything above this is the default
        //        setContentView(R.layout.activity_login);
        //        //the line above this sets the content view to the activity_login file
        addItemsOnSpinner();
       // onItemSelected();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Iowa")) {
                   Intent intent = new Intent(HospitalList.this, State_Iowa.class);
                   startActivity(intent);
                   finish();
               }
                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Illinois")) {
                    Intent intent = new Intent(HospitalList.this, State_Illinois.class);
                    startActivity(intent);
                    finish();
                }
                //fetchData process = new fetchData();
                //process.execute();
            }
        });


    }


    public void addItemsOnSpinner() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Alabama");
        list.add("Alaska");
        list.add("Arizona");
        list.add("Arkansas");
        list.add("California"); //5

        list.add("Colorado");
        list.add("Connecticut");
        list.add("Delaware");
        list.add("Florida");
        list.add("Georgia"); //10

        list.add("Hawaii");
        list.add("Idaho");
        list.add("Illinois");
        list.add("Indiana");
        list.add("Iowa"); //15

        list.add("Kansas");
        list.add("Kentucky");
        list.add("Louisiana");
        list.add("Maine");
        list.add("Maryland"); //20

        list.add("Massachusetts");
        list.add("Michigan");
        list.add("Minnesota");
        list.add("Mississippi");
        list.add("Missouri"); //25

        list.add("Montana");
        list.add("Nebraska");
        list.add("Nevada");
        list.add("New Hampshire");
        list.add("New Jersey"); //30

        list.add("New Mexico");
        list.add("New York");
        list.add("North Carolina");
        list.add("North Dakota");
        list.add("Ohio"); //35

        list.add("Oklahoma");
        list.add("Oregon");
        list.add("Pennsylvania");
        list.add("Rhode Island");
        list.add("South Carolina"); //40

        list.add("South Dakota");
        list.add("Tennessee");
        list.add("Texas");
        list.add("Utah");
        list.add("Vermont"); //45

        list.add("Virginia");
        list.add("Washington");
        list.add("West Virginia");
        list.add("Wisconsin");
        list.add("Wyoming"); //50

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }


  //  }
}
