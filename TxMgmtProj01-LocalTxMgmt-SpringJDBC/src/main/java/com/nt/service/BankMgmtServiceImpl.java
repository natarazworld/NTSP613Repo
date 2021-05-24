package com.nt.service;

import com.nt.dao.IBankDAO;

public class BankMgmtServiceImpl implements IBankMgmtService {
	private IBankDAO dao;
	
	public BankMgmtServiceImpl(IBankDAO dao) {
		 this.dao=dao;
	}

	@Override
	public String transferMoney(int srcAcno, int destAcno, double amount) {
		 int count1=dao.deposite(destAcno, amount);
		 int count2=dao.withdraw(srcAcno, amount);
		 if(count1==0 || count2==0)
			 throw new RuntimeException("Tx rollled back --->Moeny is not transfered");  //must be unchecked exception
		 else
		return " Tx committed ..  Money Transfered";
	}

}
