//RequestHandler.java
package com.nt.beans;

public class RequestHandler {
   private static int count;
	public RequestHandler() {
		count++;
		System.out.println("RequestHandler.0-param constructor::"+count);
	}
	
	public  void processingRequest(String data) {
		System.out.println("RequestHandler :: processing the request  with ::"+data+"---->"+this.hashCode()+"..."+count);
	}
	
	
}
