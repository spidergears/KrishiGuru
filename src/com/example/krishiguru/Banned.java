package com.example.krishiguru;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.example.krishiguru.R;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class Banned extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		ArrayList<HashMap<String, String>> BanList = new ArrayList<HashMap<String, String>>();
    	
		String response = null;
    	
    	try {
    				response= CustomHttpClient.executeHttpGet("http://203.199.146.117/getbanpesti.php");	
            	    response=response.toString();
            	    response = response.trim();
            	    JSONArray obj=(JSONArray) new JSONTokener(response).nextValue();
            	    for(int i = 0; i < obj.length(); i++){
        				JSONObject c = obj.getJSONObject(i);
        				String name = c.getString("name");
        				
        				HashMap<String, String> map = new HashMap<String, String>();
        				
        				map.put("name", name);
        				BanList.add(map);
            	    }
			}
    		catch (Exception e) {
    		Log.e("Exception Occured","An Error has occured fetching data");
    	}
    	
		ListAdapter adapter = new SimpleAdapter(this, BanList,
				R.layout.list_item,
				new String[] { "name" }, new int[] {
						R.id.name });

		setListAdapter(adapter);
	}
}
