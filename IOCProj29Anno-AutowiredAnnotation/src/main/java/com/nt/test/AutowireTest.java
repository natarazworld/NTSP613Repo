//AutowireTest.java
package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Flipkart;

public class AutowireTest {

	public static void main(String[] args) {
		  //create  IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get target Bean object
			Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
			System.out.println(fpkt);
			//invoke methods
			 String msg=fpkt.shopping(new String[] {"shirt","trouser","shoe"}, new float[] {1799.0f,3000.0f,5000.0f});
			 System.out.println(msg);
		 
		//close container
		 ((AbstractApplicationContext) ctx).close();
	}
}
