package com.defoliate.learnnewboston;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class Prefs extends PreferenceActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
		
		/*try 
		{
            getClass().getMethod("getFragmentManager");
            AddResourceApi11AndGreater();
        } 
		catch (NoSuchMethodException e) 
		{ 
			//Api < 11
            AddResourceApiLessThan11();
        }*/
    }
	
	/*
    @SuppressWarnings("deprecation")
    protected void AddResourceApiLessThan11()
    {
        addPreferencesFromResource(R.xml.prefs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB) 
    protected void AddResourceApi11AndGreater()
    {
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PF()).commit();
    }

    
    @TargetApi(Build.VERSION_CODES.HONEYCOMB) 
    public static class PF extends PreferenceFragment
    {       
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.prefs); //outer class
            // private members seem to be visible for inner class, and
            // making it static made things so much easier
        }
    }
		*/
}
	

