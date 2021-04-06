package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

public class CallbackMethodsTest {

	public static void main(String[] args) {
	   //create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class obj
		IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
		//invoke method
		try {
			System.out.println("7499 Emp details are ::"+service.fetchEmployeeByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("=================================");
		try {
			System.out.println("Employees having CLERK,MANAGER,SALESMAN Desgs are ");
			List<EmployeeDTO> listDTO=service.fetchEmployeesByDesg("CLERK", "MANAGER", "SALESMAN");
			listDTO.forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
