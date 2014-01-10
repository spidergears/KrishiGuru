package com.example.krishiguru;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.example.krishiguru.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class DBRetailCity extends ListActivity {
	 String vari=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		ArrayList<HashMap<String, String>> RetailList = new ArrayList<HashMap<String, String>>();
		String response = null;
		     Intent in = getIntent();
	        vari = in.getStringExtra("TAG_VARI");
	        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
	   		postParameters.add(new BasicNameValuePair("City", vari));
	   		
		try {
    		response = CustomHttpClient.executeHttpPost("http://server-ip/getretailname.php", postParameters);
		    response=response.toString();
            response = response.trim();
            	    JSONArray obj=(JSONArray) new JSONTokener(response).nextValue();
            	    for(int i = 0; i < obj.length(); i++){
        				JSONObject c = obj.getJSONObject(i);
        				String name = c.getString("Name");
        				
        				HashMap<String, String> map = new HashMap<String, String>();
        				map.put("Name", name);
        				RetailList.add(map);
            	    }
			}
    		catch (Exception e) {
    		Log.e("Exception Occured","An Error has occured fetching data");
    	} 	
    	 final ListAdapter adapter = new SimpleAdapter(this, RetailList,
				R.layout.list_item,
				new String[] { "Name" }, new int[] {
						R.id.name });

		setListAdapter(adapter);
		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String var= adapter.getItem(position).toString();
				var=var.substring(6, var.length()-1);
				Intent intent = new Intent(getApplicationContext(), Retaildetail.class);
				intent.putExtra("TAG_VARI",var);
				intent.putExtra("TAG_CITY",vari);
				Log.e("Current","Current value is:"+var.toString());
				startActivity(intent);
			}
		});
	}
}
