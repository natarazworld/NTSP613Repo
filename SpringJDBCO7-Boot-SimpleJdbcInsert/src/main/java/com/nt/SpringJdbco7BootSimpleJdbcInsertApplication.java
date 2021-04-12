package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.model.ActorDetails;
import com.nt.service.IActorMgmtService;

@SpringBootApplication
public class SpringJdbco7BootSimpleJdbcInsertApplication {
	@Autowired
	private DataSource ds;
	
	@Bean(name="sji")
	public SimpleJdbcInsert createSJInsert() {
		return new SimpleJdbcInsert(ds);
	}

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=SpringApplication.run(SpringJdbco7BootSimpleJdbcInsertApplication.class, args);
		
		//get Bean
		IActorMgmtService  service=ctx.getBean("actorService",IActorMgmtService.class);
		try{
		//invoke b.method
		System.out.println(service.registerActor(new ActorDetails(621, "sahid", "mumbai",143553555L,235455.0)));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
