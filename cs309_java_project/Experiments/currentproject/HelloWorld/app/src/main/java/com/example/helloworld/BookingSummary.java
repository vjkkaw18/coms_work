package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import android.widget.Button;

public class BookingSummary extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;

    String t1;
    String t2;
    String t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_successful_activity);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//            String store = extras.getString("store");
            t1 = extras.getString("ov1");
            t2 = extras.getString("ov2");
            t3 = extras.getString("ov3");

//            //The key argument here must match that used in the other activity
//            tv1.setText(t1);
//            tv2.setText(t2);
//            tv3.setText(t3);

//            tv1.setText(store);
        }
        userInterface();
        changesides();

    }

    private void userInterface() {
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

    }


    private void changesides() {
        tv1.setText("Apple : " + t1);
        tv2.setText("Orange : " + t2);
        tv3.setText("Banana : " + t3);

    }


}