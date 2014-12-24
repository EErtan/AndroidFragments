package com.nullcognition.chapter6asyncprogress2;
import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
/**
 * Created by ersin on 23/12/14 at 11:25 PM
 */
public class MyApplication extends Application {

   public static final String tag = "MyApplication";

   @Override
   public void onConfigurationChanged(Configuration newConfig){
	  super.onConfigurationChanged(newConfig);
	  Log.e(getClass().getSimpleName(), "configuration chaned");

   }

   @Override
   public void onCreate() {
	  super.onCreate();
	  Log.d(tag,"oncreate");
   }

   @Override
   public void onLowMemory() {
	  super.onLowMemory();
	  Log.d(tag,"onLowMemory");
   }

   @Override
   public void onTerminate() {
	  super.onTerminate();
	  Log.d(tag,"onTerminate");
   }
}

