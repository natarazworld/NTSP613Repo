package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Customer;

public class FactoryBeanTest {

	public static void main(String[] args) {
			//create IOC container
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get Bean class object
		 Customer cust=ctx.getBean("cust",Customer.class);
		 System.out.println("......................");
		 //show details
		 cust.showProductDetials();
		 System.out.println("......................");
		 //close container
		 ((AbstractApplicationContext) ctx).close();

	}

}
