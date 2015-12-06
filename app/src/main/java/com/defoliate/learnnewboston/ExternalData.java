package com.defoliate.learnnewboston;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener
{
	private TextView canRead, canWrite;
	private String state;
	boolean canw, canr; 
	Spinner spin;
	String paths[] = {"Music", "Downloads", "Pictures"};
	File path = null, file = null;
	EditText savefile;
	Button confirm,save;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		
		canRead = (TextView) findViewById(R.id.tvCanRead);
		canWrite = (TextView) findViewById(R.id.tvCanWrite);
		savefile = (EditText) findViewById(R.id.etSaveAs);
		confirm = (Button) findViewById(R.id.bConfirm);
		save = (Button) findViewById(R.id.bSaveFile);
		
		confirm.setOnClickListener(this);
		save.setOnClickListener(this);
		
		checkstate();
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item , paths);
		spin = (Spinner) findViewById(R.id.spinner1);
		spin.setAdapter(adapter);
		spin.setOnItemSelectedListener(this);
		
	}

	private void checkstate()
	{
		// TODO Auto-generated method stub
		state = Environment.getExternalStorageState();
		if(state.equals(Environment.MEDIA_MOUNTED))
		{
			//read and write
			canRead.setText("true");
			canWrite.setText("true");
			canw=canr=true;
		}
		else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
		{
			//only read
			canRead.setText("true");
			canWrite.setText("false");
			canw=false;
			canr=true;
		}
		else
		{
			canRead.setText("false");
			canWrite.setText("false");
			canw=canr=false;
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
	{
		// TODO Auto-generated method stub
		//position = spin.getSelectedItemPosition();
		switch(position)
		{
			case 0	:	path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
						break;
						
			case 1	:	path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
						break;
						
			case 2 	:	path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
						break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.bSaveFile	:	String f = savefile.getText().toString();
									file = new File(path, f + ".png");
									checkstate();
									if(canw == canr == true)
									{
										path.mkdirs();
										try
										{
											InputStream is = getResources().openRawResource(R.drawable.pokeball);
											OutputStream os = new FileOutputStream(file);
											byte[] data = new byte[is.available()];
											is.read(data);
											os.write(data);
											is.close();
											os.close();
											
											Toast t = Toast.makeText(ExternalData.this, "File has been saved.",Toast.LENGTH_LONG);
											t.show();
											// update files for users to use
											MediaScannerConnection.scanFile(ExternalData.this, new String[] {file.toString()}, null, 
																			new MediaScannerConnection.OnScanCompletedListener()
																			{
																				@Override
																				public void onScanCompleted(String path, Uri uri)
																				{
																					// TODO Auto-generated method stub
																					Toast t = Toast.makeText(ExternalData.this, "Scan Complete", Toast.LENGTH_SHORT);
																					t.show();
																				}
																			});
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
									break;
			
			case R.id.bConfirm	:	save.setVisibility(View.VISIBLE);
									break;
		}
		
	}
	
}
