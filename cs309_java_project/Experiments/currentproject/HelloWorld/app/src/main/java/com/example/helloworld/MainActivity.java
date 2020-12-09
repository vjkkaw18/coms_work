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
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    Button register;
    Button AlreadyRegister;
    RequestQueue queue;
    EditText storedata;
    private TextView textView;
    private TextView resultTextView;
    boolean check;

    //for the server
    String firstnameu;
    String lastnameu;
    String emailu;
    String passwordu;
    String store;

    //Testing for Receive data from Server
    RequestQueue rq;
    String url = "http://coms-309-rp-02.cs.iastate.edu:8080/logins";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //everything above this is the default

        //Testing for Receive data from Server
        rq = Volley.newRequestQueue(this);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        String store = "";
        AlreadyRegister = findViewById(R.id.AlreadyRegister);
        queue = Volley.newRequestQueue(this);

        //textView = (TextView) findViewById(R.id.firstName);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
                if (!isEmpty(firstName) && !isEmpty(lastName) && !isEmail(email) == false) {
                    firstnameu = firstName.getText().toString();
                    lastnameu = lastName.getText().toString();
                    emailu = email.getText().toString();
                    passwordu = password.getText().toString();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    postData();

                }
               jsonParse();
    //            Log.d("success", store);
   //             practiceparse();
            }
        });

        AlreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
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

    private void jsonParse() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/logins";
        JsonArrayRequest req= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            store = response.toString();
            //Log.d("success", store);
            //Log.d("success", String.valueOf(store.contains("djking@iastate.edu"))); //check if it contains what we needs
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

    public void postData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("firstName", firstnameu);
            object.put("lastName", lastnameu);
            object.put("email", emailu);
            object.put("password", passwordu);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/logins";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Test", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Didn't work", error.toString());
            }

            protected Map<String,String> getParams() {
                Map<String,String> params = new HashMap<String, String>();
                params.put("firstName","hello");
                params.put("lastName", "bye");
                params.put("email", "email@emailtest.com");
                params.put("password", "passwordtest");
                return params;
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
   /** private void practiceparse() {
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        queue = new RequestQueue(cache, network);
        queue.start();
        final TextView textView = (TextView) findViewById(R.id.firstName);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/logins"; //should be http:// in front
        JsonArrayRequest req= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
        //StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Listener<String>() {

            @Override
            public void onResponse(JSONArray response) {
            //public void onResponse(String response) {
                textView.setText("send a test");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("did not work try again");
            }
        });
        //queue.add(stringRequest);
        queue.add(req);
    } **/
}