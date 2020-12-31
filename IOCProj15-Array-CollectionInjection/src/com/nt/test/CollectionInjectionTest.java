package com.nt.test;

import java.util.Date;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.College;
import com.nt.beans.CourseInfo;
import com.nt.beans.FacultyInfo;
import com.nt.beans.FruitStore;
import com.nt.beans.Student;


public class CollectionInjectionTest {

	public static void main(String[] args) {
		
	//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean obj
		College clg=factory.getBean("clg",College.class);
		System.out.println("clg data is ::"+clg);
		System.out.println("----------------------------");
		Student st=factory.getBean("stud",Student.class);
		System.out.println(st);
		System.out.println("-----------------------------------");
		FacultyInfo info=factory.getBean("info",FacultyInfo.class);
		System.out.println(info);
		System.out.println(".....................................");
		FruitStore store=factory.getBean("store",FruitStore.class);
		System.out.println(store);
		System.out.println(".....................................");
		CourseInfo cinfo=factory.getBean("course",CourseInfo.class);
		System.out.println(cinfo);
		
		

	}//main
}//class
