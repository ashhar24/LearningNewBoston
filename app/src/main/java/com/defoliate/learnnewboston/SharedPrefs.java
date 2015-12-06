package com.defoliate.learnnewboston;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener
{
	EditText sharedData;
	TextView dataResults;
	static String filename = "MySharedString";
	SharedPreferences someData;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedprefs);
		init();
		someData = getSharedPreferences(filename, 0); 
	}

	private void init()
	{
		// TODO Auto-generated method stub
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoadData);

		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.bSave	:	String data = sharedData.getText().toString();
								SharedPreferences.Editor editor = someData.edit();
								// or we can import the editor class and use the following
								//Editor editor = someData.edit();
								editor.putString("sharedString", data);
								editor.commit();
								break;

			case R.id.bLoad:	someData = getSharedPreferences(filename, 0);
								String retdata = someData.getString("sharedString", "current load");
								dataResults.setText(retdata);
								break;

		}
	}

}
