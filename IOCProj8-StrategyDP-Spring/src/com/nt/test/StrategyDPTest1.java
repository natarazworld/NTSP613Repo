package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.comps.Vehicle;

public class StrategyDPTest1 {

	public static void main(String[] args) {
	   //create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		//create XmlBeanDefinitationReader object
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		//Load and parse spring bean cfg file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//get Target class obj
		Vehicle vehicle=factory.getBean("vehicle",Vehicle.class);
		//invoke methods
		vehicle.journey("hyd", "goa");
	}//main
}//class
