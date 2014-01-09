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

public class Weatherdata  extends Activity {
	TextView name_label,policy_label,web_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currweather);
        String response=null;
       String res;
		try {
			response = CustomHttpClient.executeHttpGet("http://api.wunderground.com/api/01b692d632427ff2/conditions/q/CA/pune.json");
			res=response.toString();
           res = res.trim();
           JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
          JSONObject display=obj.getJSONObject("current_observation");
                    String weather=display.getString("weather");
        			String temp= display.getString("temperature_string");
       				String humid= display.getString("relative_humidity");
       				String windir= display.getString("wind_string");
       				String windspeed= display.getString("wind_dir");
       				String visible= display.getString("visibility_km");
       			TextView lblweather=(TextView) findViewById(R.id.weather_label);
       	       TextView lbltemp = (TextView) findViewById(R.id.temperature_label);
       	        TextView lblhumid= (TextView) findViewById(R.id.humidity_label);
       	     TextView lblwindir= (TextView) findViewById(R.id.windir_label);
       	  TextView lblwindspeed= (TextView) findViewById(R.id.windspeed_label);
       	TextView lblvisible= (TextView) findViewById(R.id.visibility_label);
  	            lblweather.setText(weather);
       	       lbltemp.setText(temp);
       	     lblhumid.setText(humid);
       	  lblwindir.setText(windir);
       	lblvisible.setText(visible);
       	lblwindspeed.setText(windspeed);
       		}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   	} 	
  }
}
