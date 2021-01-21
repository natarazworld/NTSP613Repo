package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comps.PetrolEngine;
import com.nt.comps.Vehicle;

public class StrategyDPTest1 {

	public static void main(String[] args) {
		//create IOC container
		//ApplicationContext ctx=new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("...............");
		/*//create IOC container
				DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
				//create XmlBeanDefinitationReader object
				XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
				//Load and parse spring bean cfg file
				reader.loadBeanDefinitions("applicationContext.xml");*/
		
		/*	//get Target class obj
			Vehicle vehicle=factory.getBean("vehicle",Vehicle.class);
			//invoke methods
			vehicle.journey("hyd", "goa");*/
		
	}//main
}//class
