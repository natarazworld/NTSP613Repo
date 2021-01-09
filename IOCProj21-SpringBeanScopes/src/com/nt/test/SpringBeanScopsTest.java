package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Printer;
import com.nt.beans.WishMessageGenerator;

public class SpringBeanScopsTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader  reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
			//get Spring bean class obj
			WishMessageGenerator generator=factory.getBean("wmg",WishMessageGenerator.class);
			WishMessageGenerator generator1=factory.getBean("wmg",WishMessageGenerator.class);
			WishMessageGenerator generator2=factory.getBean("wmg1",WishMessageGenerator.class);
			System.out.println(generator.hashCode()+" "+generator1.hashCode()+"  "+generator2.hashCode());
			System.out.println("generator==generator1?"+(generator==generator1));
			System.out.println("generator1==generator2?"+(generator1==generator2)); 
			
/*WishMessageGenerator generator=factory.getBean("wmg",WishMessageGenerator.class);
WishMessageGenerator generator1=factory.getBean("wmg1",WishMessageGenerator.class);
System.out.println(generator.hashCode()+"   "+generator1.hashCode());*/
		
/* Printer pr1=factory.getBean("p1",Printer.class);
 Printer pr2=factory.getBean("p1",Printer.class);
 Printer pr3=factory.getBean("p1",Printer.class);
 	 
	 System.out.println( pr1.hashCode()+"  "+pr2.hashCode()+"  "+pr3.hashCode()); */
		 
		 
		
	}
}
