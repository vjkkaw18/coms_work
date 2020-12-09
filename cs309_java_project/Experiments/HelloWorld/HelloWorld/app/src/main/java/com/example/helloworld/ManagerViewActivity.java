package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * First page for a manager view, allows the manager to directly view inventory and hospital data of their choice
 */
public class ManagerViewActivity extends AppCompatActivity {
    private String stateSelect;

    private String store2;

    // JSONArray items = new JSONArray();
    private JSONObject jsonObject = new JSONObject();
    private JSONArray array = new JSONArray();
    private int hospital;
    private Button refresh2;
    private Button updateItemss;
    private Button pushButton;
    private Button webview;
    private Button button2;
    private String string22;
    private Button chat;

    private String name;
    private String address;
    private String location;
    private String countyname;
    private String websitename;
    private String telephonenumber;

    private String totalbeds;
    private String totalicubeds;
    private String totalecgmachines;
    private String totalventilators;
    private String totalcovidtesting;

    private String parseName;
    private String parseAddress;
    private String parseLocation;
    private String parseCounty;
    private String parseWebsite;
    private String parseTelephone;

    private String parsebeds;
    private String parseicu;
    private String parseecg;
    private String parseventilators;
    private String parsecovidtesting;

    private String parsebedstotal;
    private String parseicutotal;
    private String parseecgtotal;
    private String parseventilatorstotal;
    private String parsecovidtestingtotal;
    private String totalparsebedstotal;
    private String totalparseicutotal;
    private String totalparseecgtotal;
    private String totalparseventilatorstotal;
    private String totalparsecovidtestingtotal;
    private EditText goNumber;
    int number;
    Spinner selectItem;

    TextView website;

  //  private JSONObject object;

    private int newItemAmount;
    JSONObject o = new JSONObject(); //***********************************************************************************

    JSONArray array2 = new JSONArray();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_view_activity);


        refresh2 = (Button)findViewById(R.id.refresh2);
        updateItemss = (Button)findViewById(R.id.updateItemss);
        pushButton = (Button)findViewById(R.id.pushButton);
        webview = (Button)findViewById(R.id.webview);
        chat = (Button)findViewById(R.id.chatbutton);
        //jsonParse();

        hospital = -1;
        MyAppApplication myApp2 = new MyAppApplication();
        hospital = myApp2.getHospitalSelect();
       // String currentHospital = "nothing hee";


        TextView hospitalName = (TextView)findViewById(R.id.HospitalName2);
        TextView hospitalAddress = (TextView)findViewById(R.id.HospitalAddress2);
        TextView CityStateZIP = (TextView)findViewById(R.id.CityStateZIP2);
        TextView county = (TextView)findViewById(R.id.County2);
        TextView website = (TextView)findViewById(R.id.Website2);
        TextView telephone = (TextView)findViewById(R.id.Telephone2);

        TextView bedss = (TextView)findViewById(R.id.bedds2);
        TextView ICUbeds = (TextView)findViewById(R.id.ICUbeds2);
        TextView ecgMachines = (TextView)findViewById(R.id.ecgMachines2);
        TextView ventilators = (TextView)findViewById(R.id.ventilators2);
        TextView covidtesting = (TextView)findViewById(R.id.covidtesting2);

        TextView bedsstotal = (TextView)findViewById(R.id.bedss2total);
        TextView ICUbedstotal = (TextView)findViewById(R.id.ICUbeds2total);
        TextView ecgMachinestotal = (TextView)findViewById(R.id.ecgMachines2total);
        TextView ventilatorstotal = (TextView)findViewById(R.id.ventilators2total);
        TextView covidtestingtotal = (TextView)findViewById(R.id.covidtesting2total);

        EditText goNumber = (EditText) findViewById(R.id.goNumber);


        Spinner selectItem = (Spinner)findViewById(R.id.selectItem);
        EditText enterNumberItem = (EditText)findViewById(R.id.enterNumberItem);
        Button updateItem = (Button)findViewById(R.id.updateItemss);

        addItemsOnSpinner(); //this is new with a space on either side of it

        jsonParse();


        refresh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = Integer.parseInt(goNumber.getText().toString());
                myApp2.setHospitalSelect(number);
                hospital = myApp2.getHospitalSelect();
                jsonParse();
                getData(hospital);

                hospitalName.setText(name);
                hospitalAddress.setText(address);
                CityStateZIP.setText(location);
                county.setText(countyname);
                website.setText(websitename);
                telephone.setText(telephonenumber);

                bedss.setText(totalbeds);
                ICUbeds.setText(totalicubeds);
                ecgMachines.setText(totalecgmachines);
                ventilators.setText(totalventilators);
                covidtesting.setText(totalcovidtesting);

                bedsstotal.setText(totalparsebedstotal);
                ICUbedstotal.setText(totalparseicutotal);
                ecgMachinestotal.setText(totalparseecgtotal);
                ventilatorstotal.setText(totalparseventilatorstotal);
                covidtestingtotal.setText(totalcovidtesting);

                //fetchData process = new fetchData();
                //process.execute();
            }
        });

