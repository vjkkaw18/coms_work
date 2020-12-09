package com.example.helloworld;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TestClassForMock {
    public int add (int number1, int number2) {
        return (number1 + number2);
    }

   // public boolean isEmail

    public boolean isEmail(String s) {
        CharSequence email = s.toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean loginSuccessfulMock(String login, String password) {
        String l = "test@gmail.com";
        String p = "password12345";
        return (login.equals(1) && password.equals(p));
    }

    public boolean addItemsOnSpinner() {
        Spinner spinner;
       // spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Alabama");
        list.add("Alaska");
        list.add("Arizona");
        list.add("Arkansas");
        list.add("California"); //5

      //  ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
      //  dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //  spinner.setAdapter(dataAdapter);
        return list.contains("Alaska") && list.contains("Californiaa");
    }

    }
