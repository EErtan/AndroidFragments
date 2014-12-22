package com.nullcognition.chapter6asyncprogress;
import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
/**
 * Created by ersin on 21/12/14 at 11:40 PM
 */

public class MyApplication extends Application {

   public final static String tag = "MyApplication";

   @Override
   public void onConfigurationChanged(Configuration newConfig){
	  super.onConfigurationChanged(newConfig);
	  Log.d(tag, "configuration changed");
   }

   @Override
   public void onCreate(){
	  super.onCreate();
	  Log.d(tag, "oncreate");
   }

   @Override
   public void onLowMemory(){
	  super.onLowMemory();
	  Log.d(tag, "onLowMemory");
   }

   @Override
   public void onTerminate(){
	  super.onTerminate();
	  Log.d(tag, "onTerminate");
   }

}
