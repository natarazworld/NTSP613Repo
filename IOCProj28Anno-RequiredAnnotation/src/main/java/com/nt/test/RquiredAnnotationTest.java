package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Robot;

public class RquiredAnnotationTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class obj
		Robot  robot=ctx.getBean("robot",Robot.class);
		System.out.println(robot);

	}

}
