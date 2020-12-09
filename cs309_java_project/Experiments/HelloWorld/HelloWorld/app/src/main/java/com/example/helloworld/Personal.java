package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class Personal extends AppCompatActivity {

    String id;
    String firstName;
    String lastName;
    String email;
    String userType;
    String password;
    String data;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;

    ImageView qrImage;

    Button QR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        userInterface();
        changesides();
    }

    private void userInterface(){

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        QR = findViewById(R.id.qr);
        qrImage = findViewById(R.id.iv);

        Intent i = getIntent();
        id = i.getStringExtra("id");
        firstName = i.getStringExtra("firstName");
        lastName = i.getStringExtra("lastName");
        email = i.getStringExtra("email");
        password = i.getStringExtra("password");
        userType = i.getStringExtra("userType");

        data = id + firstName + lastName + email + password + userType;

        QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 100);
        // Getting QR-Code as Bitmap
        Bitmap qrBits= qrgEncoder.getBitmap();
        // Setting Bitmap to ImageView
        qrImage.setImageBitmap(qrBits);

        tv1.setText("ID : " + id);
        tv2.setText("First Name : " + firstName);
        tv3.setText("Last Name : " + lastName);
        tv4.setText("Email : " + email);
        tv5.setText("Password : " + password);
        tv6.setText("User Type : " + userType);
    }

    private void changesides(){
        QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Personal.this, MyQR.class);
                intent.putExtra("qr",data);
                startActivity(intent);
                finish();
            }
        });
    }
}