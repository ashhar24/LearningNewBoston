package com.defoliate.learnnewboston;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity
{
	MediaPlayer sound;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		sound = MediaPlayer.create(Splash.this, R.raw.android);
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if(music == true)
		{
			sound.start();
		}
		
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(1000);
				}
				
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				finally
				{
					Intent openapp= new Intent("com.defoliate.learnnewboston.MENU");
					startActivity(openapp);
				}
			}
		};
		
		timer.start();
	}

	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();
		sound.release();
		finish();
	}
	
	
 
}
