package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appointment extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;

    EditText mail;
    EditText hospital;

    EditText q1;
    EditText q2;
    EditText q3;

    Button submit;
    Button supply;
    Button equipment;
    Button testing;

    String email;
    String hospitalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner2);
        spinner2 = findViewById(R.id.spinner3);
        submit = findViewById(R.id.button);
        supply = findViewById(R.id.button2);
        equipment = findViewById(R.id.button4);
        testing = findViewById(R.id.button5);
        mail = findViewById(R.id.editTextTextPersonName);
        hospital = findViewById(R.id.editTextTextPersonName2);
        q1 = findViewById(R.id.editTextNumber);
        q2 = findViewById(R.id.editTextNumber2);
        q3 = findViewById(R.id.editTextNumber3);

        List<Supplies> supplyList = new ArrayList<>();
        Supplies sp1 = new Supplies("ICU Beds", 20);
        supplyList.add(sp1);
        Supplies sp2 = new Supplies("IV Drips", 23);
        supplyList.add(sp2);
        Supplies sp3 = new Supplies("Syringes", 25);
        supplyList.add(sp3);

        List<Equipment> equipmentList = new ArrayList<>();
        Equipment eq1 = new Equipment("ECG", 30);
        equipmentList.add(eq1);
        Equipment eq2 = new Equipment("MRI", 33);
        equipmentList.add(eq2);
        Equipment eq3 = new Equipment("X-Ray", 35);
        equipmentList.add(eq3);

        List<Testing> testList = new ArrayList<>();
        Testing tl1 = new Testing("Covid-19", 10);
        testList.add(tl1);
        Testing tl2 = new Testing("Liver Test", 13);
        testList.add(tl2);
        Testing tl3 = new Testing("Kidney Test", 15);
        testList.add(tl3);

        ArrayAdapter<Supplies> adapter = new ArrayAdapter<Supplies>(this,
                android.R.layout.simple_spinner_item, supplyList);
        ArrayAdapter<Equipment> adapter1 = new ArrayAdapter<Equipment>(this,
                android.R.layout.simple_spinner_item, equipmentList);
        ArrayAdapter<Testing> adapter2 = new ArrayAdapter<Testing>(this,
                android.R.layout.simple_spinner_item, testList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              Supplies supply = (Supplies) parent.getSelectedItem();
              displaySupplyData(supply);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {
          }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Equipment equipment = (Equipment) parent.getSelectedItem();
                displayEquipmentData(equipment);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Testing test = (Testing) parent.getSelectedItem();
                displayTestingData(test);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
                if (!isEmpty(mail) && !isEmpty(hospital)) {
                    email = mail.getText().toString();
                    hospitalName = hospital.getText().toString();
                    postData();

                }
                //jsonParse();

            }
        });

    }

    boolean isEmpty(EditText text) {
        CharSequence sequence = text.getText().toString();
        return TextUtils.isEmpty(sequence);
    }
    
    boolean isEmailString(String string) {
        return (string != null && string.contains("@") && string.contains("."));
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    void validate() {
        if (isEmail(mail) == false) {
            Toast toast = Toast.makeText(this, "Enter valid email, please.", Toast.LENGTH_SHORT);
            toast.show();
        }

        if (isEmpty(hospital)) {
            Toast toast = Toast.makeText(this, "Enter hospital name, please!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


        @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);
    }

    public void getSelectedSupplies(View v) {
        Supplies sp = (Supplies) spinner.getSelectedItem();
        displaySupplyData(sp);
    }

    public void getSelectedEquipment(View v) {

        Equipment eq = (Equipment) spinner1.getSelectedItem();
        displayEquipmentData(eq);
    }

    public void getSelectedTesting(View v) {

        Testing tt = (Testing) spinner2.getSelectedItem();
        displayTestingData(tt);
    }
    private void displaySupplyData(Supplies supply) {
        String name = supply.getName();
        int quantity = supply.getQuantity();
        String userData = "Name: " + name + "\nAge: " + quantity;
        Toast.makeText(this, userData, Toast.LENGTH_LONG).show();
    }

    private void displayEquipmentData(Equipment equipment) {
        String name = equipment.getName();
        int quantity = equipment.getQuantity();
        String userData = "Name: " + name + "\nQuantity: " + quantity;
        Toast.makeText(this, userData, Toast.LENGTH_LONG).show();
    }

    private void displayTestingData(Testing test) {
        String name = test.getName();
        int quantity = test.getQuantity();
        String userData = "Name: " + name + "\nQuantity: " + quantity;
        Toast.makeText(this, userData, Toast.LENGTH_LONG).show();
    }

    public void postData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            object.put("email", mail);
            object.put("hospitalName", hospital);

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
                params.put("email","abc@ab.com");
                params.put("hospital", "ABC Hospital");

                return params;
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}