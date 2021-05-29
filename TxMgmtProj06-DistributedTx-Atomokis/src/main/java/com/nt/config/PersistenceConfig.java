package com.nt.config;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistenceConfig {
	
	/*@Bean(name="oraAksDs")
	public  AtomikosDataSourceBean  createAksDsBeanForOracle() {
		AtomikosDataSourceBean ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("oraXA");
		ds.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		 Properties props=new Properties();
		 props.setProperty("databaseName", "xe");
		 props.setProperty("user", "system");
		 props.setProperty("password", "manager");
		 props.setProperty("URL","jdbc:oracle:thin:@localhost:1521:xe");
		 ds.setXaProperties(props);
		 ds.setMaxPoolSize(1000);
		 ds.setMinPoolSize(10);
		 ds.setMaxIdleTime(2000);
		 return ds;
	}*/
	

	
	@Bean(name="oraAksDs")
	@ConfigurationProperties(prefix = "dtx.aksds.ora")
	public  AtomikosDataSourceBean  createAksDsBeanForOracle() {
		AtomikosDataSourceBean ds=new AtomikosDataSourceBean();
		 return ds;
	}
	
	@Bean(name="mysqlAksDs")
	@ConfigurationProperties(prefix = "dtx.aksds.mysql")
	public  AtomikosDataSourceBean  createAksDsBeanForMysql() {
		AtomikosDataSourceBean ds=new AtomikosDataSourceBean();
		 return ds;
	}
	
	/*@Bean(name="mysqlAksDs")
	public  AtomikosDataSourceBean  createAksDsBeanForMysql() {
		AtomikosDataSourceBean ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("mysqlXA");
		ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		 Properties props=new Properties();
		 props.setProperty("databaseName", "ntsp613db");
		 props.setProperty("user", "root");
		 props.setProperty("password", "root");
		 props.setProperty("URL","jdbc:mysql:///ntsp613db");
		 ds.setXaProperties(props);
		 ds.setMaxPoolSize(1000);
		 ds.setMinPoolSize(10);
		 ds.setMaxIdleTime(2000);
		 return ds;
	}*/
	
	@Bean(name="oraJT")
	public  JdbcTemplate createJTForOracle() {
		return new  JdbcTemplate(createAksDsBeanForOracle());
	}
	
	@Bean(name="mysqlJT")
	public  JdbcTemplate createJTForMySQL() {
		return new  JdbcTemplate(createAksDsBeanForMysql());
	}



}
