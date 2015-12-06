package com.defoliate.learnnewboston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class MyBringBack extends View
{
	Bitmap pBall;
	float changingY;
	Typeface font;
	public MyBringBack(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		
		pBall = BitmapFactory.decodeResource(getResources(), R.drawable.pokeball);
		changingY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "tahoma.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTypeface(font);
		textPaint.setTextSize(20);
		canvas.drawText("defoliate", canvas.getWidth()/2, 160, textPaint);
		canvas.drawBitmap(pBall, (canvas.getWidth()/2), changingY, null);
		if(changingY<canvas.getHeight())
		{
			changingY+=10;
		}
		else
			changingY=0;
		
		Rect middleRect = new Rect();
		middleRect.set(0, 200, canvas.getWidth(), 250);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}
	
	

}