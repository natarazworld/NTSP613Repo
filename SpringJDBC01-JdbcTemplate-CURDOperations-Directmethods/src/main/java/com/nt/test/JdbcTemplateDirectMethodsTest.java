package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dao.IEmployeeDAO;
import com.nt.service.IEmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target class object
		IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
		//invoke methods
		System.out.println("EmpsCount::"+service.fetchEmpsCount());
		//close IOC container
		((AbstractApplicationContext) ctx).close();

	}

}
