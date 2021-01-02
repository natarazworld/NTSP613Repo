//FactoryMethodBeanInstantiationTest.java
package com.nt.test;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMethodBeanInstantiationTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean class obj
		Calendar cal=factory.getBean("cal",Calendar.class);
		System.out.println("cal obj class::"+cal.getClass()+ "---->cal obj data::"+cal.toString());
		System.out.println("---------------------");
		Class  clazz=factory.getBean("clazz",Class.class);
		System.out.println("clazz obj class::"+clazz.getClass()+ "---->clazz obj data::"+clazz.toString());
		System.out.println("------------------------------");
		Properties props=factory.getBean("props",Properties.class);
		System.out.println("props obj class::"+props.getClass()+ "---->props obj data::"+props.toString());
		System.out.println("--------------------------------");
		String  str1=factory.getBean("s2",String.class);
		System.out.println("str1 obj class::"+str1.getClass()+ "---->str1 obj data::"+str1.toString());
		System.out.println("--------------------------------");
		String  str2=factory.getBean("s3",String.class);
		System.out.println("str2 obj class::"+str2.getClass()+ "---->str2 obj data::"+str2.toString());
		
		System.out.println("--------------------------------");
		Iterator it=factory.getBean("it",Iterator.class);
		System.out.println("it obj class::"+it.getClass()+ "---->it obj data::"+it.toString());
	
	
				

	}

}
