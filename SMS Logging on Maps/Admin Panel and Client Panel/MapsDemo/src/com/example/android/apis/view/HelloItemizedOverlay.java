package com.example.android.apis.view;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class HelloItemizedOverlay extends ItemizedOverlay{
	private ArrayList<OverlayItem> mOverlays; 
	private Context mContext;
	public HelloItemizedOverlay(Drawable defaultMarker,Context context) {
		super(boundCenterBottom(defaultMarker));
		mOverlays= new ArrayList<OverlayItem>();
		mContext = context;
		
       
		// TODO Auto-generated constructor stub
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}
	public void addOverlay(OverlayItem overlay) {
	    mOverlays.add(overlay);
	    populate();
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = mOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.show();
	  return true;
	}
}
