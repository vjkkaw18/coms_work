package com.example.helloworld;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class State_Iowa extends AppCompatActivity {
    private ImageView stateFlag1; //state flag
    private ImageView imageView2; //graph of the state
    private String stateSelect;
    private TextView department;
    private TextView someData;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.state_iowa); //must be first, or you will have null object problems
        MyAppApplication mApp = ((MyAppApplication)getApplicationContext()); //must be after, but in the onCreate, or you will have class cast and null exception problems
        ImageView stateFlag1 = (ImageView)findViewById(R.id.stateFlag);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
        TextView department = (TextView)findViewById(R.id.department);
        TextView someData = (TextView)findViewById(R.id.somedata);
        Resources resources = getResources();
        BufferedReader reader = null;

        stateSelect = mApp.getStateSelect();

        super.onCreate(savedInstanceState);
        //everything above this is the default
        //default chart listed in the line immediately below this
        imageView2.setImageResource(R.drawable.il_0924);

        if (stateSelect.equals("Alabama")) {
            stateFlag1.setImageResource(R.drawable.alabama);
            department.setText("https://www.alabamapublichealth.gov/index.html"); //test without it, appears as @string
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("AL.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }

        if (stateSelect.equals("Alaska")) {
            stateFlag1.setImageResource(R.drawable.alaska);
            department.setText("www.dhss.alaska.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("AK.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }

        if (stateSelect.equals("Arizona")) {
            stateFlag1.setImageResource(R.drawable.arizona);
            department.setText("https://azdhs.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("AZ.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }

        if (stateSelect.equals("Arkansas")) {
            stateFlag1.setImageResource(R.drawable.arkansas);
            department.setText("https://www.healthy.arkansas.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("AR.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }

        if (stateSelect.equals("California")) {
            stateFlag1.setImageResource(R.drawable.california);
            department.setText("www.cdph.ca.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("CA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
    //5
        //keep going from here, also, why do only some pictures
        if (stateSelect.equals("Colorado")) {
            stateFlag1.setImageResource(R.drawable.colorado);
            department.setText("https://www.colorado.gov/cdphe");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("CO.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Connecticut")) {
            stateFlag1.setImageResource(R.drawable.connecticut);
            department.setText("https://portal.ct.gov/DPH");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("CT.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Delaware")) {
            stateFlag1.setImageResource(R.drawable.delaware);
            department.setText("https://dhss.delaware.gov/dhss");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("DE.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Florida")) {
            stateFlag1.setImageResource(R.drawable.florida);
            department.setText("www.floridahealth.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("FL.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Georgia")) {
            stateFlag1.setImageResource(R.drawable.georgia);
            department.setText("https://dph.georgia.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("GA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        //10
        if (stateSelect.equals("Hawaii")) {
            stateFlag1.setImageResource(R.drawable.hawaii);
            department.setText("https://health.hawaii.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("HI.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Idaho")) {
            stateFlag1.setImageResource(R.drawable.idaho);
            department.setText("https://healthandwelfare.idaho.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("ID.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Illinois")) {
            stateFlag1.setImageResource(R.drawable.illinois);
            department.setText("dph.illinois.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("IL.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Indiana")) {
            stateFlag1.setImageResource(R.drawable.indiana);
            department.setText("https://secure.in.gov/isdh");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("IN.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Iowa")) {
            stateFlag1.setImageResource(R.drawable.iowa);
            department.setText("https://idph.iowa.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("IA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        //15
        if (stateSelect.equals("Kansas")) {
            stateFlag1.setImageResource(R.drawable.kansas);
            department.setText("https://www.kdheks.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("KS.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Kentucky")) {
            stateFlag1.setImageResource(R.drawable.kentucky);
            department.setText("https://chfs.ky.gov/agencies/dph");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("KY.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Louisiana")) {
            stateFlag1.setImageResource(R.drawable.louisiana);
            department.setText("https://www.ldh.la.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("LA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Maine")) {
            stateFlag1.setImageResource(R.drawable.maine);
            department.setText("https://www.maine.gov/dhhs");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("ME.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Maryland")) {
            stateFlag1.setImageResource(R.drawable.maryland);
            department.setText("https://health.maryland.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("MD.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
//20
        if (stateSelect.equals("Massachusetts")) {
            stateFlag1.setImageResource(R.drawable.massachusetts);
            department.setText("https://www.mass.gov/orgs/department-of-public-health");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("MA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Michigan")) {
            stateFlag1.setImageResource(R.drawable.michigan);
            department.setText("https://www.michigan.gov/mdhhs");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("MI.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Minnesota")) {
            stateFlag1.setImageResource(R.drawable.minnesota);
            department.setText("https://www.health.state.mn.us");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("MN.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Mississippi")) {
            stateFlag1.setImageResource(R.drawable.mississippi);
            department.setText("https://www.msdh.ms.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("MS.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Missouri")) {
            stateFlag1.setImageResource(R.drawable.missouri);
            department.setText("https://health.mo.gov/index.php");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("MO.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
//25
        if (stateSelect.equals("Montana")) {
            stateFlag1.setImageResource(R.drawable.montana);
            department.setText("https://dphhs.mt.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("MT.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Nebraska")) {
            stateFlag1.setImageResource(R.drawable.nebraska);
            department.setText("dhhs.ne.gov/Pages/default.aspx");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("NE.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Nevada")) {
            stateFlag1.setImageResource(R.drawable.nevada);
            department.setText("dhhs.nv.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("NV.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("New Hampshire")) {
            stateFlag1.setImageResource(R.drawable.new_hampshire);
            department.setText("https://www.dhhs.nh.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("NH.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("New Jersey")) {
            stateFlag1.setImageResource(R.drawable.new_jersey);
            department.setText("https://www.nj.gov/health");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("NJ.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
//30
        if (stateSelect.equals("New Mexico")) {
            stateFlag1.setImageResource(R.drawable.new_mexico);
            department.setText("https://www.nmhealth.org");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("NM.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("New York")) {
            stateFlag1.setImageResource(R.drawable.new_york);
            department.setText("https://www.health.ny.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("NY.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("North Carolina")) {
            stateFlag1.setImageResource(R.drawable.north_carolina);
            department.setText("https://www.ncdhhs.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("NC.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("North Dakota")) {
            stateFlag1.setImageResource(R.drawable.north_dakota);
            department.setText("https://www.health.nd.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("ND.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Ohio")) {
            stateFlag1.setImageResource(R.drawable.ohio);
            department.setText("https://odh.ohio.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("OH.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
//35
        if (stateSelect.equals("Oklahoma")) {
            stateFlag1.setImageResource(R.drawable.oklahoma);
            department.setText("https://www.ok.gov/health");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("OK.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Oregon")) {
            stateFlag1.setImageResource(R.drawable.oregon);
            department.setText("https://www.oregon.gov/oha/PH/Pages/index.aspx");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("OR.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }



        if (stateSelect.equals("Pennsylvania")) {
            stateFlag1.setImageResource(R.drawable.pennsylvania);
            department.setText("https://www.health.pa.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("PA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }



        if (stateSelect.equals("Rhode Island")) {
            stateFlag1.setImageResource(R.drawable.rhode_island);
            department.setText("https://health.ri.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("RI.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("South Carolina")) {
            stateFlag1.setImageResource(R.drawable.south_carolina);
            department.setText("https://scdhec.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("SC.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
//40
        if (stateSelect.equals("South Dakota")) {
            stateFlag1.setImageResource(R.drawable.south_dakota);
            department.setText("https://doh.sd.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("SD.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Tennessee")) {
            stateFlag1.setImageResource(R.drawable.tennessee);
            department.setText("https://www.tn.gov/health.html");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("TN.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Texas")) {
            stateFlag1.setImageResource(R.drawable.texas);
            department.setText("https://dshs.texas.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("TX.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Utah")) {
            stateFlag1.setImageResource(R.drawable.utah);
            department.setText("https://health.utah.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("UT.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Vermont")) {
            stateFlag1.setImageResource(R.drawable.vermont);
            department.setText("https://www.healthvermont.gov"); //keep the new line just to test it or not
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("VT.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
//45
        if (stateSelect.equals("Virginia")) {
            stateFlag1.setImageResource(R.drawable.virginia);
            department.setText("https://www.vdh.virginia.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("VA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Washington")) {
            stateFlag1.setImageResource(R.drawable.washington);
            department.setText("https://www.doh.wa.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("WA.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("West Virginia")) {
            stateFlag1.setImageResource(R.drawable.west_virginia);
            department.setText("https://dhhr.wv.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("WV.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Wisconsin")) {
            stateFlag1.setImageResource(R.drawable.wisconsin);
            department.setText("https://www.dhs.wisconsin.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("WI.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        if (stateSelect.equals("Wyoming")) {
            stateFlag1.setImageResource(R.drawable.wyoming);
            department.setText("https://health.wyo.gov");
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("WY.txt")));
                String line = "";
                ArrayList<String> strings = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }

                String inpatient_beds_utilization, percent_of_inpatients_covid, adult_icu_bed, total_adult_patients, total_pediatric_patients, adult_icu_bed_covid;
                String post = "";
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
                someData.setText(post);
            } catch (IOException ignored) {}
        }
        //50
                //add more if needed
        //the line above this sets the content view to the activity_login file


    }
}
