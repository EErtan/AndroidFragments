package com.nullcognition.androidfragments;
/**
 * Created by ersin on 29/11/14 at 1:31 AM
 */
public class DetailsFragment extends android.app.Fragment {

   private int index = 0;

   public int getShownIndex(){return index;}


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

   @Override
   public void onInflate(android.app.Activity activity, android.util.AttributeSet attrs, android.os.Bundle savedInstanceState){
	  super.onInflate(activity, attrs, savedInstanceState);
	  android.util.Log.e(getClass().getSimpleName(), "DetailsFragment.onInflate AttributeSet");
	  for(int i = 0; i < attrs.getAttributeCount(); i++){
		 android.util.Log.e(getClass().getSimpleName(), " " + attrs.getAttributeName(i) + " = " + attrs.getAttributeValue(i));
	  }
   }

   @Override
   public void onAttach(android.app.Activity inActivity){
	  android.util.Log.e(getClass().getSimpleName(), "Detailsfragment.onAttach; activity is =  " + inActivity);
	  super.onAttach(inActivity);
   }

   @Override
   public void onCreate(android.os.Bundle bundle){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onCreate. Bundle contains:");
	  if(bundle != null){
		 for(String _keySet : bundle.keySet()){
			android.util.Log.e(getClass().getSimpleName(), " " + _keySet);
		 }
	  }
	  else{
		 android.util.Log.e(getClass().getSimpleName(), "bundle is null");
	  }
	  super.onCreate(bundle);
	  index = getArguments().getInt("index", 0);
   }

   @Override
   public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onCreateView. container = " + container);
	  if(container == null){
		 android.util.Log.e(getClass().getSimpleName(), "container is null, no inflation");
		 return null;
	  }
	  android.view.View v = inflater.inflate(R.layout.details, container, false);
	  android.widget.TextView text1 = (android.widget.TextView)v.findViewById(R.id.text1);
	  text1.setText(Shakespeare.DIALOGUE[index]);

	  return v;
   }

   @Override
   public void onSaveInstanceState(android.os.Bundle outState){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onSaveInstanceState. Bundle is " + outState);
	  super.onSaveInstanceState(outState);
	  if(outState != null){
		 android.util.Log.v(MainActivity.TAG, "icicle contains the following:");
		 for(String key : outState.keySet()){
			android.util.Log.v(MainActivity.TAG, "    " + key);
		 }
	  }
   }

   @Override
   public void onActivityCreated(android.os.Bundle savedInstanceState){

	  if(savedInstanceState != null){
		 for(String _keySet : savedInstanceState.keySet()){
			android.util.Log.e(getClass().getSimpleName(), " " + _keySet);
		 }
	  }
	  else{
		 android.util.Log.e(getClass().getSimpleName(), " savedInstanceState = null");
	  }
	  super.onActivityCreated(savedInstanceState);
   }

   @Override
   public void onViewStateRestored(android.os.Bundle inBundle){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onViewStateRestored for view hierarchy");
	  super.onViewStateRestored(inBundle);
   }

   @Override
   public void onStart(){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onStart");
	  super.onStart();
   }

   @Override
   public void onResume(){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onResume");
	  super.onResume();
   }

   @Override
   public void onPause(){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onPause");
	  super.onPause();
   }

   @Override
   public void onStop(){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onStop");
	  super.onStop();
   }

   @Override
   public void onDestroyView(){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onDestroyView, view = " + getView());
	  super.onDestroyView();
   }

   @Override
   public void onDestroy(){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onDestroy");
	  super.onDestroy();
   }

   @Override
   public void onDetach(){
	  android.util.Log.v(MainActivity.TAG, "in DetailsFragment onDetach");
	  super.onDetach();
   }

}