/*
        updateItemss.setOnClickListener(new View.OnClickListener() {
        });

*/

        pushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
                jsonParse();
                //String url = "http://coms-309-rp-02.cs.iastate.edu:8080/hospitallists";
                newItemAmount = Integer.parseInt(enterNumberItem.getText().toString());
                myApp2.setHospitalSelect(Integer.parseInt(goNumber.getText().toString()));
                myApp2.setWebsiteURL(websitename);
                hospital = myApp2.getHospitalSelect();
               postData(hospital);
            }
        });


        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // myApp2.setWebsiteURL(website.getText().toString());
                myApp2.setWebsiteURL(websitename);
                temp();
            }
        });


        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // myApp2.setWebsiteURL(website.getText().toString());
                //myApp2.setWebsiteURL(websitename);
               // temp();
                temp2();
            }
        });

    }

    /**
     * start the HospitalWebpageActivity when called
     */
    private void temp() {
        Intent intent = new Intent(ManagerViewActivity.this, HospitalWebpageActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void temp2() {
        Intent intent = new Intent(ManagerViewActivity.this, ChatActivity.class);
        startActivity(intent);
        this.finish();
    }

    /**
     * get data from the server
     */
    private void jsonParse() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/hospitallists";
        JsonArrayRequest reqq= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                array2 = response;
                store2 = response.toString();

                JSONObject object = new JSONObject();
                // Log.d("check", array.toString());
                try {
                    //Log.d("check2", array.get(hospital-1).toString());
                    string22 = array2.get(hospital-1).toString(); //should be hospital-1
                    object = array2.getJSONObject(hospital-1); //should be hospital-1 //used to be local

                    parseName = object.get("name").toString();
                    parseAddress = object.get("address").toString();
                    parseLocation = object.get("city").toString() + ", " + object.get("state").toString() + "  " + object.get("zip").toString();
                    parseCounty = object.get("county").toString();
                    parseWebsite = object.get("website").toString();
                    parseTelephone = object.get("telephone").toString();

                    parsebeds = object.get("beds").toString();
                    parseicu = object.get("icu_beds").toString();
                    parseecg = object.get("ecg_machine").toString();
                    parseventilators = object.get("ventilator").toString();
                    parsecovidtesting = object.get("covid_testing").toString();

                    parsebedstotal = object.get("total_beds").toString();
                    parseicutotal = object.get("total_ICU_beds").toString();
                    parseecgtotal = object.get("total_ECG_machine").toString();
                    parseventilatorstotal = object.get("total_ventilator").toString();

                    getData(hospital-1);

                } catch (JSONException e) {
                    e.printStackTrace();
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

        queue.add(reqq);

    }

    /**
     * create a copy of the data in order to update the data more quickly and avoid overwriting data that should not be changed
     * @param hospital
     */
    private void getData(int hospital) {

        name = parseName;
        address = parseAddress;
        location = parseLocation;
        countyname = parseCounty;
        websitename = parseWebsite;
        telephonenumber = parseTelephone;

        totalbeds = parsebeds;
        totalicubeds = parseicu;
        totalecgmachines = parseecg;
        totalventilators = parseventilators;
        totalcovidtesting = parsecovidtesting;

        totalparsebedstotal = parsebedstotal;
        totalparseicutotal = parseicutotal;
        totalparseecgtotal = parseecgtotal;
        totalparseventilatorstotal = parseventilatorstotal;
        totalparsecovidtestingtotal = parsecovidtestingtotal;

    }


    /**
     * add the applicable items to the inventory list for this specific hospital
     */
    public void addItemsOnSpinner() {
        selectItem = (Spinner) findViewById(R.id.selectItem);
        List<String> list = new ArrayList<String>();
        list.add("Beds");
        list.add("ICU beds");
        list.add("ECG Machines");
        list.add("Ventilators");
        list.add("Covid testing"); //5

        list.add("Total beds");
        list.add("Total ICU beds");
        list.add("Total ECG Machines");
        list.add("Total Ventilators");
        list.add(""); //10

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectItem.setAdapter(dataAdapter);
    }


    /**
     * when the inventory is changed, put to the database, update the database, update all of the data in real-time
     * @param hospital
     */
    public void postData(int hospital) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String addon = Integer.toString(hospital);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/hospitallist/" + addon;


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, o,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        o = response;
                        try {

                            o.put("beds", totalbeds);
                            o.put("icu_beds", totalicubeds);
                            o.put("ecg_machine", totalecgmachines);
                            o.put("ventilator",totalventilators);
                            o.put("covid_testing", totalcovidtesting);
                            o.put("total_beds", totalparsebedstotal);
                            o.put("total_ICU_beds", totalparseicutotal);
                            o.put("total_ECG_machine", totalparseecgtotal);
                            o.put("total_ventilator", totalparseventilatorstotal);


                            if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("Beds")) o.put("beds", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("ICU beds")) o.put("icu_beds", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("ECG Machines")) o.put("ecg_machine", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("Ventilators")) o.put("ventilator", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("Covid testing")) o.put("covid_testing", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("Total beds")) o.put("total_beds", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("Total ICU beds")) o.put("total_ICU_beds", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("Total ECG Machines")) o.put("total_ECG_machine", newItemAmount);
                            else if (selectItem.getItemAtPosition(selectItem.getSelectedItemPosition()).toString().equals("Total Ventilators")) o.put("total_ventilator", newItemAmount);

                            //o.put("ecg_machine", 100);
                           // o.put("total_beds", 55);
                        } catch(JSONException e){}

                        Log.d("Test", response.toString());
                        Log.d("response reached", "here");
                        Log.d("json new", o.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Didn't work", error.toString());
            }


            protected Map<String,String> getHeaders() {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

           // @Override
            public String getBodyContentType() {
                return "application/json";
            }

        });
  //      jsonParse();
        requestQueue.add(jsonObjectRequest);
    }
}





