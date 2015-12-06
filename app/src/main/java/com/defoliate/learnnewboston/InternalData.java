package com.defoliate.learnnewboston;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener
{
	EditText sharedData;
	TextView dataResults;
	FileOutputStream fos;
	String FILENAME = "Internal String";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedprefs);
		init();
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
		
		try
		{
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.bSave	:	String data = sharedData.getText().toString();
								
								// saving data via File
								/*File f = new File(FILENAME);
								try
								{
									fos = new FileOutputStream(f);
									fos.close();
								}
								catch (FileNotFoundException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								catch (IOException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}*/
			
								try
								{
									fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
									fos.write(data.getBytes());
									fos.close();
								}
								catch (FileNotFoundException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								catch (IOException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;

			case R.id.bLoad:	new loadSomeStuff().execute(FILENAME);
								break;

		}
	}

	public class loadSomeStuff extends AsyncTask<String, Integer, String>
	{
		ProgressDialog dialog;
		
		protected void onPreExecute()
		{
			//example of setting up dialogbox
			dialog = new ProgressDialog(InternalData.this);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.show();
		}
		
		@Override
		protected String doInBackground(String... params)
		{
			// TODO Auto-generated method stub
			String collected = "HEHE!!"; 
			FileInputStream fis = null;
			
			for(int i=0;i<20;i++)
			{
				publishProgress(5);
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dialog.dismiss();
			
			try
			{
				fis = openFileInput(FILENAME);
				byte[] dataArray = new byte[fis.available()];
				if(dataArray.length>0)
					while(fis.read(dataArray) != -1)
						collected = new String(dataArray); 
			}
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try
				{
					fis.close();
					//dataResults.setText(collected);
					return collected;
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//return null;
			return collected;
		}
		
		protected void onProgressUpdate(Integer... progress)
		{
			dialog.incrementProgressBy(progress[0]);
		}
		
		protected void onPostExecute(String result)
		{
			dataResults.setText(result);
		}
		
	}
}
