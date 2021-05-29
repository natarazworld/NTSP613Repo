package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AOPConfig {

	 @Bean(name="aksDTxService")
	 public UserTransactionImp  createAksDTxService() {
		 return new  UserTransactionImp();
	 }
	 
	 @Bean(name="aksDTxMgmr")
	 public   UserTransactionManager  createAksDTxMgmr() {
		 return  new UserTransactionManager();
	 }
	 
	 @Bean(name="jtaTxMgmr")
	 public JtaTransactionManager   createJTATxMgmr() {
		JtaTransactionManager  jtaTxMgmr=new JtaTransactionManager();
		jtaTxMgmr.setUserTransaction(createAksDTxService());
		jtaTxMgmr.setTransactionManager(createAksDTxMgmr());
		return jtaTxMgmr;
	 }
	
}
