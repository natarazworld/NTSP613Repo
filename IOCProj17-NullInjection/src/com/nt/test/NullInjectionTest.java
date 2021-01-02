// NullInjectionTest .java
package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.PersonalInfo;

public class NullInjectionTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get spring bean objs
		PersonalInfo rajaInfo=factory.getBean("rajaInfo",PersonalInfo.class);
		System.out.println(rajaInfo);
		System.out.println("--------------------------");
		PersonalInfo rameshInfo=factory.getBean("rameshInfo",PersonalInfo.class);
		System.out.println(rameshInfo);
		System.out.println("--------------------------");
		PersonalInfo anilInfo=factory.getBean("anilInfo",PersonalInfo.class);
		System.out.println(anilInfo);
	}//main
}//class
