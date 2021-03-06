package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.BankLoanIntrestCalculator;
import com.nt.beans.IntrestAmountDetails;
import com.nt.editor.IntrestAmountDetailsEditor;

public class CustomPropertyEditorTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//add   new PERegistrar to   IOC container
		factory.addPropertyEditorRegistrar(new MyPERegistrar());
		
		//get Target spring bean class object
		BankLoanIntrestCalculator calculator=factory.getBean("blic",BankLoanIntrestCalculator.class);
		System.out.println("Intrest amount:"+calculator.calculateIntrestAmount());
	}
	
     //static inner class /Nested class
	  private static class  MyPERegistrar implements PropertyEditorRegistrar{

		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
			 registry.registerCustomEditor(IntrestAmountDetails.class,new IntrestAmountDetailsEditor());
		}//registerCustomEditors
		  
	  }//inner class
	
}//outer class
