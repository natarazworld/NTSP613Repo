//WebContainer.java (target Bean)
package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer {
	private String beanId;
	
	public WebContainer(String beanId) {
		this.beanId=beanId;
		System.out.println("WebContainer.WebContainer(-)");
	}
	
	public void  handleRequest(String data) {
		System.out.println("WebContainer ::request came for processing with data::"+data+"---->"+this.hashCode());
		//Trandtional Dependency lookup code
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		RequestHandler rh=ctx.getBean(beanId,RequestHandler.class);
		rh.processingRequest(data);
		System.out.println("WebContainer :: request processing completed with data::"+data);
	}

}
