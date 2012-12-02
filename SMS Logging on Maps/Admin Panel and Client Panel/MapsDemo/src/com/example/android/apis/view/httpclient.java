package com.example.android.apis.view;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class httpclient {
	// Create a new HttpClient and Post Header
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://pakuniinfo.com/nomi/yo/s.php");
    void method(String lat, String lng,String name, String cnic,String complaint)
     {
    try {
        // Add your data
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
        nameValuePairs.add(new BasicNameValuePair("name", name));
        nameValuePairs.add(new BasicNameValuePair("cnic", cnic));
        nameValuePairs.add(new BasicNameValuePair("complaint", complaint));
        nameValuePairs.add(new BasicNameValuePair("longitude", lng));
        nameValuePairs.add(new BasicNameValuePair("latitude", lat));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        // Execute HTTP Post Request
        HttpResponse response = httpclient.execute(httppost);
        

    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
    } catch (IOException e) {
    	System.out.println(e.toString());        // TODO Auto-generated catch block
    }
}
}
