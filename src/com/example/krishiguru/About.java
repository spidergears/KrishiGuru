package com.example.krishiguru;

import com.example.krishiguru.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.support.v4.app.NavUtils;

public class About extends Activity {
	MediaPlayer mp=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);-
		final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton1);
		mp = MediaPlayer.create(this, R.raw.abt);
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

	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_about, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
	

}
