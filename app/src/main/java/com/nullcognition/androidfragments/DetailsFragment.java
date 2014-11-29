package com.nullcognition.androidfragments;
/**
 * Created by ersin on 29/11/14 at 1:31 AM
 */
public class DetailsFragment extends android.app.Fragment {

   private int index = 0;

   public static com.nullcognition.androidfragments.DetailsFragment newInstance(int inIndex){
	  android.util.Log.v(com.nullcognition.androidfragments.MainActivity.TAG, "DetailsFragment.newInstance(" + inIndex + ")");

	  DetailsFragment df = new DetailsFragment();
	  android.os.Bundle args = new android.os.Bundle();

	  args.putInt("index", inIndex);
	  df.setArguments(args);

	  return df;
   }

   public static DetailsFragment newInstance(android.os.Bundle bundle){
	  int indx = bundle.getInt("index", 0);
	  return newInstance(indx);
   }

}
