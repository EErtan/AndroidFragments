package com.nullcognition.androidfragments;// .cancel(booleanValue);
// .execute(Values);

public class DownloadImageTask extends android.os.AsyncTask<String, Integer, android.graphics.Bitmap> {

   private static com.nullcognition.androidfragments.DownloadImageTask downloadImageTask;
   private        android.content.Context                              context;
   int                     progress        = - 1;
   android.graphics.Bitmap downloadedImage = null;

   public DownloadImageTask(){
	  super();
   }

   public static synchronized com.nullcognition.androidfragments.DownloadImageTask newInstance(android.content.Context inContext){
	  downloadImageTask = new DownloadImageTask();
	  downloadImageTask.setContext(inContext);
	  return downloadImageTask;
   }

   public static com.nullcognition.androidfragments.DownloadImageTask getInstance(){
	  return downloadImageTask;
   }

   protected void setContext(android.content.Context inContext){
	  context = inContext;
	  if(progress >= 0){publishProgress(progress);}
   }

   @Override
   protected android.graphics.Bitmap doInBackground(String... inURLS){
	  return DownloadImage(inURLS);
   }

   public android.graphics.Bitmap DownloadImage(String... inURLS){
	  org.apache.http.client.HttpClient httpClient = CustomHttpClient.getHttpClient();
	  try{
		 org.apache.http.client.methods.HttpGet request = new org.apache.http.client.methods.HttpGet(inURLS[0]);
		 org.apache.http.params.HttpParams params = new org.apache.http.params.BasicHttpParams();
		 org.apache.http.params.HttpConnectionParams.setSoTimeout(params, 60000);   // 1 minute
		 request.setParams(params);

		 setProgress(25);

		 org.apache.http.HttpResponse response = httpClient.execute(request);

		 setProgress(50);

		 sleepFor(5000);    // five second sleep

		 byte[] image = org.apache.http.util.EntityUtils.toByteArray(response.getEntity());

		 setProgress(75);

		 android.graphics.Bitmap mBitmap = android.graphics.BitmapFactory.decodeByteArray(image, 0, image.length);

		 setProgress(100);

		 return mBitmap;
	  }
	  catch(java.io.IOException e){
		 // covers:
		 //      ClientProtocolException
		 //      ConnectTimeoutException
		 //      ConnectionPoolTimeoutException
		 //      SocketTimeoutException
		 e.printStackTrace();
	  }
	  return null;
   }

   private void setProgress(int progress) {
	  this.progress = progress;
	  publishProgress(this.progress);
   }

   protected void setImageInView() {
	  if(downloadedImage != null) {
		 android.widget.ImageView imageView = (android.widget.ImageView)
		   ((android.app.Activity) context).findViewById(com.nullcognition.ch02_configchanges.R.id.image); // todo place the correct image in the layout
		 imageView.setImageBitmap(downloadedImage);
	  }
   }


   @Override
   protected void onPreExecute(){
	  super.onPreExecute();
	  progress = 0;
   }

   private void sleepFor(long msecs) {
	  try {
		 Thread.sleep(msecs);
	  } catch (InterruptedException e) {
		 android.util.Log.v("sleep", "interrupted");
	  }
   }

   @Override
   protected void onPostExecute(android.graphics.Bitmap inResult){
	  super.onPostExecute(inResult);
   }

   @Override
   protected void onProgressUpdate(Integer... inProgress){
	  super.onProgressUpdate(inProgress);
   }

   @Override
   protected void onCancelled(android.graphics.Bitmap inResult){
	  super.onCancelled(inResult);
   }

   @Override
   protected void onCancelled(){
	  super.onCancelled();
   }
}
