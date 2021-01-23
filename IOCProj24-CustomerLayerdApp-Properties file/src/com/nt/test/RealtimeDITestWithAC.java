package com.nt.test;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

public class RealtimeDITestWithAC {

	public static void main(String[] args) {
		
		System.out.println(System.getProperties());
		
		//create   IOC container
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Controller class obj from IOC contaienr
		BankController controller=ctx.getBean("controller",BankController.class);
		//read inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter customer name::");
		String name=sc.next();
		System.out.println("Enter customer address::");
		String addrs=sc.next();
		System.out.println("Enter Pinciple amount::");
		String pAmt=sc.next();
		System.out.println("Enter Rate of Intrest::");
		String rate=sc.next();
		System.out.println("Enter Time of Intrest::");
		String time=sc.next();
		//create CustomerVO class obj having all inputs
		CustomerVO vo=new CustomerVO();
		vo.setCname(name); vo.setCadd(addrs);
		vo.setpAmt(pAmt); vo.setRate(rate); vo.setTime(time);
		//invoke method
		try {
			//use controller classs
			String result=controller.processCustomer(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			  System.out.println("Problem in Customer Registration");
			e.printStackTrace();
		}
		
		Environment  env=((ClassPathXmlApplicationContext)ctx).getEnvironment();
		System.out.println(env.getClass());
		System.out.println(env.getProperty("os.name"));
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}//main
}//class
