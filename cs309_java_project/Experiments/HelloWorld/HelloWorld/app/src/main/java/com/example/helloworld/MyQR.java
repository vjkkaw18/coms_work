package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MyQR extends AppCompatActivity {

    ImageView qrImage;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_q_r);

        userInterface();
    }

    private void userInterface(){

        qrImage = findViewById(R.id.iv);

        Intent i = getIntent();
        data =i.getStringExtra("qr");

        QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 1000);
        // Getting QR-Code as Bitmap
        Bitmap qrBits= qrgEncoder.getBitmap();
        // Setting Bitmap to ImageView
        qrImage.setImageBitmap(qrBits);

    }

}