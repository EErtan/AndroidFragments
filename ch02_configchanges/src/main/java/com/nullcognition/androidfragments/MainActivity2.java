package com.nullcognition.androidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nullcognition.ch02_configchanges.R;

public class MainActivity2 extends Activity implements OnDialogDoneListener {

   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main_activity2);
	  android.app.FragmentManager.enableDebugLogging(true);

   }


   @Override
   public boolean onCreateOptionsMenu(Menu menu){
	  // Inflate the menu; this adds items to the action bar if it is present.
	  getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
	  return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
	  // Handle action bar item clicks here. The action bar will
	  // automatically handle clicks on the Home/Up button, so long
	  // as you specify a parent activity in AndroidManifest.xml.
	  int id = item.getItemId();
	  switch(item.getItemId()){
		 case R.id.menu_show_alert_dialog:
			dialogHelperClass.testAlertDialog();
			break;
		 case R.id.menu_show_prompt_dialog:
			dialogHelperClass.testPromptDialog();
			break;
		 case R.id.menu_help:
			dialogHelperClass.testHelpDialog();
			break;
		 case R.id.menu_embedded:
			dialogHelperClass.testEmbeddedDialog();
			break;
		 case com.nullcognition.ch02_configchanges.R.id.action_next_activity:
			android.content.Intent startactivity3 = new android.content.Intent(this, MainActivity3.class);
			startactivity3.putExtra("startactivity2", "value");
			startActivity(startactivity3);
			return true;
	  }

	  return super.onOptionsItemSelected(item);
   }

   public void onDialogDone(String tag, boolean cancelled, CharSequence message){
	  String s = tag + " responds with: " + message;
	  if(cancelled){ s = tag + " was cancelled by the user"; }
	  android.widget.Toast.makeText(this, s, android.widget.Toast.LENGTH_LONG).show();
	  android.util.Log.v("mainactivity 2", s);
   }

   private final DialogHelperClass dialogHelperClass = new DialogHelperClass(this);

   public static class DialogHelperClass {

	  private final java.lang.ref.WeakReference<MainActivity2> activity;

	  public DialogHelperClass(MainActivity2 inActivity){
		 activity = new java.lang.ref.WeakReference<MainActivity2>(inActivity);
	  }

	  public static final String LOGTAG            = "DialogFragDemo";
	  public static final String ALERT_DIALOG_TAG  = "ALERT_DIALOG_TAG";
	  public static final String HELP_DIALOG_TAG   = "HELP_DIALOG_TAG";
	  public static final String PROMPT_DIALOG_TAG = "PROMPT_DIALOG_TAG";
	  public static final String EMBED_DIALOG_TAG  = "EMBEDDED_DIALOG_TAG";

	  public void testAlertDialog(){
		 try{
			android.app.FragmentTransaction ft = activity.get().getFragmentManager().beginTransaction();
			AlertDialogFragment adf = AlertDialogFragment.newInstance("Alert Message");
			adf.show(ft, ALERT_DIALOG_TAG);
		 }
		 catch(Exception e){
			e.printStackTrace();
			android.util.Log.e(getClass().getSimpleName(), "testalertdialog error check activity state");
		 }
	  }

	  private void testPromptDialog(){
		 try{
			android.app.FragmentTransaction ft = activity.get().getFragmentManager().beginTransaction();
			PromptDialogFragment pdf = PromptDialogFragment.newInstance("Enter Something");
			pdf.show(ft, PROMPT_DIALOG_TAG);
		 }
		 catch(Exception e){
			e.printStackTrace();
			android.util.Log.e(getClass().getSimpleName(), "testpromptdialog error check activity state");

		 }

	  }

	  private void testHelpDialog(){
		 try{
			android.app.FragmentTransaction ft = activity.get().getFragmentManager().beginTransaction();
			HelpDialogFragment hdf = HelpDialogFragment.newInstance(R.string.help_text);
			//ft.addToBackStack(HELP_DIALOG_TAG);
			hdf.show(ft, HELP_DIALOG_TAG);
		 }
		 catch(Exception e){
			e.printStackTrace();
			android.util.Log.e(getClass().getSimpleName(), "testhelpdialog error check activity state");
		 }
	  }

	  private void testEmbeddedDialog(){
		 try{
			android.app.FragmentTransaction ft = activity.get().getFragmentManager().beginTransaction();
			PromptDialogFragment pdf = PromptDialogFragment.newInstance("Enter Something");
			ft.add(R.id.embeddedDialog, pdf, EMBED_DIALOG_TAG);
			ft.commit();
		 }
		 catch(Exception e){
			e.printStackTrace();
			android.util.Log.e(getClass().getSimpleName(), "testembeddeddialog error check activity state");
		 }
	  }
   }
}
