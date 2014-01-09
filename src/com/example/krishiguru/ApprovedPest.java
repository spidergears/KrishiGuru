package com.example.krishiguru;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.example.krishiguru.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class ApprovedPest extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		ArrayList<HashMap<String, String>> PestList = new ArrayList<HashMap<String, String>>();
		String response = null;
		try {
    		response= CustomHttpClient.executeHttpGet("http://203.199.146.117/getallowpesti.php");	
            response=response.toString();
            response = response.trim();
            response= response.replaceAll("\\s+","");		            	    
            	    
            	    JSONArray obj=(JSONArray) new JSONTokener(response).nextValue();
            	    for(int i = 0; i < obj.length(); i++){
        				JSONObject c = obj.getJSONObject(i);
        				String name = c.getString("name");
        				
        				HashMap<String, String> map = new HashMap<String, String>();
        				map.put("name", name);
        				PestList.add(map);
            	    }
			}
    		catch (Exception e) {
    	} 	
    	
		ListAdapter adapter = new SimpleAdapter(this, PestList,
				R.layout.list_item,
				new String[] { "name" }, new int[] {
						R.id.name });

		setListAdapter(adapter);
	}

		/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/

}
