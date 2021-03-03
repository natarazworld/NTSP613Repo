//AppConfig.java
package com.nt.config;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")
public class AppConfig {
	
	static {
		System.out.println("AppConfig:: static block");
	}
	
	public AppConfig() {
		System.out.println("AppConfig:: 0-param constructor");
	}
	
	@Bean(value="dt")
	public  LocalDateTime createDate() {
		System.out.println("AppConfig.createDate()");
		return   LocalDateTime.now();
	}
	
		@Bean(value="dt1")
		@Primary
		public  LocalDateTime createDate1() {
			System.out.println("AppConfig.createDate1()");
			return   LocalDateTime.now();
		}
		
		
		@Bean(value="dt2")
		@Primary
		public  Date createDate2() {
			System.out.println("AppConfig.createDate2()");
			return   new Date();
		}
	

}
