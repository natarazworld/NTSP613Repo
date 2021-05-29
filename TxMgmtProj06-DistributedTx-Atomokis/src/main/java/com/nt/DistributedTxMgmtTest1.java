package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IBankMgmtService;

@SpringBootApplication
public class DistributedTxMgmtTest1 {

	public static void main(String[] args) {
		//get IOC container
		  ApplicationContext ctx=SpringApplication.run(DistributedTxMgmtTest.class,args);
		  //get Proxy class object
		  IBankMgmtService  proxy=ctx.getBean("bankService",IBankMgmtService.class);
		  System.out.println(proxy.getClass()+"   "+proxy.getClass().getSuperclass());
		  //invoke methods
		  try {
			  System.out.println("Result:::"+proxy.transferMoney(1001,1002,2000.0));
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  //close container
		  ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
