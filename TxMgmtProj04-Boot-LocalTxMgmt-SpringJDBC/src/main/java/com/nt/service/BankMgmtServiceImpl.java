package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IBankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	@Autowired
	private IBankDAO dao;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,
	                        rollbackFor = IllegalAccessException.class,
	                        transactionManager = "transactionManager")
	public String transferMoney(int srcAcno, int destAcno, double amount)throws IllegalAccessException {
		
		int count1=dao.deposite(destAcno, amount);
		 int count2=dao.withdraw(srcAcno, amount);
		 
		  
		 if(count1==0 || count2==0)
			// throw new RuntimeException("Tx rollled back --->Moeny is not transfered");  //must be unchecked exception
			 throw new IllegalAccessException("Tx rollled back --->Moeny is not transfered");  //must be unchecked exception
		 else
		return " Tx committed ..  Money Transfered";
	}

}
