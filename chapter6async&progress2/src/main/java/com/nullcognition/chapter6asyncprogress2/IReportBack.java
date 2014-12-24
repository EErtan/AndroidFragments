package com.nullcognition.chapter6asyncprogress2;
/**
 * Created by ersin on 23/12/14 at 11:24 PM
 */
public interface IReportBack {

   void allDone(int status);
   void reportBack(String tag, String message);
   void reportTransient(String tag, String message);

}
