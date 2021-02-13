//WebContainer.java (target Bean)
package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("container")
@Scope("singleton")
public interface WebContainer  {
	
	@Lookup
	public   RequestHandler getHandler();
	
	default void  handleRequest(String data) {
		System.out.println("WebContainer ::request came for processing with data::"+data+"---->"+this.hashCode());
		//Trandtional Dependency lookup code
		RequestHandler rh=getHandler();
		rh.processingRequest(data);
		System.out.println("WebContainer :: request processing completed with data::"+data);
	}
}
