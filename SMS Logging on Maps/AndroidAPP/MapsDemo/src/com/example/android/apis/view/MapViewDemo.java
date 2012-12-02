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

import android.graphics.drawable.Drawable;
import android.os.Bundle;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable, this);
        GeoPoint point = new GeoPoint(3138, 7294);
        OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
        itemizedoverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedoverlay);
        
    }

    @Override
    protected boolean isRouteDisplayed() { return false; }
}
