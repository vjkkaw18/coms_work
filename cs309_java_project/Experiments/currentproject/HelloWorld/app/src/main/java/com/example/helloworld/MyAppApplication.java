package com.example.helloworld;

import android.app.Application;

public class MyAppApplication extends Application {
    private String stateSelect;

    public String getStateSelect() {
        return stateSelect;
    }
    public void setStateSelect(String string) {
        stateSelect = string;
    }

}
