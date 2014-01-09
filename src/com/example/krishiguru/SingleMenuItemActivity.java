package com.example.krishiguru;



import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.example.krishiguru.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
public class SingleMenuItemActivity  extends ListActivity {
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        Intent in = getIntent();
        String name = in.getStringExtra("name");
        ArrayList<HashMap<String, String>> BankList = new ArrayList<HashMap<String, String>>();
		String response = null;
		
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
    	postParameters.add(new BasicNameValuePair("name", name));
		try {
    		response = CustomHttpClient.executeHttpPost("http://192.168.190.197/getmsp.php", postParameters);
            response=response.toString();
            response = response.trim();
            	    
            	    JSONArray obj=(JSONArray) new JSONTokener(response).nextValue();
            	    for(int i = 0; i < obj.length(); i++){
        				JSONObject c = obj.getJSONObject(i);
        				String bankname = c.getString("name");
        				String bankPolicy=c.getString("policies");
        				
        				HashMap<String, String> map = new HashMap<String, String>();
        				map.put("name", name);
        				map.put("policyname",bankPolicy);
        				BankList.add(map);
            	    }
			}
    		catch (Exception e) {
    		Log.e("Exception Occured","An Error has occured fetching data");
    		Toast.makeText(this.getBaseContext(),"Network Activity Failed. Check Connectivity",Toast.LENGTH_SHORT).show();
    	} 	
		ListAdapter adapter = new SimpleAdapter(this, BankList,
				R.layout.list_item,
				new String[] { "name" }, new int[] {
						R.id.name });

		setListAdapter(adapter);	
    }
}
