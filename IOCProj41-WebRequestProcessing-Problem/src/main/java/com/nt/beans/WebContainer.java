//WebContainer.java (target Bean)
package com.nt.beans;

public class WebContainer {
	private RequestHandler rh;
	
	public WebContainer(RequestHandler rh) {
		System.out.println("WebContainer.WebContainer(-)");
		 this.rh=rh;
	}
	
	public void  handleRequest(String data) {
		System.out.println("WebContainer ::request came for processing with data::"+data+"---->"+this.hashCode());
		rh.processingRequest(data);
		System.out.println("WebContainer :: request processing completed with data::"+data);
	}

}
