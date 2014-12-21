package com.nullcognition.chapter6asyncprogress;
import android.content.Context;
/**
 * Created by ersin on 20/12/14 at 11:54 PM
 */
public class BaseTester {

   protected IReportBack reportTo;
   protected Context     context;

   public BaseTester(Context inContext, IReportBack target){
	  reportTo = target;
	  context = inContext;
   }
}
