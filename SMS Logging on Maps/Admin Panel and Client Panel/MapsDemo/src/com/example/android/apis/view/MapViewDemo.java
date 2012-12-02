/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.apis.view;

import java.util.List;

import com.example.android.google.apis.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Example of how to use an {@link com.google.android.maps.MapView}.
 * <h3>MapViewDemo</h3>

<p>This demonstrates creating a Map based Activity.</p>

<h4>Demo</h4>
Views/MapView

<h4>Source files</h4>
 * <table class="LinkTable">
 *         <tr>
 *             <td >src/com.example.android.apis/view/MapViewDemo.java</td>
 *             <td >The Alert Dialog Samples implementation</td>
 *         </tr>
 *         <tr>
 *             <td >/res/layout/mapview.xml</td>
 *             <td >Defines contents of the screen</td>
 *         </tr>
 * </table>
 */
public class MapViewDemo extends MapActivity {
	int lat;
    int lng ;  

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable, this);
        
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
       
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        TextView txt = (TextView) findViewById(R.id.TextView02);        
        TextView txt1 = (TextView) findViewById(R.id.TextView04);
        lat = (int) (location.getLatitude() * 1E6);
        lng = (int) (location.getLongitude() * 1E6);  
        txt.setText(""+lat);
        txt1.setText(""+lng);
        
        GeoPoint point = new GeoPoint(lat , lng);
        OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
        itemizedoverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedoverlay);
        Button submit = (Button)findViewById(R.id.buttonProceed);
        
        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) 
            {
            	Intent i = new Intent(MapViewDemo.this, Complaint.class);
            	i.putExtra("Latitude", lat+"" );
            	i.putExtra("Longitude", lng+"" );
            	startActivity(i); 
            	
            	
            	
            }
        });
    }

    @Override
    protected boolean isRouteDisplayed() { return false; }
}
