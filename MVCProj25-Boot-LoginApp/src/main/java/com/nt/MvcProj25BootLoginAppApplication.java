package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@SpringBootApplication
public class MvcProj25BootLoginAppApplication {
	@Autowired
	private DataSource ds;
	
	@Bean(name="sji")
	public  SimpleJdbcCall createSJCall() {
		return  new SimpleJdbcCall(ds);
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcProj25BootLoginAppApplication.class, args);
	}

}
