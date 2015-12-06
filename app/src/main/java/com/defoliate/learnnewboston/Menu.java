package com.defoliate.learnnewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity 
{
	String classes[] = { "SimpleBrowser", "ExternalData", "InternalData", "SharedPrefs", "Starting", "Text", "Email", "Camera",
			"Data", "GFX", "GFXSurface", "SoundStuff", "Slider", "Tabs", "Flipper"};

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//menu
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_expandable_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		String s = classes[position];
		try 
		{
			Class c = Class.forName("com.defoliate.learnnewboston." + s);
			Intent menuintent = new Intent(Menu.this, c);
			startActivity(menuintent);
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) 
	{
		// TODO Auto-generated method stub
		//return super.onCreateOptionsMenu(menu);
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// TODO Auto-generated method stub
		//return super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
			case R.id.aboutUs	:	Intent i = new Intent("com.defoliate.learnnewboston.ABOUTUS");
									startActivity(i);
									break;
			
			case R.id.pref		:	Intent p = new Intent("com.defoliate.learnnewboston.PREFS");
									startActivity(p);
									break;
			
			case R.id.exit		:	finish();
									break;
		}
		return false;
	}
	
	
	
	
}
