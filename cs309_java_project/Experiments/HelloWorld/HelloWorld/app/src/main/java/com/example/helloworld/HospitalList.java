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

/**
 * Allows users to select a hospital, view covid data, and move to a unique state's hospital data.
 */
public class HospitalList extends AppCompatActivity {
    private String stateSelect;
    private Spinner spinner1;
    private Spinner spin1;
    private Button submit;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        submit = findViewById(R.id.submit);
        ////

        MyAppApplication mApp = ((MyAppApplication)getApplicationContext());
        stateSelect = mApp.getStateSelect();
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

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Alabama")) {
                    mApp.setStateSelect("Alabama");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Alaska")) {
                    mApp.setStateSelect("Alaska");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Arizona")) {
                    mApp.setStateSelect("Arizona");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Arkansas")) {
                    mApp.setStateSelect("Arkansas");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("California")) { //number 5
                    mApp.setStateSelect("California");
                }

                //that's 5
//keep going from here

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Colorado")) {
                    mApp.setStateSelect("Colorado");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Connecticut")) {
                    mApp.setStateSelect("Connecticut");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Delaware")) {
                    mApp.setStateSelect("Delaware");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Florida")) {
                    mApp.setStateSelect("Florida");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Georgia")) { //number 10
                    mApp.setStateSelect("Georgia");
                }

                //that's 10

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Hawaii")) {
                    mApp.setStateSelect("Hawaii");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Idaho")) {
                    mApp.setStateSelect("Idaho");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Illinois")) {
                    mApp.setStateSelect("Illinois");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Indiana")) {
                    mApp.setStateSelect("Indiana");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Iowa")) {
                    mApp.setStateSelect("Iowa");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Kansas")) {
                    mApp.setStateSelect("Kansas");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Kentucky")) { //number 15
                    mApp.setStateSelect("Kentucky");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Louisiana")) {
                    mApp.setStateSelect("Louisiana");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Maine")) {
                    mApp.setStateSelect("Maine");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Maryland")) {
                    mApp.setStateSelect("Maryland");
                }
                //that's 20

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Massachusetts")) {
                    mApp.setStateSelect("Massachusetts");
                }
                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Michigan")) {
                    mApp.setStateSelect("Michigan");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Minnesota")) {
                    mApp.setStateSelect("Minnesota");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Mississippi")) {
                    mApp.setStateSelect("Mississippi");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Missouri")) {
                    mApp.setStateSelect("Missouri");
                }

                //that's 25

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Montana")) {
                    mApp.setStateSelect("Montana");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Nebraska")) {
                    mApp.setStateSelect("Nebraska");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Nevada")) {
                    mApp.setStateSelect("Nevada");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("New Hampshire")) {
                    mApp.setStateSelect("New Hampshire");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("New Jersey")) {
                    mApp.setStateSelect("New Jersey");
                }

                    //that's 30


                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("New Mexico")) {
                    mApp.setStateSelect("New Mexico");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("New York")) {
                    mApp.setStateSelect("New York");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("North Carolina")) {
                    mApp.setStateSelect("North Carolina");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("North Dakota")) {
                    mApp.setStateSelect("North Dakota");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Ohio")) {
                    mApp.setStateSelect("Ohio");
                }
                //35


                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Oklahoma")) {
                    mApp.setStateSelect("Oklahoma");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Oregon")) {
                    mApp.setStateSelect("Oregon");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Pennsylvania")) {
                    mApp.setStateSelect("Pennsylvania");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Rhode Island")) {
                    mApp.setStateSelect("Rhode Island");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("South Carolina")) {
                    mApp.setStateSelect("South Carolina");
                }
                //40


                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("South Dakota")) {
                    mApp.setStateSelect("South Dakota");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Tennessee")) {
                    mApp.setStateSelect("Tennessee");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Texas")) {
                    mApp.setStateSelect("Texas");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Utah")) {
                    mApp.setStateSelect("Utah");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Vermont")) {
                    mApp.setStateSelect("Vermont");
                }
                //45


                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Virginia")) {
                    mApp.setStateSelect("Virginia");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Washington")) {
                    mApp.setStateSelect("Washington");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("West Virginia")) {
                    mApp.setStateSelect("West Virginia");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Wisconsin")) {
                    mApp.setStateSelect("Wisconsin");
                }

                if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Wyoming")) {
                    mApp.setStateSelect("Wyoming");
                }
                //50
                //add more if you need to , but that's all the states

                Intent intent = new Intent(HospitalList.this, State_Iowa.class); //the three lines starting here will need to go after all the state statements, eventually
                startActivity(intent);
                finish();

               // if (spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString().equals("Illinois")) {
               //     Intent intent = new Intent(HospitalList.this, State_Illinois.class);
               //     startActivity(intent);
               //     finish();
               // }
                //fetchData process = new fetchData();
                //process.execute();
            }
        });


    }

    /**
     * Adds all required items on the state spinner.
     */
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
