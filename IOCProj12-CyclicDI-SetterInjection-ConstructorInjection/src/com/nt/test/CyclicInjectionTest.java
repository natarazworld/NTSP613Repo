//CyclicInjectionTest.java
package com.nt.test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.nt.beans.A;
import com.nt.beans.B;
public class CyclicInjectionTest {
	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		//create XmlBeanDefinitationReader
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		//load spring bean cfg file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean obj
		A  a=factory.getBean("a1",A.class);
		System.out.println(a);
		
		/*System.out.println("----------------");
		B  b=factory.getBean("b1",B.class);
		System.out.println(b);*/
		
	}
}
