package com.nullcognition.chapter6asyncprogress;
/**
 * Created by ersin on 20/12/14 at 11:55 PM
 */


public interface IReportBack {

   public void reportBack(String tag, String message);
   public void reportTransient(String tag, String message);
}
