package com.example.helloworld;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Enables the hospital webpages, with the unique hospital URL
 */
public class HospitalWebpageActivity extends AppCompatActivity {

    private WebView mWebview;
    Activity activity;
    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_pages);

        MyAppApplication myApp = new MyAppApplication();
       // MyAppApplication myApp = new MyAppApplication();
    //    String string = myApp2.getWebsiteURL();
        String string;
        string = myApp.getWebsiteURL();
        activity = this;
        mWebview = (WebView)findViewById(R.id.webView1);

        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.getSettings().setLoadWithOverviewMode(true);
        //



       // mWebview = new WebView(this);
        mWebview.getSettings().setJavaScriptEnabled(true);
       // final Activity activity = this;
        mWebview.setWebViewClient(new WebViewClient() {




        });

       // mWebview.setWebViewClient(new WebViewClient() {

         //   @Override
       //     public void onError(WebView view, int error, String des, String failurl) {
        //        Toast.makeText(activity, des, Toast.LENGTH_SHORT).show();
        //    }

         //   @TargetApi(android.os.Build.VERSION_CODES.M)

      //  });



        string = "http://www.mgmc.org";
        Log.d("website url", string);
          mWebview.loadUrl(string);
       // mWebview.loadUrl("http://google.com");
      //  mWebview.loadUrl("http://www.mgmc.org");
     //   setContentView(mWebview);


    }
}
