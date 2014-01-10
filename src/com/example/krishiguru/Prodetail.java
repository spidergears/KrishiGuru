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

public class Prodetail  extends Activity {
	TextView name_label,composition_label,category_label,descrip_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_rec);
        name_label=(TextView)findViewById(R.id.name_label);
        composition_label=(TextView)findViewById(R.id.composition_label);
        category_label=(TextView)findViewById(R.id.category_label);
        descrip_label=(TextView)findViewById(R.id.descrip_label);
        Intent in = getIntent();
       String vari = in.getStringExtra("TAG_VARI");
       ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
   		postParameters.add(new BasicNameValuePair("name", vari));
   	
		String response = null;
		String res;
		try {
			
			response = CustomHttpClient.executeHttpPost("http://server-ip/getnewrecpro.php", postParameters);
			res=response.toString();
           res = res.trim();
           JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
                    String name=obj.getString("name");
       				String composition= obj.getString("composition");
       				String category= obj.getString("category");
       				String descrip= obj.getString("descrip");
       	        name_label.setText(name);
       	       composition_label.setText(composition);
       	     	category_label.setText(category);
       	     	descrip_label.setText(descrip);
			}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   	} 	
    }
}
