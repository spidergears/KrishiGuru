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

public class Bankdetail  extends Activity {
	TextView name_label,policy_label,web_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_bank);
        name_label=(TextView)findViewById(R.id.name_label);
        policy_label=(TextView)findViewById(R.id.policy_label);
        web_label=(TextView)findViewById(R.id.web_label);
        
       Intent in = getIntent();
        
        // Get JSON values from previous intent
       String vari = in.getStringExtra("TAG_VARI");
       
       ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
   		postParameters.add(new BasicNameValuePair("name", vari));
   	
		String response = null;
		String res;
		try {
			
			response = CustomHttpClient.executeHttpPost("http://server-ip/getnewbank.php", postParameters);
			res=response.toString();
			res = res.trim();
            JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
            String name=obj.getString("name");
            String policies= obj.getString("policies");
       		String web= obj.getString("web");
       		TextView lblname=(TextView) findViewById(R.id.name_label);
       	    TextView lblpolicy = (TextView) findViewById(R.id.policy_label);
       	    TextView lblweb = (TextView) findViewById(R.id.web_label);
       	        lblname.setText(name);
       	        lblpolicy.setText(policies);
       	        lblweb.setText(web);
       	    }
   		catch (Exception e) {
   		} 	
    }
}
