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

   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);

	  if((diTask = DownloaImageTask.getInstance()) != null){

		 diTask.setContext(this);
		 if(ddiTask.getStatus() == android.os.AsyncTask.Status.FINISHED){
			diTask.setImageInView();
		 }
	  }

   }

   String httpResourceLocation = "https://uetnhht.notheuhn.com/tnoueh/snotuh/snuoth";

   public void doClick(android.view.View inView){

	  if(diTask != null){
		 android.os.AsyncTask.Status diStatus = diTask.getStatus();
		 android.util.Log.e(getClass().getSimpleName(), "ditask status = " + diStatus);

		 if(diStatus != android.os.AsyncTask.Status.FINISHED){
			android.util.Log.e(getClass().getSimpleName(), "finished the task");
			return;
		 }
	  }
	  diTask = DownloadImageTask.newInstance(this);
	  diTask.execute(httpResourceLocation);
   }


   @Override
   public boolean onCreateOptionsMenu(Menu menu){
	  // Inflate the menu; this adds items to the action bar if it is present.
	  getMenuInflater().inflate(R.menu.menu_main, menu);
	  return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
	  // Handle action bar item clicks here. The action bar will
	  // automatically handle clicks on the Home/Up button, so long
	  // as you specify a parent activity in AndroidManifest.xml.
	  int id = item.getItemId();

	  //noinspection SimplifiableIfStatement
	  if(id == R.id.action_settings){
		 return true;
	  }

	  return super.onOptionsItemSelected(item);
   }
}
