package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText LoginEmail;
    EditText PasswordEnter;
    Button LoginButton;
    Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //everything above this is the default
        setContentView(R.layout.activity_login);
        //the line above this sets the content view to the activity_login file

        userInterface();
        signins();

    }

    private void userInterface() {
        LoginEmail = findViewById(R.id.email);
        PasswordEnter = findViewById(R.id.PasswordEnter);
        LoginButton = findViewById(R.id.LoginButton);
        RegisterButton = findViewById(R.id.RegisterButton);
    }

    private void signins() {
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmail();
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void checkEmail() {
        boolean correct = true;
        if (isEmpty(LoginEmail)) {
            Toast toast = Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT);
            toast.show();
            LoginEmail.setError("Enter email");
            correct = false;
        }
        else {
            if (isEmail(LoginEmail) == false) {
                Toast toast = Toast.makeText(this, "Email incorrect", Toast.LENGTH_SHORT);
                toast.show();
                LoginEmail.setError("Email incorrect");
                correct = false;
            }
        }

        if (correct == true) {
            String emailInput = LoginEmail.getText().toString();
            String passwordInput = PasswordEnter.getText().toString();
            if (emailInput.equals("djking@iastate.edu") && (passwordInput.equals("password123"))) {
                Intent intent = new Intent(LoginActivity.this, LoginSuccessfulActivity.class); //need to eventually change
                startActivity(intent);
                this.finish();
            }

            else {
                Toast toast = Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

        if (isEmpty(PasswordEnter)) {
            PasswordEnter.setError("Enter a password");
            correct = false;
        }
        else {
            if (PasswordEnter.getText().toString().length() < 5) {
                PasswordEnter.setError("Password needs to be 5 characters or more.");
                correct = false;
            }
        }
    }

    boolean isEmpty(EditText text) {
        CharSequence sequence = text.getText().toString();
        return TextUtils.isEmpty(sequence);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }



}
