package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;


public final class MySQLCustomerDAOImpl implements ICustomerDAO {
	private static  final String  INSERT_CUSTOMER_QUERY="INSERT INTO LAYERED_CUSTOMER(CNAME,CADD,PAMT,TIME,RATE,INTRAMT) VALUES(?,?,?,?,?,?)"; 
	private DataSource ds;
	
	public MySQLCustomerDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public int insert(CustomerBO bo) throws Exception {
		
		//get pooled jdbc con object
		Connection con=ds.getConnection();
		//create PreparedStatement object
		PreparedStatement ps=con.prepareStatement(INSERT_CUSTOMER_QUERY);
		//set values to query params by collecting data from BO class obj
		ps.setString(1,bo.getCname());
		ps.setString(2,bo.getCadd());
		ps.setFloat(3, bo.getPamt());
		ps.setFloat(5, bo.getTime());
		ps.setFloat(4, bo.getRate());
		ps.setFloat(6, bo.getIntrAmt());
		//execute the SQL query
		int count=ps.executeUpdate();
		//close jdbc objs
		 ps.close();
		 con.close(); //releases the jdbc con object back to jdbc con pool
		return count;
	}//method
}//class
