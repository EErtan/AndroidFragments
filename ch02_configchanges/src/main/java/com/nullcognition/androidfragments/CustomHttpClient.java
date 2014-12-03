package com.nullcognition.androidfragments;
/**
 * Created by ersin on 03/12/14 at 12:08 AM
 */
public class CustomHttpClient {

   private static org.apache.http.client.HttpClient httpClient;
   private CustomHttpClient(){}

   public static synchronized org.apache.http.client.HttpClient getHttpClient(){

	  if(httpClient == null){
		 org.apache.http.params.HttpParams params = new org.apache.http.params.BasicHttpParams();
		 org.apache.http.params.HttpProtocolParams.setVersion(params, org.apache.http.HttpVersion.HTTP_1_1);
		 org.apache.http.params.HttpProtocolParams.setContentCharset(params, org.apache.http.protocol.HTTP.DEFAULT_CONTENT_CHARSET);
		 org.apache.http.params.HttpProtocolParams.setUseExpectContinue(params, true);

		 org.apache.http.conn.params.ConnManagerParams.setTimeout(params, 1000);

		 org.apache.http.params.HttpConnectionParams.setConnectionTimeout(params, 5000);
		 org.apache.http.params.HttpConnectionParams.setSoTimeout(params, 10000);

		 org.apache.http.conn.scheme.SchemeRegistry schReg = new org.apache.http.conn.scheme.SchemeRegistry();
		 schReg.register(new org.apache.http.conn.scheme.Scheme("http",
									org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory(), 80));
		 schReg.register(new org.apache.http.conn.scheme.Scheme("https",
									org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
		 org.apache.http.conn.ClientConnectionManager conMgr = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager(params,schReg);

		 httpClient = new org.apache.http.impl.client.DefaultHttpClient(conMgr, params);
	  }
	  return httpClient;
   }
}
