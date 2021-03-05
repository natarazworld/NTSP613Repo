package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonalInfo;

public class PropertyEditorsTest {

	public static void main(String[] args) {
		//create IOC container 
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean class object
		PersonalInfo info=ctx.getBean("pInfo",PersonalInfo.class);
		System.out.println(info);
		

	}

}
