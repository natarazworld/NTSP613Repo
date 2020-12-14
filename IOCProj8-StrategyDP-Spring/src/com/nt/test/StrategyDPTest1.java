package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.comps.Vehicle;

public class StrategyDPTest1 {

	public static void main(String[] args) {
	   //create IOC container
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get Target class obj
		Vehicle vehicle=factory.getBean("vehicle",Vehicle.class);
		//invoke methods
		vehicle.journey("hyd", "goa");
	}//main
}//class
