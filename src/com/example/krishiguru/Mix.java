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

public class Mix extends Activity {
	MediaPlayer mp=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mix);
		
		final ImageButton button1 = (ImageButton) findViewById(R.id.imageButton1);
		mp = MediaPlayer.create(this, R.raw.mix);
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
		getMenuInflater().inflate(R.menu.activity_mix, menu);
		return true;
	}*/

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
