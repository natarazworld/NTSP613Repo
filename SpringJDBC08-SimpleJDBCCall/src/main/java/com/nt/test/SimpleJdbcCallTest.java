package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ILoginMgmtService;
import com.nt.service.LoginMgmtServiceImpl;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get SErvice class obj
		ILoginMgmtService service=ctx.getBean("loginService",ILoginMgmtService.class);
		//invoke methods
		System.out.println(service.login("raja", "rani1"));
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
