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
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * Login Activity class for users to enter their login credentials; used for all types of users
 */
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
    EditText idNumber;
    String usertype;
    int idnum;
    String newValue;
    int newValue2;
    String idNumbers;

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
        idNumber = findViewById(R.id.idNumber);

        MyAppApplication hospitalIDs = new MyAppApplication();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
                idNumbers = idNumber.getText().toString();

               // hospitalIDs = idNumber.getText().toString();

               // hospitalIDs.setHospitalSelect(Integer.parseInt(idNumbers));

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


    /**
     * Check email for correct email pattern, also check if empty
     */
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
                //here are the different types of logins
                //need to have some sort of variable to keep track of user type, hospital ID,
                //for example, if you select a manager, need to immediately go to the manager view with the correct hospital for the ID that is chosen



                //also need a separate classification for staff, where they can change the numbers of their hospital inventory for that unique hospital


                //below here is for a general user; there is no need to change this if not STAFF or MANAGER
                Intent intent = new Intent(LoginActivity.this, LoginSuccessfulActivity.class);
                startActivity(intent);
                this.finish();
            }
            else {
               // Toast toast = Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT);
               // toast.show();
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

    /**
     * check if EditText field is empty
     * @param text
     * @return
     */
    boolean isEmpty(EditText text) {
        String sequence = text.getText().toString();
        return TextUtils.isEmpty(sequence);
    }

    /**
     * check if EditText field is a valid email
     * @param text
     * @return
     */
    boolean isEmail(EditText text) {
        String email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


    /**
     * jsonParse method to validate user credentials with the /logins database
     */
    private void jsonParse() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/logins";
        JsonArrayRequest req= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                store = response.toString();
                Log.d("success(login)", store);
                Log.d("success", String.valueOf(store.contains("djking@iastate.edu"))); //check if it contains what we needs
                if (store.contains(verify) || (emailu.equals("djking@iastate.edu") && passwordu.equals("password123"))) {
                    if (store.contains("\"email\":\"" + emailu + "\",\"password\":\"" + passwordu + "\",\"userType\":\"MANAGER\"")) {

                    //   MyAppApplication setHospital = new MyAppApplication();
                    //   newValue = idNumber.getText().toString();
                    //    newValue2 = Integer.parseInt(newValue);
                       // setHospital.setHospitalSelect(Integer.parseInt(newValue));
                  //      idnum = idNumber;
                   //     setHospital.setHospitalSelect(newValue2);

                        Intent intent = new Intent(LoginActivity.this, ManagerViewActivity.class);
                        startActivity(intent);
                        //also need to specify the ID
                    }

                    else if (store.contains("\"email\":\"" + emailu + "\",\"password\":\"" + passwordu + "\",\"userType\":\"STAFF\"")) {
                        //Intent intent = new Intent(LoginActivity.this, ManagerViewActivity.class);
                        //also need to specify the ID
                    }

                    else {

                        Intent intent = new Intent(LoginActivity.this, LoginSuccessfulActivity.class);
                        int iter = 0;

                        for(int i = 0; i < response.length(); i++){
                            try {
                                if(response.getJSONObject(i).toString().contains(verify)){
                                    iter = i;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        try {
                            intent.putExtra("id",response.getJSONObject(iter).getString("id"));
                            intent.putExtra("firstName",response.getJSONObject(iter).getString("firstName"));
                            intent.putExtra("lastName",response.getJSONObject(iter).getString("lastName"));
                            intent.putExtra("email",response.getJSONObject(iter).getString("email"));
                            intent.putExtra("password",response.getJSONObject(iter).getString("password"));
                            intent.putExtra("userType",response.getJSONObject(iter).getString("userType"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        startActivity(intent);
                        // this.finish();
                    }
                }

                else {
                    //Toast toast = Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT);
                   // toast.show();
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
