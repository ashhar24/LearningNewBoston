package com.defoliate.learnnewboston;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Text extends Activity implements View.OnClickListener
{
	Button chkcmd;
	ToggleButton pwdtog;
	EditText input;
	TextView display ;
	
	private void init() 
	{
		// TODO Auto-generated method stub
		chkcmd = (Button)findViewById(R.id.buttonResults);
		pwdtog = (ToggleButton) findViewById(R.id.tbPassword);
		input = (EditText) findViewById(R.id.etCommands);
		display = (TextView) findViewById(R.id.tvResults);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		init();
		
		pwdtog.setOnClickListener(this);
		chkcmd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.tbPassword	: 	toggle();
										break;
			
			case R.id.buttonResults	:	buttonclick();
										break;
		}
	}

	private void buttonclick() 
	{
		// TODO Auto-generated method stub
		String chk = input.getText().toString();
		display.setText(chk);
		if (chk.contentEquals("left"))
			display.setGravity(Gravity.LEFT);
		else if(chk.contentEquals("center"))	
			display.setGravity(Gravity.CENTER);
		else if(chk.contentEquals("right"))
			display.setGravity(Gravity.RIGHT);
		else if(chk.contentEquals("blue"))
			display.setTextColor(Color.BLUE);
		else if(chk.contains("WTF"))
		{
			Random crazy = new Random();
			display.setText("WTF!!!");
			display.setTextSize(crazy.nextInt(75));
			display.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
			switch(crazy.nextInt(3))
			{
				case 0:	display.setGravity(Gravity.LEFT);
						break;
				case 1:	display.setGravity(Gravity.CENTER);
						break;
				case 2: display.setGravity(Gravity.RIGHT);
						break;
			}
		}
		else
		{
			display.setText("INVALID");
			display.setGravity(Gravity.CENTER);
			display.setTextColor(Color.BLACK);
		}
	}

	private void toggle() 
	{
		// TODO Auto-generated method stub
		if(pwdtog.isChecked())
			input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		else
			input.setInputType(InputType.TYPE_CLASS_TEXT); 
	}	
}
