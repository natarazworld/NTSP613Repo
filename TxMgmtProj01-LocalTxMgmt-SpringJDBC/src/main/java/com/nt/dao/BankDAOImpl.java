package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;


public class BankDAOImpl implements IBankDAO {
	private static final String  BANK_WITHDRAW="UPDATE SPRING_TX_BANK SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String  BANK_DEPOSITE="UPDATE SPRING_TX_BANK SET BALANCE=BALANCE+? WHERE ACCNO=?";
	private  JdbcTemplate jt;
	
	public BankDAOImpl(JdbcTemplate jt) {
		this.jt=jt;
	}
	

	@Override
	public int withdraw(int accno, double amount) {
		int count=jt.update(BANK_WITHDRAW,amount,accno);
		return count;
	}

	@Override
	public int deposite(int accno, double amount) {
		int count=jt.update(BANK_DEPOSITE,amount,accno);				
		return count;
	}

}
