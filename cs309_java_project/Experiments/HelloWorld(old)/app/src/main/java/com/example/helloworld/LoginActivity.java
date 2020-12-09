package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "1";
    EditText LoginEmail;
    EditText PasswordEnter;
    Button LoginButton;
    Button RegisterButton;
    String verify;
    String emailu;
    String passwordu;
    String store;
    boolean check;
    String[] arr;
    private TextView textView;
//    RequestQueue queue = Volley.newRequestQueue(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //everything above this is the default
        setContentView(R.layout.activity_login);
        //the line above this sets the content view to the activity_login file
        LoginEmail = findViewById(R.id.LoginEmail);
        PasswordEnter = findViewById(R.id.PasswordEnter); //edit text type cast explicit for all text
        LoginButton = findViewById(R.id.LoginButton);
        RegisterButton = findViewById(R.id.RegisterButton);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailu = LoginEmail.getText().toString();
                passwordu = PasswordEnter.getText().toString();
                verify = "\"email\":\"" + emailu + "\",\"password\":\"" + passwordu + "\"";
                jsonParse();
                checkEmail();
                //fetchData process = new fetchData();
                //process.execute();
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

  //      userInterface();
  //      signins();
    }


    void checkEmail() {
        boolean correct = true;
        if (isEmpty(LoginEmail) == true) {
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

            //if (emailInput.equals("djking@iastate.edu") && (passwordInput.equals("password123"))) {
            //verify = "hello please work"; //the problem is getting verify to turn into a string!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //Log.d(TAG, verify); //verify needs to be a string!!!!!!!!!!!!!!!!!!! not sure how to fix it
    //        if (verify.contains("djking@iastate.edu")) {
    //            Intent intent = new Intent(LoginActivity.this, LoginSuccessfulActivity.class); //need to eventually change
    //            startActivity(intent);
     //           this.finish();
    //        }

            if (check == true) {
                Intent intent = new Intent(LoginActivity.this, LoginSuccessfulActivity.class);
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
        String sequence = text.getText().toString();
        return TextUtils.isEmpty(sequence);
    }

    boolean isEmail(EditText text) {
        String email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }



    private void jsonParse() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/logins";
        JsonArrayRequest req= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                store = response.toString();
                Log.d("success(login)", store);
                Log.d("success", String.valueOf(store.contains("djking@iastate.edu"))); //check if it contains what we needs
                if (store.contains(verify)) {
                    Intent intent = new Intent(LoginActivity.this, LoginSuccessfulActivity.class);
                    startActivity(intent);
                   // this.finish();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
                error.printStackTrace();
            }


        }){

            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/json");
                return headers;
            }

        };
        queue.add(req);
    }



}
