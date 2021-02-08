// SpringBeanLifeCycleTest.java
package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoteElgibilityChecking;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		
	  //create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class obj
		VoteElgibilityChecking  checking=ctx.getBean("voting",VoteElgibilityChecking.class);
		//invoke methods
		System.out.println(checking.checkElgibility());
		//close container
		((AbstractApplicationContext) ctx).close(); 

	}

}
