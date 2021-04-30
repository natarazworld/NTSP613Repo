package com.nt.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;


public class AspectjAOPAroundAdviceTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class obj
		IBankService proxy=ctx.getBean("bankService",IBankService.class);
		System.out.println(proxy.getClass()+" ....  "+proxy.getClass().getSuperclass()+" ....  "+Arrays.toString(proxy.getClass().getInterfaces()));
		//invoke the methods
		System.out.println("Simple Intrest amount::"+proxy.calcSimpleIntrestAmount(100000, 2, 12));
		System.out.println("-----------------------");
		System.out.println("Simple Intrest amount1::"+proxy.calcSimpleIntrestAmount(100000, 2, 12));
		System.out.println("===============");
		System.out.println("compound Intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 2, 12));
		System.out.println("-----------------------");
		System.out.println("compound Intrest amount1::"+proxy.calcCompoundIntrestAmount(100000, 2, 12));
		
		//close container
		 ctx.close();
		

	}

}
