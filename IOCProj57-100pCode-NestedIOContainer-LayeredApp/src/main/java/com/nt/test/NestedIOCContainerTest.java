package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationAppConfig;
import com.nt.controller.MainController;

public class NestedIOCContainerTest {

	public static void main(String[] args) {
		//create parent IOC cntainer
		AnnotationConfigApplicationContext pCtx=new AnnotationConfigApplicationContext(BusinessAppConfig.class);
		//create Child IOC container
		/*AnnotationConfigApplicationContext cCtx=new AnnotationConfigApplicationContext(PresentationAppConfig.class);
		cCtx.setParent(pCtx);*/
		AnnotationConfigApplicationContext cCtx=new AnnotationConfigApplicationContext();
		cCtx.setParent(pCtx);
		cCtx.register(PresentationAppConfig.class);
		cCtx.refresh();
		
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
