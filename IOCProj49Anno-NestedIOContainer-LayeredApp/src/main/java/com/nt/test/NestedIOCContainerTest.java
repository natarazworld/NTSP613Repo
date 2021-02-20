package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;

public class NestedIOCContainerTest {

	public static void main(String[] args) {
		//create parent IOC cntainer
		ClassPathXmlApplicationContext pCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		//create Child IOC container
		ClassPathXmlApplicationContext cCtx=
				 new ClassPathXmlApplicationContext(new String[]{"com/nt/cfgs/presentation-beans.xml"},pCtx);
		//get Controller obj
		MainController controller=cCtx.getBean("controller",MainController.class);
		//invoke methods
		try {
			controller.showEmpsByDesgs("CLERK", "MANAGER","SALESMAN").forEach(dto->{
				System.out.println(dto);
			});
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close container
		cCtx.close();
		pCtx.close();

	}//main
}//class
