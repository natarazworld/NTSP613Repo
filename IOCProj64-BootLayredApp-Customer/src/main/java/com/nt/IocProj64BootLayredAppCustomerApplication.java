package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class IocProj64BootLayredAppCustomerApplication {
	@Autowired
	private Environment env;

	
	/*@Bean(name="c3pODS")
	public   DataSource createC3PODS() throws Exception{
		ComboPooledDataSource ds=new ComboPooledDataSource();
		ds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		ds.setUser(env.getRequiredProperty("spring.datasource.username"));
		ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return ds;
	}*/
	
	
	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=SpringApplication.run(IocProj64BootLayredAppCustomerApplication.class, args);
		try {
			//get contoller class obj
			BankController controller=ctx.getBean("controller",BankController.class);
			//prepare VO class obj
			CustomerVO custVO=new CustomerVO("raja","hyd","100000","2","12");
			//invoke methods
			String result=controller.processCustomer(custVO);
			System.out.println("Intrest amount::"+result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
