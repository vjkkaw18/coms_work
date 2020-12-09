package com.example.helloworld;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Implements and enables a covid assessment activity for users
 */
public class CovidAssessmentActivity extends AppCompatActivity {

    private WebView webpage;
    Activity activity;
    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covidassessment);

       // MyAppApplication myApp = new MyAppApplication();
        // MyAppApplication myApp = new MyAppApplication();
        //    String string = myApp2.getWebsiteURL();
      //  String string;
       // string = myApp.getWebsiteURL();
        activity = this;
        webpage = (WebView)findViewById(R.id.webpage);

        webpage.getSettings().setJavaScriptEnabled(true);
        webpage.getSettings().setLoadWithOverviewMode(true);
        //



        // mWebview = new WebView(this);
        webpage.getSettings().setJavaScriptEnabled(true);
        // final Activity activity = this;
        webpage.setWebViewClient(new WebViewClient() {




        });

        // mWebview.setWebViewClient(new WebViewClient() {

        //   @Override
        //     public void onError(WebView view, int error, String des, String failurl) {
        //        Toast.makeText(activity, des, Toast.LENGTH_SHORT).show();
        //    }

        //   @TargetApi(android.os.Build.VERSION_CODES.M)

        //  });

        webpage.loadUrl("https://www.mayoclinic.org/covid-19-self-assessment-tool");
        // mWebview.loadUrl("http://google.com");
        //  mWebview.loadUrl("http://www.mgmc.org");
        //   setContentView(mWebview);


    }
}
