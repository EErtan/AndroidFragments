package com.nullcognition.chapter4preferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

   private static final String TAG         = "SavingState";
   final                String INITIALIZED = "initialized";
   private String someString;


   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);

	  android.content.SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
	  boolean hasPref = sharedPreferences.getBoolean(INITIALIZED, false);

	  if(hasPref){
		 android.util.Log.e(getClass().getSimpleName(), "Hass been called befor");
		 someString = sharedPreferences.getString("someString", "");
	  }else{
		 android.util.Log.e(getClass().getSimpleName(), "first time called");
		 someString = "assign dynamic value";
	  }

	  android.util.Log.e(getClass().getSimpleName(), "someString = " + someString  );

	  android.content.SharedPreferences.Editor editor = sharedPreferences.edit();

	  editor.putBoolean(INITIALIZED, true);
	  editor.putString("someString", someString);
	  editor.commit();


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
