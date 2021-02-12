//WebContainer.java (target Bean)
package com.nt.beans;

public  abstract class WebContainer  {
	
	public WebContainer() {
		System.out.println("WebContainer.0-param costructor()"+this.getClass());
	}
	
	public  abstract RequestHandler getHandler();
	
	public void  handleRequest(String data) {
		System.out.println("WebContainer ::request came for processing with data::"+data+"---->"+this.hashCode());
		//Trandtional Dependency lookup code
		RequestHandler rh=getHandler();
		rh.processingRequest(data);
		System.out.println("WebContainer :: request processing completed with data::"+data);
	}

	

}
