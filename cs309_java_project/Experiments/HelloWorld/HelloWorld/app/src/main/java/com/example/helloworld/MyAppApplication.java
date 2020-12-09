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

  //  private String hospitalSelect;

    //public String getHospitalSelect() { return hospitalSelect;}
    //public void setHospitalSelect(String string) { hospitalSelect = string;}

    private int hospitalSelect;

    public int getHospitalSelect() {
        return hospitalSelect;
    }
    public void setHospitalSelect(int integer) {
        hospitalSelect = integer;
    }


    private String hospitalName;

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String string) { hospitalName = string; }



    public String websiteURL;

    public String getWebsiteURL() { return websiteURL; }
    public void setWebsiteURL(String string) { websiteURL = string; }

}
