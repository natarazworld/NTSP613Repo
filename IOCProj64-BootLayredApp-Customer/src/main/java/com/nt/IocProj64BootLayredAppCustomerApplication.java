package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class IocProj64BootLayredAppCustomerApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=SpringApplication.run(IocProj64BootLayredAppCustomerApplication.class, args);
		try {
			//get contoller class obj
			BankController controller=ctx.getBean("controller",BankController.class);
			//prepare VO class obj
			CustomerVO custVO=new CustomerVO("raja","hyd","100000","2","12");
			//invoke methods
			String result=controller.processCustomer(custVO);
			System.out.println("Intrest amount::"+result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
