package com.example.krishiguru;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.example.krishiguru.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Retaildetail  extends Activity {
	TextView name_label,contact_label,address_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_retail);
        name_label=(TextView)findViewById(R.id.name_label);
        address_label=(TextView)findViewById(R.id.address_label);
        contact_label=(TextView)findViewById(R.id.contact_label);
        Intent in = getIntent();
       String city = in.getStringExtra("TAG_CITY");
       String vari = in.getStringExtra("TAG_VARI");
       
       ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
   		postParameters.add(new BasicNameValuePair("Name", vari));
   		postParameters.add(new BasicNameValuePair("City",city));
   	
		String response = null;
		String res;
		try {
			
			response = CustomHttpClient.executeHttpPost("http://server-ip/getretaildetail.php", postParameters);
			res=response.toString();
           res = res.trim();
           JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
                    String name=obj.getString("name");
       				String address= obj.getString("address");
       				String contact= obj.getString("contact");
       	        name_label.setText(name);
       	       address_label.setText(address);
       	     	contact_label.setText(contact);
			}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   	} 	
    }
}
