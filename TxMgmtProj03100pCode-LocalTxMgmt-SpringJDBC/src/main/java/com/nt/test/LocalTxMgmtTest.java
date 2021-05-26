package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.IBankMgmtService;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=new  AnnotationConfigApplicationContext(AppConfig.class);
		//get service class object
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		//invoke methods
		try {
			System.out.println(proxy.transferMoney(1006, 1002, 5000.0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		ctx.close();

	}

}
