package com.defoliate.learnnewboston;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener
{
	TextView question,test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread,sendData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		init();
		
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name", "Ashhar is...");
		String values = getData.getString("list", "Item4");
		if(values.contentEquals("Item1"))
		{
			question.setText(et);
		}
		//Bundle gotbasket = getIntent().getExtras();
		//gotBread = gotbasket.getString("key");
		//question.setText(gotBread);
		
	}

	private void init() 
	{
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		selectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", sendData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) 
	{
		// TODO Auto-generated method stub
		switch(checkedId)
		{
			case R.id.rIdiot	:	sendData = "Probably Right!";
									break;
			case R.id.rMota 	: 	sendData = "Definitely Right!";
									break;
			case R.id.rBoth 	: 	sendData = "Spot On!";
									break;
		}
		
		test.setText(sendData);
	}
	

}