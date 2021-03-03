package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.comps.Vehicle;
import com.nt.config.AppConfig;

public class StrategyDPTest1 {

	public static void main(String[] args) {
	   //create IOC container
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Target class obj
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		//invoke methods
		vehicle.journey("hyd", "goa");
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
