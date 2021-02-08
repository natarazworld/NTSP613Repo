package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.VoteElgibilityChecking;

public class SpringBeanLifeCycleTest_BF {

	public static void main(String[] args) {
		
	  //create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader  reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class obj
		VoteElgibilityChecking  checking=factory.getBean("voting",VoteElgibilityChecking.class);
		//invoke methods
		System.out.println(checking.checkElgibility());
		
		//destroy singletons
		//factory.destroySingletons();

	}//main
}//class
