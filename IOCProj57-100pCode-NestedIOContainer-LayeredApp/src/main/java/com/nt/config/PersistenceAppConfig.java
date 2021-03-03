package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value = "com/nt/commons/jdbc.properties")
public class PersistenceAppConfig {
	 @Autowired
	private  Environment env;
	
	@Bean("hkDs")
	public  HikariDataSource  createDataSource() {
		HikariDataSource  ds=new HikariDataSource();
		ds.setDriverClassName(env.getRequiredProperty("ds.driver"));
		ds.setJdbcUrl(env.getRequiredProperty("ds.url"));
		ds.setUsername(env.getRequiredProperty("ds.user"));
		ds.setPassword(env.getRequiredProperty("ds.pwd"));
		ds.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("ds.minsize")));
		ds.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("ds.maxsize")));
		return ds;
	}
	

}
