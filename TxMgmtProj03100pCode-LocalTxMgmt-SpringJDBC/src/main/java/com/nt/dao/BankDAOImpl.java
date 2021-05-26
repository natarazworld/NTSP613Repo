package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements IBankDAO {
	private static final String  BANK_WITHDRAW="UPDATE SPRING_TX_BANK SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String  BANK_DEPOSITE="UPDATE SPRING_TX_BANK SET BALANCE=BALANCE+? WHERE ACCNO=?";
	@Autowired
	private  JdbcTemplate jt;
	
	

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
