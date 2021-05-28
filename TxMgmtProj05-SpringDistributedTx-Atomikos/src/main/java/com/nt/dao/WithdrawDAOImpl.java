package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("wDAO")
public class WithdrawDAOImpl implements IWithdrawDAO {
	private  static  final String  WITHDRAW_QUERY="UPDATE DTX_BANK_ACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
		@Autowired
	@Qualifier("oraTemplate")
	private  JdbcTemplate jt;


		
			@Override
	public int withdraw(long accno, double amount) {
	    int count1=jt.update(WITHDRAW_QUERY,amount,accno);
		return count1;
	}

}
