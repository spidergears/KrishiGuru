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

public class certdetail  extends Activity {
	TextView name_label,email_label,mobile_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        name_label=(TextView)findViewById(R.id.name_label);
        email_label=(TextView)findViewById(R.id.email_label);
        mobile_label=(TextView)findViewById(R.id.mobile_label);
        
        Intent in = getIntent();
       String vari = in.getStringExtra("TAG_VARI");
      
       ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
   		postParameters.add(new BasicNameValuePair("name", vari));
   	
		String response = null;
		String res;
		try {
			
			response = CustomHttpClient.executeHttpPost("http://server-ip/getnewcert.php", postParameters);
			res=response.toString();
           res = res.trim();
           JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
                    String name=obj.getString("name");
       				String conperson = obj.getString("con_person");
       				String address= obj.getString("address").toUpperCase();
       				String phone= obj.getString("phone").toUpperCase();
       				String email= obj.getString("email").toUpperCase();
       				String fax= obj.getString("fax").toUpperCase();
       			TextView lblname=(TextView) findViewById(R.id.name_label);
       			TextView lblmail = (TextView) findViewById(R.id.email_label);
       	        TextView lblphone = (TextView) findViewById(R.id.mobile_label);
       	        TextView lblconperson = (TextView) findViewById(R.id.conperson_label);
       	        TextView lblfax = (TextView) findViewById(R.id.fax_label);
 	        
       	     lblname.setText(name);
       	     lblmail.setText(email);
       	     lblphone.setText(phone);
       	     lblconperson.setText(conperson);
       	     lblfax.setText(fax);
       		}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   		} 
    }
}
