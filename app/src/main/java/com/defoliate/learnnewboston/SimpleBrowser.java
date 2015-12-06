package com.defoliate.learnnewboston;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener
{
	EditText url;
	WebView ourbrow;
	
	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		
		ourbrow = (WebView) findViewById(R.id.wvBrowser);
		
		//simple way to open the link in the webview only rather than deafult browser
		ourbrow.setWebViewClient(new WebViewClient());
		
		//another way
		//ourbrow.setWebViewClient(new myClient());
		
		ourbrow.getSettings().setJavaScriptEnabled(true);
		ourbrow.getSettings().setLoadWithOverviewMode(true);
		ourbrow.getSettings().setUseWideViewPort(true);
		try
		{
			ourbrow.loadUrl("http://www.ashhar24.wordpress.com");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		url = (EditText) findViewById(R.id.etBrowser);
		Button go = (Button) findViewById(R.id.bGo);
		Button goback = (Button) findViewById(R.id.bGoBack);
		Button gofwd = (Button) findViewById(R.id.bGoForward);
		Button refresh = (Button) findViewById(R.id.bRefresh);
		Button clear = (Button) findViewById(R.id.bClear);
		
		go.setOnClickListener(this);
		goback.setOnClickListener(this);
		gofwd.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.bGo			:	String web = "http://" + url.getText().toString();
										ourbrow.loadUrl(web);
										
										//hiding keyboard
										InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
										mgr.hideSoftInputFromWindow(url.getWindowToken(), 0);
										
										break;
										
			case R.id.bGoBack		:	if(ourbrow.canGoBack())
											ourbrow.goBack();
										break;
										
			case R.id.bGoForward	:	if(ourbrow.canGoForward())
											ourbrow.goForward();
										break;
										
			case R.id.bRefresh		:	ourbrow.reload();
										break;
										
			case R.id.bClear		:	ourbrow.clearHistory();
										break;
				
		}
	}
	

}
