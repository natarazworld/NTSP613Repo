package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Person;
import com.nt.beans.Person1;

public class ValueAnnotationTest {
   public static void main(String[] args) {
	   //create IOC container
	   ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	   //get Spring bean class obj
	   Person per=ctx.getBean("per",Person.class);
	   System.out.println(per);
	   System.out.println("............................................");
	   Person1 per1=ctx.getBean("per1",Person1.class);
	   System.out.println(per1);
	   //close container
	   ((AbstractApplicationContext) ctx).close();
	
}
}
