//InjectionTest.java
package com.nt.test;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;

public class InjectionTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		/*			//get Target spring bean class object
					WishMessageGeneartor generator=ctx.getBean("wmg",WishMessageGeneartor.class);
					//invoke b.method
					System.out.println("Wish Message is ::"+generator.geneateWishMessage("raja"));
		*/		
		
				//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
