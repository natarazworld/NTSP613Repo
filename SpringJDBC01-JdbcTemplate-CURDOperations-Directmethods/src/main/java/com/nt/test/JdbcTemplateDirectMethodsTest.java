package com.nt.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.nt.service.IEmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target class object
		IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
		
		//invoke methods
		try {
		System.out.println("EmpsCount::"+service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("=============================");
		try {
		   System.out.println("Emp salary::"+service.fetchEmpSalaryByEno(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("=============================");
		try {
		   //System.out.println("7499 Emp Details are::"+service.fetchEmployeeDetailsByEno(7499));
			Map<String,Object> map=service.fetchEmployeeDetailsByEno(7499);
			map.entrySet().forEach(row->{
				System.out.println(row.getKey()+"   "+row.getValue());
			});
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("=============================");
		try {
		 //  System.out.println("CLERK Desg Emp Details are::"+service.fetchEmployeeDetailsByDesgs("CLERK","MANAGER","SALESMAN"));
			System.out.println("CLERK Desg Emp Details are::");
		    service.fetchEmployeeDetailsByDesgs("CLERK","MANAGER","SALESMAN").forEach(map->{
		    	map.entrySet().forEach(row->{
		    		System.out.println(row.getKey()+"  "+row.getValue());
		    	});
		    	System.out.println("\n");
		    });
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		
		System.out.println("=============================");
		try {
			System.out.println("2000 to 6000 salary range Emp Details are::");
			SqlRowSet rowset=service.fetchEmployeeDetailsBySalRange(2000.0f, 6000.0f);
			while(rowset.next()) {
				System.out.println(rowset.getInt(1)+"  "+rowset.getString(2)+"  "+rowset.getString(3)+"  "+rowset.getFloat(4));
			}
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		

		//close IOC container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
