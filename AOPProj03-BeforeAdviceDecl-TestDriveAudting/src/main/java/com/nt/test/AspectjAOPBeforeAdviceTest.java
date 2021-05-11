package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class AspectjAOPBeforeAdviceTest {

	public static void main(String[] args) {
		//create  IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		CarShowRoom proxy=ctx.getBean("showroom",CarShowRoom.class);
		System.out.println(proxy.getClass()+"----->"+proxy.getClass().getSuperclass());
		//invoke method
		try {
			System.out.println(proxy.sellCar("raja", "beleano", 1200000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("=============================");
		//invoke method
				try {
					System.out.println(proxy.sellCar("rajesh", "brizza", 1500000));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				//close the container
				ctx.close();

	}

}
