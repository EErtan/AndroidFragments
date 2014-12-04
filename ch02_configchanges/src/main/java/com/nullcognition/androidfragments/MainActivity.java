package com.nullcognition.androidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nullcognition.ch02_configchanges.R;

public class MainActivity extends Activity {
   // as a rule image downloading should not be done in an async task as the network may be of poor quality,
   // thus one should use a service for the persistance throughout the application lifecyle.

   // asynctask is used for demo purposes to showcase the persistant task across lifecycles

   private DownloadImageTask diTask;
   android.widget.ImageView imageView = null;
   public static final String TAG = "main activity";
   private com.nullcognition.androidfragments.NonUIFragment workerFrag;


   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);

	  imageView = (android.widget.ImageView)findViewById(com.nullcognition.ch02_configchanges.R.id.image);

	  if((diTask = DownloadImageTask.getInstance()) != null){

		 diTask.setContext(this);
		 if(diTask.getStatus() == android.os.AsyncTask.Status.FINISHED){
			diTask.setImageInView();
		 }
	  }

	  // picasso library implementation
	  android.widget.Button buttonOk = (android.widget.Button)findViewById(com.nullcognition.ch02_configchanges.R.id.buttonOk);
	  buttonOk.setOnClickListener(new android.view.View.OnClickListener() {

		 @Override
		 public void onClick(android.view.View inView){

			com.squareup.picasso.Picasso.with(getApplicationContext()).load(httpResourceLocation).into(imageView);
		 }
	  });
   }

   private String httpResourceLocation = "https://chart.googleapis.com/chart?chl=Froyo%7CGingerbread%7CIce%20Cream%20Sandwich%7CJelly%20Bean%7CKitKat&chd=t%3A0.6%2C9.8%2C8.5%2C50.9%2C30.2&chf=bg%2Cs%2C00000000&chco=c4df9b%2C6fad0c&cht=p&chs=500x250";

   public void doClick(android.view.View inView){

	  android.app.FragmentManager fragMgr = getFragmentManager();
	  workerFrag = (NonUIFragment)fragMgr.findFragmentByTag("worker");
	  if(workerFrag != null){
		 android.util.Log.v(TAG, "found a worker fragment, getting image...");
		 workerFrag.getImage();
	  }
	  else{
		 android.util.Log.v(TAG, "need to make a new worker fragment");
		 workerFrag = NonUIFragment.newInstance(); // could even pass the httpresourcelocation here or as part of the bundle
		 fragMgr.beginTransaction().add(workerFrag, "worker").commit();
	  }

// depreciated let the worker fragment do the initialization(new DownloadImageTask) and image getting

//	  if(diTask != null){
//		 android.os.AsyncTask.Status diStatus = diTask.getStatus();
//		 android.util.Log.e(getClass().getSimpleName(), "ditask status = " + diStatus);
//
//		 if(diStatus != android.os.AsyncTask.Status.FINISHED){
//			android.util.Log.e(getClass().getSimpleName(), "finished the task");
//			return;
//		 }
//	  }
//	  diTask = DownloadImageTask.newInstance(this);
//	  diTask.execute(httpResourceLocation);
   }

	  @Override public boolean onCreateOptionsMenu (Menu menu){
		 // Inflate the menu; this adds items to the action bar if it is present.
		 getMenuInflater().inflate(R.menu.menu_main, menu);
		 return true;
	  }

	  @Override public boolean onOptionsItemSelected (MenuItem item){
		 // Handle action bar item clicks here. The action bar will
		 // automatically handle clicks on the Home/Up button, so long
		 // as you specify a parent activity in AndroidManifest.xml.
		 int id = item.getItemId();

		 //noinspection SimplifiableIfStatement
		 if(id == R.id.action_settings){
			imageView.setImageResource(android.R.color.transparent);
			return true;
		 }

		 return super.onOptionsItemSelected(item);
	  }
   }
