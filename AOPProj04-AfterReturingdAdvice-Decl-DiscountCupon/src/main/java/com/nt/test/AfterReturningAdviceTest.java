package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.OnlineStore;

public class AfterReturningAdviceTest {

	public static void main(String[] args) {
		//create  IOC container
		 ClassPathXmlApplicationContext  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get Proxy class object
		 OnlineStore proxy=ctx.getBean("store",OnlineStore.class);
		 //invoke target method
		 try {
			 System.out.println("Bill Amount::"+proxy.shopping(new String[] {"cap","haleem,","K-P","cent"},
					                                                                                  new double[] {200,300,134000,1000}));
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 //close container
		 ctx.close();

	}//main
}//class
