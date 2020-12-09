package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //everything above this is the default

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    boolean isEmpty(EditText text) {
        CharSequence sequence = text.getText().toString();
        return TextUtils.isEmpty(sequence);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    void validate() {
        if (isEmpty(firstName)) {
            Toast toast = Toast.makeText(this, "Enter first name, please!", Toast.LENGTH_SHORT);
            toast.show();
        }

        if (isEmpty(lastName)) {
            Toast toast = Toast.makeText(this, "Enter last name, please!", Toast.LENGTH_SHORT);
            toast.show();
        }

        if (isEmail(email) == false) {
            Toast toast = Toast.makeText(this, "Enter valid email, please.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}