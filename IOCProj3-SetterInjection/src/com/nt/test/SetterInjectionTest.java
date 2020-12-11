package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		// Hold the name and location of spring bean file
	   FileSystemResource res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create  IOC container
		XmlBeanFactory factory=new XmlBeanFactory(res);
		//get target Spring bean class object 
		WishMessageGenerator generator=(WishMessageGenerator) factory.getBean("wmg");
		//invoke the b.method
		System.out.println("result="+generator.generateWishMessage("raja"));
	}//main
}//class
