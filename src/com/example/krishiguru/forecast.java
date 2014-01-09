package com.example.krishiguru;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.example.krishiguru.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class forecast  extends Activity {
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forecast);
        String response=null;
		String res;
		try {
			response = CustomHttpClient.executeHttpGet("http://api.wunderground.com/api/01b692d632427ff2/forecast/q/CA/pune.json");
			res=response.toString();
			res = res.trim();
			JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
			JSONObject disp=obj.getJSONObject("forecast");
			JSONObject display=disp.getJSONObject("txt_forecast");
			JSONArray display1=display.getJSONArray("forecastday");
           	JSONObject c=display1.getJSONObject(2);
           			String title2=c.getString("title");
	       			String weather2= c.getString("fcttext_metric");
            JSONObject d=display1.getJSONObject(4);
	                String title4=d.getString("title");
	                String weather4= d.getString("fcttext_metric");
            JSONObject e=display1.getJSONObject(6);
                    String title6=e.getString("title");
           	     	String weather6= e.getString("fcttext_metric");
          			TextView lbltitle2=(TextView) findViewById(R.id.title2);
               	    TextView lbltemp2 = (TextView) findViewById(R.id.temp2);
               	    lbltitle2.setText(title2);
               	    lbltemp2.setText(weather2);
               	    TextView lbltitle4=(TextView) findViewById(R.id.title4);
               	    TextView lbltemp4 = (TextView) findViewById(R.id.temp4);
               	    lbltitle4.setText(title4);
               	    lbltemp4.setText(weather4);
               	    TextView lbltitle6=(TextView) findViewById(R.id.title6);
              	    TextView lbltemp6 = (TextView) findViewById(R.id.temp6);
              	    lbltitle6.setText(title6);
              	    lbltemp6.setText(weather6);
			}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   		Log.e("Errortype", e.toString());
   	} 	
    }
}
