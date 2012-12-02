package com.example.android.apis.view;



import com.example.android.google.apis.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Complaint extends Activity{
	String Longitude;
	String Latitude;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.compliantview);
	        Bundle extras = getIntent().getExtras();
	        if(extras != null)
	        {
	        	Longitude = extras.getString("Longitude");
	        	Latitude = extras.getString("Latitude");
	        	Button submit = (Button)findViewById(R.id.buttonSubmit);
	            
	            submit.setOnClickListener(new OnClickListener() {

	                @Override
	                public void onClick(View v) 
	                {
	                	httpclient client = new httpclient();
	                	EditText etext = (EditText) findViewById(R.id.editText1);
	                	EditText etext2 = (EditText) findViewById(R.id.editText2);
	                	EditText etext3 = (EditText) findViewById(R.id.editText3);
	                	
	                	
	                	client.method(Latitude,Longitude,etext.getText().toString(), etext.getText().toString(),etext2.getText().toString());
	                	
	                	
	                	
	                }
	            });
	        	
	        }
	        
	 }
    

}
