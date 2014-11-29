package com.nullcognition.androidfragments;
/**
 * Created by ersin on 29/11/14 at 2:28 PM
 */
public class TitlesFragment extends android.app.ListFragment {

   private com.nullcognition.androidfragments.MainActivity mainActivity = null;
   int curCheckPos = 0;

   @Override
   public void onInflate(android.app.Activity activity, android.util.AttributeSet attrs, android.os.Bundle icicle){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onInflate. AttributeSet contains:");
	  for(int i = 0; i < attrs.getAttributeCount(); i++){
		 android.util.Log.v(MainActivity.TAG, "    " + attrs.getAttributeName(i) +
											  " = " + attrs.getAttributeValue(i));
	  }
	  super.onInflate(activity, attrs, icicle);
   }

   @Override
   public void onAttach(android.app.Activity myActivity){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onAttach; activity is: " + myActivity);
	  super.onAttach(myActivity);
	  mainActivity = (MainActivity)myActivity;
   }

   @Override
   public void onCreate(android.os.Bundle inBundle){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onCreate. Bundle contains:");
	  if(inBundle != null){
		 for(String key : inBundle.keySet()){
			android.util.Log.v(MainActivity.TAG, "    " + key);
		 }
	  }
	  else{
		 android.util.Log.v(MainActivity.TAG, "    icicle is null");
	  }
	  super.onCreate(inBundle);
	  if(inBundle != null){
		 curCheckPos = inBundle.getInt("curChoice", 0);
	  }
   }

   @Override
   public android.view.View onCreateView(android.view.LayoutInflater myInflater, android.view.ViewGroup container, android.os.Bundle inBundle){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onCreateView. container is " + container);
	  return super.onCreateView(myInflater, container, inBundle);
   }

   @Override
   public void onViewCreated(android.view.View view, android.os.Bundle inBundle){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onViewCreated");
	  super.onViewCreated(view, inBundle);
   }

   @Override
   public void onActivityCreated(android.os.Bundle inBundle){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onActivityCreated. inBundle contains:");
	  if(inBundle != null){
		 for(String key : inBundle.keySet()){
			android.util.Log.v(MainActivity.TAG, "    " + key);
		 }
	  }
	  else{
		 android.util.Log.v(MainActivity.TAG, "    inBundle is null");
	  }
	  super.onActivityCreated(inBundle);

	  setListAdapter(new android.widget.ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, com.nullcognition.androidfragments.Shakespeare.TITLES));

	  android.widget.ListView listView = getListView();
	  listView.setChoiceMode(android.widget.ListView.CHOICE_MODE_SINGLE);
	  listView.setSelection(curCheckPos);

	  mainActivity.showDetails(curCheckPos);
   }

   @Override
   public void onStart(){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onStart");
	  super.onStart();
   }

   @Override
   public void onResume(){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onResume");
	  super.onResume();
   }

   @Override
   public void onPause(){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onPause");
	  super.onPause();
   }

   @Override
   public void onSaveInstanceState(android.os.Bundle inBundle){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onSaveInstanceState. Bundle is " + inBundle);
	  super.onSaveInstanceState(inBundle);
	  if(inBundle != null){
		 android.util.Log.v(MainActivity.TAG, "inBundle contains the following:");
		 for(String key : inBundle.keySet()){
			android.util.Log.v(MainActivity.TAG, "    " + key);
		 }
	  }
	  inBundle.putInt("curChoice", curCheckPos);
   }

   @Override
   public void onViewStateRestored(android.os.Bundle icicle){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onViewStateRestored");
	  super.onViewStateRestored(icicle);
   }

   @Override
   public void onListItemClick(android.widget.ListView l, android.view.View v, int pos, long id){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onListItemClick. pos = " + pos);
	  mainActivity.showDetails(pos);
	  curCheckPos = pos;
   }

   @Override
   public void onStop(){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onStop");
	  super.onStop();
   }

   @Override
   public void onDestroyView(){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onDestroyView");
	  super.onDestroyView();
   }

   @Override
   public void onDestroy(){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onDestroy");
	  super.onDestroy();
   }

   @Override
   public void onDetach(){
	  android.util.Log.v(MainActivity.TAG, "in TitlesFragment onDetach");
	  super.onDetach();
	  mainActivity = null;
   }

}
