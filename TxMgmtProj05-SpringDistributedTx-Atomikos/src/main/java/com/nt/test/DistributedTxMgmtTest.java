package com.nt.test;

import java.sql.SQLDataException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankMgmtService;

public class DistributedTxMgmtTest {

	public static void main(String[] args) {
		//create IOC container
		  ClassPathXmlApplicationContext ctx=new  ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		  //get Proxy class object
		  IBankMgmtService  proxy=ctx.getBean("bankService",IBankMgmtService.class);
		  //invoke methods
		  try {
			  System.out.println("Result:::"+proxy.transferMoney(1001,1008,2000.0));
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  //close container
		  ctx.close();
	}//main
}//class
