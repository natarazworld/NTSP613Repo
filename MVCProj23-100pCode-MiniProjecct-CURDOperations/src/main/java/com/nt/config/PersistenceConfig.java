package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="jofb")
	public JndiObjectFactoryBean createJOFB() {
		 JndiObjectFactoryBean  bean=new JndiObjectFactoryBean();
		 bean.setJndiName("java:/comp/env/DsJndi");
		 return bean;
	}
	
	@Bean(name="template")
	public  JdbcTemplate createJdbcTemplate() {
		return  new JdbcTemplate((DataSource) createJOFB().getObject());
	}

}
