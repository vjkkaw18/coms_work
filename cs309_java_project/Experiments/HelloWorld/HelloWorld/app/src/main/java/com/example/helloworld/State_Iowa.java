package com.example.helloworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to create UI for all states. Includes unique state information, covid data, and more.
 */
public class State_Iowa extends AppCompatActivity {
    private ImageView stateFlag1; //state flag
    private ImageView imageView2; //graph of the state
    private String stateSelect;
    private TextView department;
    private TextView someData;
    private Button states;
    private Button goButton;
    private Button direct;
    BufferedReader reader = null;
    private String post = "";
    private String line = "";
    private Spinner hospitalSpinner;
    private Spinner spinner1;
    private int hospitalSelect;

    private String store;
  //  private String[] substore;
    private String substore;
    private TextView hospitalID;
    private String hospitalIDs;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.state_iowa); //must be first, or you will have null object problems
        MyAppApplication mApp = ((MyAppApplication)getApplicationContext()); //must be after, but in the onCreate, or you will have class cast and null exception problems

        ImageView stateFlag1 = (ImageView)findViewById(R.id.stateFlag);
        TextView department = (TextView)findViewById(R.id.department);
        TextView someData = (TextView)findViewById(R.id.somedata);
        Button states = (Button)findViewById(R.id.states);
        Button goButton = (Button)findViewById(R.id.goButton);
        Spinner hospitalSpinner = (Spinner)findViewById(R.id.hospitalSpinner);
        Resources resources = getResources();

        TextView hospitalID = (TextView)findViewById(R.id.hospitalID);
        Button direct = (Button)findViewById(R.id.directbutton);


        MyAppApplication mApps = ((MyAppApplication)getApplicationContext());
        stateSelect = mApp.getStateSelect();
        hospitalSelect = mApp.getHospitalSelect();
        //hospitalSelect = mApps.getHospitalSelect();


        super.onCreate(savedInstanceState);
        //everything above this is the default
        //default chart listed in the line immediately below this
        //imageView2.setImageResource(R.drawable.il_0924);

        if (stateSelect.equals("Alabama")) {
            stateFlag1.setImageResource(R.drawable.alabama);
            department.setText("https://www.alabamapublichealth.gov/index.html"); //test without it, appears as @string
            String s = initialize("AL.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Alaska")) {
            stateFlag1.setImageResource(R.drawable.alaska);
            department.setText("www.dhss.alaska.gov");
            String s = initialize("AK.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Arizona")) {
            stateFlag1.setImageResource(R.drawable.arizona);
            department.setText("https://azdhs.gov");
            String s = initialize("AZ.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Arkansas")) {
            stateFlag1.setImageResource(R.drawable.arkansas);
            department.setText("https://www.healthy.arkansas.gov");
            String s = initialize("AK.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("California")) {
            stateFlag1.setImageResource(R.drawable.california);
            department.setText("www.cdph.ca.gov");
            String s = initialize("CA.txt");
            someData.setText(s);
        }

        //keep going from here, also, why do only some pictures

        if (stateSelect.equals("Colorado")) {
            stateFlag1.setImageResource(R.drawable.colorado);
            department.setText("https://www.colorado.gov/cdphe");
            String s = initialize("CO.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Connecticut")) {
            stateFlag1.setImageResource(R.drawable.connecticut);
            department.setText("https://portal.ct.gov/DPH");
            String s = initialize("CT.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Delaware")) {
            stateFlag1.setImageResource(R.drawable.delaware);
            department.setText("https://dhss.delaware.gov/dhss");
            String s = initialize("DE.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Florida")) {
            stateFlag1.setImageResource(R.drawable.florida);
            department.setText("www.floridahealth.gov");
            String s = initialize("FL.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Georgia")) {
            stateFlag1.setImageResource(R.drawable.georgia);
            department.setText("https://dph.georgia.gov");
            String s = initialize("GA.txt");
            someData.setText(s);
        }
        //10

        if (stateSelect.equals("Hawaii")) {
            stateFlag1.setImageResource(R.drawable.hawaii);
            department.setText("https://health.hawaii.gov");
            String s = initialize("HI.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Idaho")) {
            stateFlag1.setImageResource(R.drawable.idaho);
            department.setText("https://healthandwelfare.idaho.gov");
            String s = initialize("ID.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Illinois")) {
            stateFlag1.setImageResource(R.drawable.illinois);
            department.setText("dph.illinois.gov");
            String s = initialize("IL.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Indiana")) {
            stateFlag1.setImageResource(R.drawable.indiana);
            department.setText("https://secure.in.gov/isdh");
            String s = initialize("IN.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Iowa")) {
                stateFlag1.setImageResource(R.drawable.iowa);
                department.setText("https://idph.iowa.gov");
                String s = initialize("IA.txt");
                someData.setText(s);
                addItemsOnSpinnerIowa();

        }

        //15

        if (stateSelect.equals("Kansas")) {
            stateFlag1.setImageResource(R.drawable.kansas);
            department.setText("https://www.kdheks.gov");
            String s = initialize("KS.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Kentucky")) {
            stateFlag1.setImageResource(R.drawable.kentucky);
            department.setText("https://chfs.ky.gov/agencies/dph");
            String s = initialize("KY.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Louisiana")) {
            stateFlag1.setImageResource(R.drawable.louisiana);
            department.setText("https://www.ldh.la.gov");
            String s = initialize("LA.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Maine")) {
            stateFlag1.setImageResource(R.drawable.maine);
            department.setText("https://www.maine.gov/dhhs");
            String s = initialize("ME.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Maryland")) {
            stateFlag1.setImageResource(R.drawable.maryland);
            department.setText("https://health.maryland.gov");
            String s = initialize("MD.txt");
            someData.setText(s);
        }
//20

        if (stateSelect.equals("Massachusetts")) {
            stateFlag1.setImageResource(R.drawable.massachusetts);
            department.setText("https://www.mass.gov/orgs/department-of-public-health");
            String s = initialize("MA.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Michigan")) {
            stateFlag1.setImageResource(R.drawable.michigan);
            department.setText("https://www.michigan.gov/mdhhs");
            String s = initialize("MI.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Minnesota")) {
            stateFlag1.setImageResource(R.drawable.minnesota);
            department.setText("https://www.health.state.mn.us");
            String s = initialize("MN.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Mississippi")) {
            stateFlag1.setImageResource(R.drawable.mississippi);
            department.setText("https://www.msdh.ms.gov");
            String s = initialize("MS.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Missouri")) {
            stateFlag1.setImageResource(R.drawable.missouri);
            department.setText("https://health.mo.gov/index.php");
            String s = initialize("MO.txt");
            someData.setText(s);
        }

//25
        if (stateSelect.equals("Montana")) {
            stateFlag1.setImageResource(R.drawable.montana);
            department.setText("https://dphhs.mt.gov");
            String s = initialize("MT.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Nebraska")) {
            stateFlag1.setImageResource(R.drawable.nebraska);
            department.setText("dhhs.ne.gov/Pages/default.aspx");
            String s = initialize("NE.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Nevada")) {
            stateFlag1.setImageResource(R.drawable.nevada);
            department.setText("dhhs.nv.gov");
            String s = initialize("NV.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("New Hampshire")) {
            stateFlag1.setImageResource(R.drawable.new_hampshire);
            department.setText("https://www.dhhs.nh.gov");
            String s = initialize("NH.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("New Jersey")) {
            stateFlag1.setImageResource(R.drawable.new_jersey);
            department.setText("https://www.nj.gov/health");
            String s = initialize("NJ.txt");
            someData.setText(s);
        }

//30
        if (stateSelect.equals("New Mexico")) {
            stateFlag1.setImageResource(R.drawable.new_mexico);
            department.setText("https://www.nmhealth.org");
            String s = initialize("NM.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("New York")) {
            stateFlag1.setImageResource(R.drawable.new_york);
            department.setText("https://www.health.ny.gov");
            String s = initialize("NY.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("North Carolina")) {
            stateFlag1.setImageResource(R.drawable.north_carolina);
            department.setText("https://www.ncdhhs.gov");
            String s = initialize("NC.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("North Dakota")) {
            stateFlag1.setImageResource(R.drawable.north_dakota);
            department.setText("https://www.health.nd.gov");
            String s = initialize("ND.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Ohio")) {
            stateFlag1.setImageResource(R.drawable.ohio);
            department.setText("https://odh.ohio.gov");
            String s = initialize("OH.txt");
            someData.setText(s);
        }

//35
        if (stateSelect.equals("Oklahoma")) {
            stateFlag1.setImageResource(R.drawable.oklahoma);
            department.setText("https://www.ok.gov/health");
            String s = initialize("OK.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Oregon")) {
            stateFlag1.setImageResource(R.drawable.oregon);
            department.setText("https://www.oregon.gov/oha/PH/Pages/index.aspx");
            String s = initialize("OR.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Pennsylvania")) {
            stateFlag1.setImageResource(R.drawable.pennsylvania);
            department.setText("https://www.health.pa.gov");
            String s = initialize("PA.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Rhode Island")) {
            stateFlag1.setImageResource(R.drawable.rhode_island);
            department.setText("https://health.ri.gov");
            String s = initialize("RI.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("South Carolina")) {
            stateFlag1.setImageResource(R.drawable.south_carolina);
            department.setText("https://scdhec.gov");
            String s = initialize("SC.txt");
            someData.setText(s);
        }
//40
        if (stateSelect.equals("South Dakota")) {
            stateFlag1.setImageResource(R.drawable.south_dakota);
            department.setText("https://doh.sd.gov");
            String s = initialize("SD.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Tennessee")) {
            stateFlag1.setImageResource(R.drawable.tennessee);
            department.setText("https://www.tn.gov/health.html");
            String s = initialize("TN.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Texas")) {
            stateFlag1.setImageResource(R.drawable.texas);
            department.setText("https://dshs.texas.gov");
            String s = initialize("TX.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Utah")) {
            stateFlag1.setImageResource(R.drawable.utah);
            department.setText("https://health.utah.gov");
            String s = initialize("UT.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Vermont")) {
            stateFlag1.setImageResource(R.drawable.vermont);
            department.setText("https://www.healthvermont.gov"); //keep the new line just to test it or not
            String s = initialize("VT.txt");
            someData.setText(s);
        }

//45
        if (stateSelect.equals("Virginia")) {
            stateFlag1.setImageResource(R.drawable.virginia);
            department.setText("https://www.vdh.virginia.gov");
            String s = initialize("VA.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Washington")) {
            stateFlag1.setImageResource(R.drawable.washington);
            department.setText("https://www.doh.wa.gov");
            String s = initialize("WA.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("West Virginia")) {
            stateFlag1.setImageResource(R.drawable.west_virginia);
            department.setText("https://dhhr.wv.gov");
            String s = initialize("WV.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Wisconsin")) {
            stateFlag1.setImageResource(R.drawable.wisconsin);
            department.setText("https://www.dhs.wisconsin.gov");
            String s = initialize("WI.txt");
            someData.setText(s);
        }

        if (stateSelect.equals("Wyoming")) {
            stateFlag1.setImageResource(R.drawable.wyoming);
            department.setText("https://health.wyo.gov");
            String s = initialize("WY.txt");
            someData.setText(s);
        }


        //50
        //add more if needed
        //the line above this sets the content view to the activity_login file

        states.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(State_Iowa.this, HospitalList.class);
                startActivity(intent);
                finish();
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
                if (hospitalSpinner.getItemAtPosition(hospitalSpinner.getSelectedItemPosition()).toString().contains("Ames: Mary Greeley Medical: ID ")) {
                    mApp.setHospitalSelect(4977); //corresponds with the appropriate FID
                }

                else if (hospitalSpinner.getItemAtPosition(hospitalSpinner.getSelectedItemPosition()).toString().contains("Ames: Mary Greeley Medical: ID ")) {
                    mApp.setHospitalSelect(4977); //corresponds with the appropriate FID
                }

                else if (hospitalSpinner.getItemAtPosition(hospitalSpinner.getSelectedItemPosition()).toString().contains("Ames: Mary Greeley Medical: ID ")) {
                    mApp.setHospitalSelect(4977); //corresponds with the appropriate FID
                }

                else if (hospitalSpinner.getItemAtPosition(hospitalSpinner.getSelectedItemPosition()).toString().contains("Ames: Mary Greeley Medical: ID ")) {
                    mApp.setHospitalSelect(4977); //corresponds with the appropriate FID
                }

                else if (hospitalSpinner.getItemAtPosition(hospitalSpinner.getSelectedItemPosition()).toString().contains("Ames: Mary Greeley Medical: ID ")) {
                    mApp.setHospitalSelect(4977); //corresponds with the appropriate FID
                }




                Intent intent = new Intent(State_Iowa.this, UserInventory.class);
                startActivity(intent);
                finish();
            }
        });

        direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();

                hospitalIDs = hospitalID.getText().toString();

                mApp.setHospitalSelect(Integer.parseInt(hospitalIDs));


                Intent intent = new Intent(State_Iowa.this, UserInventory.class);
                startActivity(intent);
                finish();
            }
        });







    }

    /**
     * method to initialize the covid data for each state by referencing the applicable text files created by the python script
     * @param string
     * @return
     */
    public String initialize(String string) {
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(string)));
            ArrayList<String> strings = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }

            String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
            double zero = Double.parseDouble(strings.get(0)) * 100;
            double one = Double.parseDouble(strings.get(1)) * 100;
            double two = Double.parseDouble(strings.get(2)) * 100;
            //double five = Double.parseDouble(strings.get(5)) * 100;
            post += "Inpatient beds utilization %:                    " + zero + "%\n";
            post += "% of Inpatients with Covid  :                    " + one + "%\n";
            post += "Adult ICU bed utilization % :                    " + two + "%\n";
            post += "Adult patients hospitalized with covid:      " + strings.get(3) + " patients\n";
            post += "Pediatric patients hospitalized with covid: " + strings.get(4) + " patients\n";
            //post += "Adult ICU beds with covid patients:         " + strings.get(5) + "%\n"; //can replace with 5
            //someData.setText(post);
            return post;
        } catch (IOException ignored) {}
        return "no data available";
    }

    /**
     * add unique hospital names for each individual state
     */
    public void addItemsOnSpinnerIowa() {
        hospitalSpinner = (Spinner) findViewById(R.id.hospitalSpinner);
        List<String> list = new ArrayList<String>();
        list.add("Ames: Mary Greeley Medical: ID 4977");
        list.add("Cedar Rapids: Mercy Medical : ID ");
        list.add("Davenport: Genesis Medical C: ID ");
        list.add("Des Moines: Iowa Methodist M: ID ");
        list.add("West Burlington: Great River: ID "); //5

        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add(""); //10

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hospitalSpinner.setAdapter(dataAdapter);
    }

    /**
     * jsonParse to receive data from the server
     */
    public void jsonParse() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://coms-309-rp-02.cs.iastate.edu:8080/hospitallists";
        JsonArrayRequest req= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                store = response.toString();//.substring();
                substore = store.substring(2, 20);
//                substore = store.split("},");

                Log.d("success(login)", store);
                Log.d("success(substring)", substore);
                //   Log.d("success", String.valueOf(store.contains("djking@iastate.edu"))); //check if it contains what we needs
                //startActivity(intent);
                //also need to specify the ID
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
