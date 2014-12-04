package com.nullcognition.androidfragments;
/**
 * Created by ersin on 04/12/14 at 8:03 AM
 */
public class NonUIFragment extends android.app.Fragment {

   private com.nullcognition.androidfragments.MainActivity mainActivity = null;
   int curCheckPos = 0;
   private com.nullcognition.androidfragments.DownloadImageTask downloadImageTask = null;

   static public com.nullcognition.androidfragments.NonUIFragment newInstance(){
	  NonUIFragment frag = new NonUIFragment();
	  frag.setRetainInstance(true);
	  return frag;
   }

   @Override
   public void onAttach(android.app.Activity activity){
	  super.onAttach(activity);
	  mainActivity = (MainActivity)activity;
   }

   @Override
   public void onCreate(android.os.Bundle bundle){
	  android.util.Log.v(MainActivity.TAG, "in fragment onCreate. Bundle contains:");
	  if(bundle != null){
		 for(String key : bundle.keySet()){
			android.util.Log.v(MainActivity.TAG, "    " + key);
		 }
	  }
	  else{
		 android.util.Log.v(MainActivity.TAG, "    myBundle is null");
	  }
	  super.onCreate(bundle);
	  if(bundle != null){
		 // Restore last state for checked position.
		 curCheckPos = bundle.getInt("curChoice", 0);
	  }
   }

   @Override
   public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState){
	  return super.onCreateView(inflater, container, savedInstanceState);
   }

   @Override
   public void onActivityCreated(android.os.Bundle savedInstanceState){
	  android.util.Log.v(MainActivity.TAG, "in fragment onActivityCreated. icicle contains:");
	  if(savedInstanceState != null) {
		 for(String key : savedInstanceState.keySet()) {
			android.util.Log.v(MainActivity.TAG, "    " + key);
		 }
	  }
	  else {
		 android.util.Log.v(MainActivity.TAG, "    icicle is null");
	  }
	  super.onActivityCreated(savedInstanceState);
	  // It is here that our activity is created and we can re-establish the
	  // image fetched by the background thread, or let the background
	  // thread know what the new activity reference is.

	  // The following checks to see if we're restarting with a backgrounded
	  // AsyncTask. If so, re-establish the connection. Also, since the image
	  // did not get saved across the destroy/create cycle, if the AsyncTask
	  // has finished, grab the downloaded image again from the AsyncTask.
	  if(downloadImageTask != null) {
		 android.util.Log.v(MainActivity.TAG, "fragment has an existing download task");
		 downloadImageTask.setContext(mainActivity);  // Give my AsyncTask the new Activity reference
		 if(downloadImageTask.getStatus() == android.os.AsyncTask.Status.FINISHED) {
			android.util.Log.v(MainActivity.TAG, "   task was done, setting image from memory");
			downloadImageTask.setImageInView();
		 }
	  }
	  else {
		 // If we didn't already have a download image task, go make
		 // a new one now to download the image.
		 android.util.Log.v(MainActivity.TAG, "   new fragment created, go get image");
		 getImage();
	  }
   }

   public void getImage() {
	  android.util.Log.v(com.nullcognition.androidfragments.MainActivity.TAG, "in fragment getImage");
	  if(downloadImageTask != null) {
		 android.os.AsyncTask.Status diStatus = downloadImageTask.getStatus();
		 android.util.Log.v(com.nullcognition.androidfragments.MainActivity.TAG, "diTask status is " + diStatus);
		 if(diStatus != android.os.AsyncTask.Status.FINISHED) {
			android.util.Log.v(com.nullcognition.androidfragments.MainActivity.TAG, "... no need to start a new task");
			return;
		 }
		 // Since diStatus must be FINISHED, we can go again.
	  }
	  android.util.Log.v(com.nullcognition.androidfragments.MainActivity.TAG, "starting new download image task...");
	  downloadImageTask = DownloadImageTask.newInstance(mainActivity); // be sure to note that the new keyword is not used, the newInstance is with the activity as the context.
	  downloadImageTask.execute("https://chart.googleapis.com/chart?chl=Froyo%7CGingerbread%7CIce%20Cream%20Sandwich%7CJelly%20Bean%7CKitKat&chd=t%3A0.6%2C9.8%2C8.5%2C50.9%2C30.2&chf=bg%2Cs%2C00000000&chco=c4df9b%2C6fad0c&cht=p&chs=500x250");
   }

   @Override
   public void onSaveInstanceState(android.os.Bundle icicle) {
	  android.util.Log.v(MainActivity.TAG, "in fragment onSaveInstanceState");
	  super.onSaveInstanceState(icicle);
	  icicle.putInt("curChoice", curCheckPos);
   }

   @Override
   public void onStop() {
	  android.util.Log.v(MainActivity.TAG, "in fragment onStop");
	  super.onStop();
   }

   @Override
   public void onDestroyView() {
	  android.util.Log.v(MainActivity.TAG, "in fragment onDestroyView");
	  super.onDestroyView();
   }

   @Override
   public void onDestroy() {
	  android.util.Log.v(MainActivity.TAG, "in fragment onDestroy");
	  super.onDestroy();
   }

   @Override
   public void onDetach() {
	  android.util.Log.v(MainActivity.TAG, "in fragment onDetach");
	  super.onDetach();
	  mainActivity = null;
   }

   @Override
   public void onViewCreated(android.view.View view, android.os.Bundle icicle) {
	  android.util.Log.v(MainActivity.TAG, "in fragment onViewCreated");
	  super.onViewCreated(view, icicle);
   }


}
