package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.BankLoanIntrestCalculator;
import com.nt.config.AppConfig;

public class CustomPropertyEditorTest4WithAC {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Target spring bean class object
		BankLoanIntrestCalculator calculator=ctx.getBean("blic",BankLoanIntrestCalculator.class);
		System.out.println("Intrest amount:"+calculator.calculateIntrestAmount());
	}
	
}//outer class
