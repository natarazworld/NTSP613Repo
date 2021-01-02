package com.nt.test;

import java.util.Date;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.SampleBean;

public class DefaultBeanIdsTest {

	public static void main(String[] args) {
		
	//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class objects
		SampleBean bean1=factory.getBean("com.nt.beans.SampleBean#0",SampleBean.class);
		System.out.println("bean1 data::"+bean1);
		SampleBean bean2=factory.getBean("com.nt.beans.SampleBean",SampleBean.class);
		System.out.println("bean2 data::"+bean2);
		SampleBean bean3=factory.getBean("com.nt.beans.SampleBean#1",SampleBean.class);
		System.out.println("bean3 data::"+bean3);
		SampleBean bean4=factory.getBean("com.nt.beans.SampleBean#2",SampleBean.class);
		System.out.println("bean4 data::"+bean4);
		System.out.println("-------------------------------------");
		Date d1=factory.getBean("java.util.Date",Date.class);
		System.out.println("d1 obj data::"+d1);
		Date d2=factory.getBean("java.util.Date#0",Date.class);
		System.out.println("d2 obj data::"+d2);
		Date d3=factory.getBean("java.util.Date#1",Date.class);
		System.out.println("d3 obj data::"+d3);
		
		
		
		
		

	}

}
