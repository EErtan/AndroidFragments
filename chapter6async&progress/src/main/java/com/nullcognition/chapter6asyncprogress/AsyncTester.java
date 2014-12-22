package com.nullcognition.chapter6asyncprogress;
import android.content.Context;
/**
 * Created by ersin on 21/12/14 at 11:38 PM
 */


public class AsyncTester extends BaseTester
{
   private static String tag = "AsyncTester1";
   AsyncTester(Context ctx, IReportBack target)
   {
	  super(ctx, target);
   }
   //All of this should execute on one worker thread
   //All inputs are processed by the same thread for this task
   public void test1()
   {
	  MyLongTask mlt = new MyLongTask(this.reportTo,this.context,"Task1");
	  mlt.execute("String1","String2","String3");

   }

   //This is to observer thread behavior when multiple
   //tasks are issued by a client
   public void test3()
   {
	  MyLongTask mlt = new MyLongTask(this.reportTo,this.context,"Task1");
	  mlt.execute("String1","String2","String3");

	  MyLongTask mlt1 = new MyLongTask(this.reportTo,this.context,"Task2");
	  mlt1.execute("A_String","B_String","C_String");
   }
   public void test2()
   {
	  MyLongTask1 mlt = new MyLongTask1(this.reportTo,this.context,"Task1");
	  mlt.execute("String1","String2","String3");
   }
   public void test()
   {
	  test3();
   }
}
