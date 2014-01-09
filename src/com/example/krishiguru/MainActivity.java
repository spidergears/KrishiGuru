package com.example.krishiguru;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.krishiguru.R;
import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends Activity {
	MediaPlayer mp=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Parse.initialize(this, getString(R.string.app_id), getString(R.string.client_key)); 
		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo2", "bar2");
		testObject.saveInBackground();
		
		final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton2);
		mp = MediaPlayer.create(this, R.raw.welcome_screen);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!mp.isPlaying())
				{
					mp.start();
				}
				else
				{	
					mp.pause();
		         	mp.seekTo(0);
				}						
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		mp.pause();
		mp.seekTo(0);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mp.pause();
		mp.seekTo(0);
		mp.release();
		mp=null;
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mp.pause();
		mp.seekTo(0);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		mp.pause();
		mp.seekTo(0);
	}
	
		
	public void openAbout(View v)
	 {
	   Intent myIntent = new Intent(this, About.class);
	   startActivity(myIntent);
	 }
	
	
	public void openWeather(View v)
	 {
	   Intent myIntent = new Intent(this, Weather.class);
	   startActivity(myIntent);
	 }
	public void openFinance(View v)
	 {
	   Intent myIntent = new Intent(this, Finance.class);
	   startActivity(myIntent);
	 }
	public void openJansabha(View v)
	 {
		startActivity(new Intent(Intent.ACTION_VIEW, 
				Uri.parse("http://203.199.146.117/KisaanJanSabha/")));	
	 }
	public void openUtility(View v)
	 {
	   Intent myIntent = new Intent(this, Utility.class);
	   startActivity(myIntent);
	 }
	public void openTech(View v)
	 {
	   Intent myIntent = new Intent(this, AndroidRssReader.class);
	   startActivity(myIntent);
	 }
	public void openOrganic(View v)
	 {
	   Intent myIntent = new Intent(this, Organic.class);
	   startActivity(myIntent);
	 }
	public void openCall(View v)
	 {
		String url = "tel:18001801551";
	    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
		startActivity(intent);
	 }
}
