package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankMgmtService;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new  ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service class object
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		//invoke methods
		try {
			System.out.println(proxy.transferMoney(1002, 1001, 5000.0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		ctx.close();

	}

}
