package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class IOCProj63BootBasicAppApplication {
	
	@Bean(name="dt")
	public  LocalDateTime createLocalDateTime() {
		return  LocalDateTime.now();
	}
	

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(IOCProj63BootBasicAppApplication.class, args);
		//get  Target class obj
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(generator.generateWishMessage("raja"));
		//close contianer
		((ConfigurableApplicationContext) ctx).close();
	}

}
