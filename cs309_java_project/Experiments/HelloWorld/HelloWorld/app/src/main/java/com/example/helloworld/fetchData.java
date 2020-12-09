package com.example.helloworld;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * a fetch data method that can be used to parse an object in the background. Used with the old login page. Not currently in use
 */
public class fetchData extends AsyncTask<String,Void,String> {

    String data = "";   //whole JSON file in the data
    String dataParsed = "";
    String singleParsed = "";

    @Override
    protected String doInBackground(String... params) {
        String s = params[0];
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL("http://coms-309-rp-02.cs.iastate.edu:8080/logins");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream(); //to read data
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String data = "";
            String line = "";
            for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                data = data + line;
            }
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "firstName:" + JO.get("first name") +
                                "lastName:" + JO.get("last name") +
                                "Email:" + JO.get("email") +
                                "Password:" + JO.get("password");

                dataParsed = dataParsed + singleParsed;
            }

            bufferedReader.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}

