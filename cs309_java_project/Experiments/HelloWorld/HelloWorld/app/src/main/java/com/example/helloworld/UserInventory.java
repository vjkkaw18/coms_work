package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Create the user inventory page, allows users to view inventory and wait times for a hospital, without the capability to edit the data or put to server
 */
public class UserInventory extends AppCompatActivity {

    private String store;
    private String substore;

/*
    TextView hospitalName;
    TextView hospitalAddress;
    TextView CityStateZip;
    TextView County;
    TextView Website;
    TextView Telephone;
*/

    private int startchar;
    private int endchar;
   // JSONArray items = new JSONArray();
   private JSONObject jsonObject = new JSONObject();
    private JSONArray array = new JSONArray();
    private int hospital;
    private Button refresh;
    private String string;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinventory);

        refresh = (Button)findViewById(R.id.refresh);
        //jsonParse();
        hospital = -1;
        String currentHospital = "nothing hee";


        TextView hospitalName = (TextView)findViewById(R.id.HospitalName);
        TextView hospitalAddress = (TextView)findViewById(R.id.HospitalAddress);
        TextView CityStateZIP = (TextView)findViewById(R.id.CityStateZIP);
        TextView county = (TextView)findViewById(R.id.County);
        TextView website = (TextView)findViewById(R.id.Website);
        TextView telephone = (TextView)findViewById(R.id.Telephone);

        TextView bedss = (TextView)findViewById(R.id.bedss);
        TextView ICUbeds = (TextView)findViewById(R.id.ICUbeds);
        TextView ecgMachines = (TextView)findViewById(R.id.ecgMachines);
        TextView ventilators = (TextView)findViewById(R.id.ventilators);
        TextView covidtesting = (TextView)findViewById(R.id.covidtesting);

        TextView bedsstotal = (TextView)findViewById(R.id.bedsstotal);
        TextView ICUbedstotal = (TextView)findViewById(R.id.icubedstotal);
        TextView ecgMachinestotal = (TextView)findViewById(R.id.ecgMachinestotal);
        TextView ventilatorstotal = (TextView)findViewById(R.id.ventilatorstotal);
        TextView covidtestingtotal = (TextView)findViewById(R.id.covidtestingtotal);

        MyAppApplication mApp = ((MyAppApplication)getApplicationContext());

        //MyAppApplication mAppu = ((MyAppApplication)getApplicationContext());
        hospital = mApp.getHospitalSelect();
        currentHospital = mApp.getHospitalName();
        //System.out.println(currentHospital);
        jsonParse();
       // getData(hospital);

        hospitalName.setText(name);
        hospitalAddress.setText(address);
       // submit = findViewById(R.id.submit);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
                getData(hospital);
                hospitalName.setText(name);
                hospitalAddress.setText(address);
                CityStateZIP.setText(location);
                county.setText(countyname);
                website.setText(websitename);
                telephone.setText(telephonenumber);

                bedss.setText(totalparsebedstotal);
                ICUbeds.setText(totalparseicutotal);
                ecgMachines.setText(totalparseecgtotal);
                ventilators.setText(totalparseventilatorstotal);
                covidtesting.setText(totalcovidtesting);

                bedsstotal.setText(totalbeds);
                ICUbedstotal.setText(totalicubeds);
                ecgMachinestotal.setText(totalecgmachines);
                ventilatorstotal.setText(totalventilators);
                covidtestingtotal.setText(totalcovidtesting);

                //fetchData process = new fetchData();
                //process.execute();
            }
        });

    }


    /**
     * set live data from the server
     */
    private void jsonParse() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/hospitallists";
        JsonArrayRequest req= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            JSONArray array = new JSONArray();
            @Override
            public void onResponse(JSONArray response) {
                array = response;
                store = response.toString();



                Log.d("check", array.toString());
                try {
                    Log.d("check2", array.get(hospital-1).toString());
                    string = array.get(hospital-1).toString();
                    JSONObject object = array.getJSONObject(hospital-1);
                    Log.d("check3", object.toString());


                    parseName = object.get("name").toString();
                    Log.d("check4", parseName);

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

        queue.add(req);

    }


    /**
     * helper to ensure data is not overwritten or incorrectly displayed when more than one hospital information is displayed in one instance of the application
     * @param hospital
     */
    public void getData(int hospital) {

/*
        //wait for 10 seconds for the field to populate
        double timetrack = System.currentTimeMillis();
        double timebefore = System.currentTimeMillis();
        double timeafter = 5000;

        while (timeafter > timetrack - timebefore) {
            timetrack = System.currentTimeMillis();
        }
*/
       // if (hospital == 4977) { //should be 4977 for this test

               // try {
                //    JSONObject jsonObject = new JSONObject(array.get(4977).toString());
                    //if (jsonObject.get("fid").equals(4977)) ;
                    //   String namehold = jsonObject.get("name").toString();
                    //   String addresshold = jsonObject.get("address").toString();

                    //    name = namehold;
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

                        //hospitalAddress.setText("Mary Greeley Address");

               //     }


               // } //catch (JSONException e) {
                 //   name = "exception bullshit again";
               //     e.printStackTrace();
               // }
            // if (store.contains("\"fid:4977,\"")) {
            // startchar = store.charAt();

            //  }

            //substore = store.substring();
            //fill in the appropriate data from this hospital

            //RIGHT HERE SHOULD BE THE UNIQUE DATA FROM EACH HOSPITAL __ NEED TO READ IN from the string and print for the user view!!!!!

     //   }

       // else {
      //      address = "poopoop";
      //  }


    }

}
