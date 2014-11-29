package com.nullcognition.androidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

   public static final String TAG = "shakespeare";

   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);

	  android.app.FragmentManager.enableDebugLogging(true);
	  setContentView(R.layout.activity_main);
   }


   @Override
   public void onAttachFragment(android.app.Fragment fragment){
	  android.util.Log.v(TAG, "in MainActivity onAttachFragment. fragment id = " + fragment.getId());
	  super.onAttachFragment(fragment);
   }

   @Override
   public void onStart(){
	  android.util.Log.v(TAG, "in MainActivity onStart");
	  super.onStart();
   }

   @Override
   public void onResume(){
	  android.util.Log.v(TAG, "in MainActivity onResume");
	  super.onResume();
   }

   @Override
   public void onPause(){
	  android.util.Log.v(TAG, "in MainActivity onPause");
	  super.onPause();
   }

   @Override
   public void onStop(){
	  android.util.Log.v(TAG, "in MainActivity onStop");
	  super.onStop();
   }

   @Override
   public void onSaveInstanceState(Bundle outState){
	  android.util.Log.v(TAG, "in MainActivity onSaveInstanceState");
	  super.onSaveInstanceState(outState);
   }

   @Override
   public void onDestroy(){
	  android.util.Log.v(TAG, "in MainActivity onDestroy");
	  super.onDestroy();
   }

   public boolean isMultiPane(){
	  return getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE;
   }

   public void showDetails(int index){
	  android.util.Log.v(TAG, "in mainativity showdetails(" + index + ")");

	  if(isMultiPane()){
		 DetailsFragment details = null;
		 try{
			details = (DetailsFragment)getFragmentManager().findFragmentById(R.id.details);
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 if(details == null || details.getShownIndex() != index){
			details = DetailsFragment.newInstance(index);
			android.util.Log.v(getClass().getSimpleName(), "fragment transaction starting");
			android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
			//ft.setCustomAnimations(R.animator.fragment_open_enter,
			//		R.animator.fragment_open_exit);
			ft.setCustomAnimations(R.animator.bounce_in_down, R.animator.slide_out_right);
			//ft.setCustomAnimations(R.animator.fade_in,
			//		R.animator.fade_out);
			//ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details, details);
			ft.addToBackStack(TAG); // optional usage in this example
			ft.commit();
		 }
	  }
	  else{
		 android.content.Intent intent = new android.content.Intent();
		 intent.setClass(this, DetailsActivity.class);
		 intent.putExtra("index", index);
		 startActivity(intent);
	  }

   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu){
	  getMenuInflater().inflate(R.menu.menu_main, menu);
	  return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
	  int id = item.getItemId();

	  if(id == R.id.action_settings){
		 return true;
	  }

	  return super.onOptionsItemSelected(item);
   }
}
