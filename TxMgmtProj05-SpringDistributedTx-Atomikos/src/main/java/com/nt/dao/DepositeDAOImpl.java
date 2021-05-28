package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dDAO")
public class DepositeDAOImpl implements IDepositeDAO {
	private  static  final String  DEPOSITE_QUERY="UPDATE DTX_BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
		@Autowired
	@Qualifier("mysqlTemplate")
	private  JdbcTemplate jt;


		
			
			@Override
			public int deposite(long accno, double amount) {
			    int count2=jt.update(DEPOSITE_QUERY,amount,accno);
				return count2;
			}

}
