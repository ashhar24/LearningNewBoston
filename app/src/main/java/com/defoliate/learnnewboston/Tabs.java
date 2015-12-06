package com.defoliate.learnnewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener
{
	TabHost th;
	TextView showresults;
	long start,stop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		
		th = (TabHost) findViewById(R.id.tabhost);
		Button newtab = (Button) findViewById(R.id.bAddTab);
		Button bstart = (Button) findViewById(R.id.bStartWatch);
		Button bstop = (Button) findViewById(R.id.bStopWatch);
		showresults = (TextView) findViewById(R.id.tvShowWatch);
		
		newtab.setOnClickListener(this);
		bstart.setOnClickListener(this);
		bstop.setOnClickListener(this);
		th.setup();
		
		TabSpec ts = th.newTabSpec("tag1");
		ts.setContent(R.id.tab1);
		ts.setIndicator("StopWatch");
		th.addTab(ts);
		
		ts = th.newTabSpec("tag2");
		ts.setContent(R.id.tab2);
		ts.setIndicator("StopWatch 2");
		th.addTab(ts);
		
		ts = th.newTabSpec("tag3");
		ts.setContent(R.id.tab3);
		ts.setIndicator("Add another tab");
		th.addTab(ts);
		
		start = 0;
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.bAddTab		:	TabSpec ourspec = th.newTabSpec("tag1");
										ourspec.setContent(new TabHost.TabContentFactory()
										{
											
											@Override
											public View createTabContent(String tag)
											{
												// TODO Auto-generated method stub
												TextView text = new TextView(Tabs.this);
												text.setText("NEW TAB CREATED");
												return (text);
											}
										});
										ourspec.setIndicator("New");
										th.addTab(ourspec);
										break;

			case R.id.bStartWatch	:	start = System.currentTimeMillis();
										break;

			case R.id.bStopWatch	:	stop = System.currentTimeMillis();
										if(start!=0)
										{
											long result = stop-start;
											int milli = (int) result;
											int second = (int) result/1000;
											int minute = second/60;
											int hour = minute/60;
											milli %= 1000;
											second %= 60;
											minute %= 60;
											
											showresults.setText(String.format("%d::%02d::%02d::%02d\n", hour,minute,second,milli));
										}
										break;
		}
	}

}
