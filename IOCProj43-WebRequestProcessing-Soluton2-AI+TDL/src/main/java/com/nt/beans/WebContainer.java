//WebContainer.java (target Bean)
package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WebContainer implements ApplicationContextAware {
	private String beanId;
	private ApplicationContext ctx;
	public WebContainer(String beanId) {
		this.beanId=beanId;
		System.out.println("WebContainer.WebContainer(-)");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
	System.out.println("WebContainer.setApplicationContext()");
		 this.ctx=ctx;
	}
	
	public void  handleRequest(String data) {
		System.out.println("WebContainer ::request came for processing with data::"+data+"---->"+this.hashCode());
		//Trandtional Dependency lookup code
		RequestHandler rh=ctx.getBean(beanId,RequestHandler.class);
		rh.processingRequest(data);
		System.out.println("WebContainer :: request processing completed with data::"+data);
	}

	

}
