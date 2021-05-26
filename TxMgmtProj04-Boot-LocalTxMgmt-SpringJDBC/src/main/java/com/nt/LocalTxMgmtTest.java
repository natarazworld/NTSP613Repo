package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IBankMgmtService;

@SpringBootApplication
public class LocalTxMgmtTest {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(LocalTxMgmtTest.class, args);
		//get service class object
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		//invoke methods
		try {
			System.out.println(proxy.transferMoney(1001, 1002, 5000.0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();

	}

}
