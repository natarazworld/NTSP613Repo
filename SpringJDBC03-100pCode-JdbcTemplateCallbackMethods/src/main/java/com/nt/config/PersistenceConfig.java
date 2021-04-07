package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="hkDs")
	public   DataSource createDataSource() {
		HikariDataSource hkDs=new HikariDataSource();
		hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkDs.setUsername("system");
		hkDs.setPassword("manager");
		hkDs.setIdleTimeout(100);
		hkDs.setMaximumPoolSize(200);
		return hkDs;
	}
	
	@Bean(name="jt")
	public   JdbcTemplate createJT() {
		return new JdbcTemplate(createDataSource());
	}

}
