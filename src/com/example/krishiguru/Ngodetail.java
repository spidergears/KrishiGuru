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

public class Ngodetail  extends Activity {
	TextView name_label,address_label,web_label,phone_label,mobile_label,email_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_ngo);
        name_label=(TextView)findViewById(R.id.name_label);
       address_label=(TextView)findViewById(R.id.address_label);
        web_label=(TextView)findViewById(R.id.web_label);
        phone_label=(TextView)findViewById(R.id.phno_label);
        mobile_label=(TextView)findViewById(R.id.mobile_label);
        email_label=(TextView)findViewById(R.id.email_label);
        
        Intent in = getIntent();
        String vari = in.getStringExtra("TAG_VARI");
       
       ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
   		postParameters.add(new BasicNameValuePair("name", vari));
   	
		String response = null;
		String res;
		try {
			
			response = CustomHttpClient.executeHttpPost("http://server-ip/getnewngo.php", postParameters);
			res=response.toString();
           res = res.trim();
           JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
                    String name=obj.getString("name");
       				String address= obj.getString("address");
       				String web= obj.getString("web");
       				String phone= obj.getString("phone");
       				String mobile= obj.getString("mobile");
       				String email= obj.getString("email");
       			TextView lblname=(TextView) findViewById(R.id.name_label);
       	       TextView lbladdress = (TextView) findViewById(R.id.address_label);
       	        TextView lblweb = (TextView) findViewById(R.id.web_label);
       	     TextView lblphone = (TextView) findViewById(R.id.phno_label);
       	  TextView lblmobile = (TextView) findViewById(R.id.mobile_label);
       	TextView lblemail = (TextView) findViewById(R.id.email_label);
       	        lblname.setText(name);
       	        lbladdress.setText(address);
       	        lblweb.setText(web);
       	        lblphone.setText(phone);
       	        lblmobile.setText(mobile);
       	        lblemail.setText(email);
       		}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   	} 	
    }
}
