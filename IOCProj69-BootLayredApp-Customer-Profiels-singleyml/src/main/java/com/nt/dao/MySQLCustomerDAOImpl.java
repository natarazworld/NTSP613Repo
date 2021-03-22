package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;


@Repository("mysqlCustDAO")
@Profile({"dev","test"})
public  class MySQLCustomerDAOImpl implements ICustomerDAO {
	private static  final String  INSERT_CUSTOMER_QUERY="INSERT INTO LAYERED_CUSTOMER(CNAME,CADD,PAMT,TIME,RATE,INTRAMT) VALUES(?,?,?,?,?,?)";
	
	@Autowired
	private DataSource ds;
	
	public MySQLCustomerDAOImpl() {
		System.out.println("MySQLCustomerDAOImpl:: 0-param constructor");
	}
	
	
	@Override
	public int insert(CustomerBO bo) throws Exception {
		
		//get pooled jdbc con object
		Connection con=ds.getConnection();
		System.out.println("DS class name::"+ds.getClass());
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
