package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		// Hold the name and location of spring bean file
	   //Resource res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Resource res=new FileSystemResource("G:\\Worskpaces\\Spring\\ntsp613\\IOCProj4-ConstructorInjection\\src\\com\\nt\\cfgs\\applicationContext.xml");
		
		//Resource res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		Resource res=new ClassPathResource("applicationContext.xml");
		//create  IOC container
		BeanFactory factory=new XmlBeanFactory(res);
		//get target Spring bean class object 
		WishMessageGenerator generator=(WishMessageGenerator) factory.getBean("wmg");
		//invoke the b.method
		System.out.println("result="+generator.generateWishMessage("raja"));
	}//main
}//class
