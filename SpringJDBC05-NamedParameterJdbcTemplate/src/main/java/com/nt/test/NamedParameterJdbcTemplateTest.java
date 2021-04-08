package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.BookInfo;
import com.nt.service.IBookStoreMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		  //create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class obj
		IBookStoreMgmtService service=ctx.getBean("bookService",IBookStoreMgmtService.class);
		//invoke method
		  try {
			  BookInfo info=service.fetchBookById(1010);
			  System.out.println(info);
		  }
		  catch(DataAccessException dae) {
			  dae.printStackTrace();
		  }
		
		//close container
		  ((AbstractApplicationContext) ctx).close();
	}
}
