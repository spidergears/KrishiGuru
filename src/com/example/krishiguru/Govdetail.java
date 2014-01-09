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

public class Govdetail  extends Activity {
	TextView name_label,descrip_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_gov);
        name_label=(TextView)findViewById(R.id.name_label);
        descrip_label=(TextView)findViewById(R.id.descrip_label);
        Intent in = getIntent();
        String vari = in.getStringExtra("TAG_VARI");
       
        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
   		postParameters.add(new BasicNameValuePair("name", vari));
   	
		String response = null;
		String res;
		try {
			
			response = CustomHttpClient.executeHttpPost("http://203.199.146.117/getnewgovpol.php", postParameters);
			res=response.toString();
           res = res.trim();
           JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
                    String name=obj.getString("name");
       				String descrip= obj.getString("descrip");
       			TextView lblname=(TextView) findViewById(R.id.name_label);
       	       TextView lbldescrip = (TextView) findViewById(R.id.descrip_label);
       	        lblname.setText(name);
       	       lbldescrip.setText(descrip);
       		}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   	} 	
    }
}
