package com.example.helloworld;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;

import com.google.android.gms.maps.SupportMapFragment;

public class Arcgis extends AppCompatActivity {

    private MapView mapView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arcgis_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapView1 = findViewById(R.id.mapView);
       // ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 34.056295, -117.195800, 16);
       // mapView1.setMap(map);
        //https://djking.maps.arcgis.com/home/webmap/viewer.html?webmap=23ccaaaefc4a414f9f9a247d927965eb
        ArcGISMap map = new ArcGISMap("https://www.arcgis.com/home/webmap/viewer.html?webmap=23ccaaaefc4a414f9f9a247d927965eb");
        mapView1.setMap(map);

    }

    @Override
    protected void onPause(){
        mapView1.pause();
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mapView1.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView1.dispose();
    }
}
