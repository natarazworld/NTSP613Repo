package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.BankService;

@SpringBootApplication
public class AspectjAOPAroundAdviceTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=SpringApplication.run(AspectjAOPAroundAdviceTest.class, args);
		//get Proxy class obj
		BankService proxy=ctx.getBean("bank",BankService.class);
		System.out.println(proxy.getClass()+"   "+proxy.getClass().getSuperclass());
		//invoke the methods
		System.out.println("Simple Intrest amount::"+proxy.calcSimpleIntrestAmount(100000, 2, 12));
		System.out.println("-----------------------");
		System.out.println("Simple Intrest amount1::"+proxy.calcSimpleIntrestAmount(100000, 2, 12));
		System.out.println("===============");
		System.out.println("compound Intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 2, 12));
		System.out.println("-----------------------");
		System.out.println("compound Intrest amount1::"+proxy.calcCompoundIntrestAmount(100000, 2, 12));
		
		//close container
		 ((ConfigurableApplicationContext) ctx).close();
		

	}

}
