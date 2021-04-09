package com.nt.test;

import java.util.List;

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
		  System.out.println("====================");
		  
		  try {
			  List<BookInfo> list=service.fetchBooksByCategories("JAVA",".NET","PHP");
			  list.forEach(System.out::println);
		  }
		  catch(DataAccessException dae) {
			  dae.printStackTrace();
		  }
		  
		  System.out.println("=====================");
		  
		  try {
			  BookInfo info=new BookInfo();
			  info.setBookName("SIJ");
			  info.setAuthor("MP");
			  info.setCategory("JAVA");
			  info.setPrice(9000.0f);
			  info.setStatus("NO");
			System.out.println(service.addBook(info));
		  }
		  catch(DataAccessException dae) {
			  dae.printStackTrace();
		  }
		
		//close container
		  ((AbstractApplicationContext) ctx).close();
	}
}
