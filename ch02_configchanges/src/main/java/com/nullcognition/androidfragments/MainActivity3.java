package com.nullcognition.androidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nullcognition.ch02_configchanges.R;

public class MainActivity3 extends Activity implements com.nullcognition.androidfragments.OnDialogDoneListener {

   public static final String LOGTAG          = "PickerdialogFragDemo";
   public static       String TIME_DIALOG_TAG = "TIME_DIALOG_TAG";
   public static       String DATE_DIALOG_TAG = "DATE_DIALOG_TAG";


   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main_activity3);
   }


   @Override
   public boolean onCreateOptionsMenu(Menu menu){
	  // Inflate the menu; this adds items to the action bar if it is present.
	  getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
	  return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
	  // Handle action bar item clicks here. The action bar will
	  // automatically handle clicks on the Home/Up button, so long
	  // as you specify a parent activity in AndroidManifest.xml.
	  int id = item.getItemId();

	  switch(id){
		 case R.id.menu_show_date_dialog:
			testTimePickerDialog();
			break;

		 case R.id.menu_show_time_dialog:
			testDatePickerDialog();
			break;
	  }

	  return super.onOptionsItemSelected(item);
   }

   private void testTimePickerDialog(){
	  android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
	  TimePickerFragment timePickerFragment = new TimePickerFragment();
	  timePickerFragment.show(fragmentTransaction, TIME_DIALOG_TAG);

	  android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();

	  DatePickerFragment dpf = new DatePickerFragment();

	  dpf.show(ft, DATE_DIALOG_TAG);
   }

   private void testDatePickerDialog(){
	  android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();

	  DatePickerFragment dpf = new DatePickerFragment();

	  dpf.show(ft, DATE_DIALOG_TAG);
   }

   public void onDialogDone(String tag, boolean cancelled, CharSequence message){
	  String s = tag + " responds with: " + message;
	  if(cancelled){ s = tag + " was cancelled by the user"; }
	  android.widget.Toast.makeText(this, s, android.widget.Toast.LENGTH_LONG).show();
	  android.util.Log.v(LOGTAG, s);
   }
}
