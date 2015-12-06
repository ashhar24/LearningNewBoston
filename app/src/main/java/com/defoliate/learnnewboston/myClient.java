package com.defoliate.learnnewboston;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class myClient extends WebViewClient
{

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url)
	{
		// TODO Auto-generated method stub
		view.loadUrl(url);
		return true;
	}
	
}
