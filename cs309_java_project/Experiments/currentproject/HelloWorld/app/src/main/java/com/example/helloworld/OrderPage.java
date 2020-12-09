package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//import android.widget.Button;

public class OrderPage extends AppCompatActivity {

    EditText ov1;
    EditText ov2;
    EditText ov3;
    Button confirm;

    String o1;
    String o2;
    String o3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_successful_activity);
//        userInterface();
//        changesides();

    }

//    private void userInterface() {
//        ov1 = findViewById(R.id.ov1);
//        ov2 = findViewById(R.id.ov2);
//        ov3 = findViewById(R.id.ov3);
//        confirm = findViewById(R.id.confirm);
//
////        o1 = ov1.getText().toString();
////        o2 = ov2.getText().toString();
////        o3 = ov3.getText().toString();
//    }


//    private void changesides() {
//
//
//        confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(OrderPage.this, BookingSummary.class);
////                o1 = ov1.getText().toString();
////                o2 = ov2.getText().toString();
////                o3 = ov3.getText().toString();
//
////                intent.putExtra("ov1",o1);
////                intent.putExtra("ov2",o2);
////                intent.putExtra("ov3",o3);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }


}