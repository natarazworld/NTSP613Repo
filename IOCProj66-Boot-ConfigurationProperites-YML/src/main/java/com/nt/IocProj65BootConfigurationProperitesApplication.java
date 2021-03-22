package com.nt;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Person;

@SpringBootApplication
public class IocProj65BootConfigurationProperitesApplication {

	public static void main(String[] args) {
		//get IOC container
		//ApplicationContext ctx=SpringApplication.run(IocProj65BootConfigurationProperitesApplication.class, args);
		 SpringApplication application=new SpringApplication();
		 application.setBannerMode(Mode.CONSOLE);
		 ApplicationContext ctx=application.run(IocProj65BootConfigurationProperitesApplication.class,args);
		// get Bean
		Person per=ctx.getBean("pb",Person.class);
		System.out.println(per);
	}

}
