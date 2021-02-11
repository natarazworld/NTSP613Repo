// ProblemTesWithDI .java
package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WebContainer;

public class SolutionWithTDLTest {

	public static void main(String[] args) {
		//create  IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println(".......................");
		//get Target Spring bean class obj
		WebContainer container=ctx.getBean("container",WebContainer.class);
		
		//invoke methods
		container.handleRequest("hi");
		System.out.println("..................");
		container.handleRequest("hello");
		System.out.println("..................");
		container.handleRequest("take care");
		
		
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
