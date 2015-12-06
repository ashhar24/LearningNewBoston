package com.defoliate.learnnewboston;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener 
{
	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	final static int cameradata=0;
	Bitmap bmp ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		init();
		InputStream is = getResources().openRawResource(R.drawable.android);
		bmp = BitmapFactory.decodeStream(is);
	}

	private void init() 
	{
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById (R.id.ivCapturedImage);
		b = (Button) findViewById (R.id.bSetWallpaper);
		ib = (ImageButton) findViewById (R.id.ibTakeImage);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.bSetWallpaper : 	try 
										{
											getApplicationContext().setWallpaper(bmp);
										} 
										catch (IOException e) 
										{
											// TODO Auto-generated catch block
											e.printStackTrace();
											
										}
										break;
			case R.id.ibTakeImage	: 	i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
										startActivityForResult(i,cameradata);
										break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK)
		{
			Bundle extra = data.getExtras();
			bmp = (Bitmap) extra.get("data");
			iv.setImageBitmap(bmp);
		}
	}
	
	
	
	
	

}
