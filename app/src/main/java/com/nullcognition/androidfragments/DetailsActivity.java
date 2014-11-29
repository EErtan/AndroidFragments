package com.nullcognition.androidfragments;

import android.app.Activity;
import android.os.Bundle;


public class DetailsActivity extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_details);
	  android.util.Log.v(getClass().getSimpleName(), "in details activity onCreate");

	  if(getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE){
		 finish();
		 return;
	  }

	  if(getIntent() != null){
		 DetailsFragment details = DetailsFragment.newInstance(getIntent().getExtras());
		 getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
	  }
   }


}
