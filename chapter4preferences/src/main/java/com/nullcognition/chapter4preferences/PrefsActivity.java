package com.nullcognition.chapter4preferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import java.util.List;
/**
 * Created by ersin on 15/12/14 at 11:24 PM
 */

public class PrefsActivity extends PreferenceActivity {

   @Override
   protected boolean isValidFragment(String fragmentName){
	  return (Frag1.class.getName().equals(fragmentName));
   }

   @Override
   public void onBuildHeaders(List<Header> target){
	  loadHeadersFromResource(R.xml.toplevel, target);
   }

   public static class Frag1 extends PreferenceFragment {


	  @Override
	  public void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
		 addPreferencesFromResource(R.xml.sound_preferences);
	  }
   }

}
