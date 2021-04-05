package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDAOImpl2 implements IEmployeeDAO {
	private static final String  GET_EMP_BY_ENO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public EmployeeBO getEmployeeByNo(int eno) {
		EmployeeBO  ebo=jt.queryForObject(GET_EMP_BY_ENO,
				                                                       ( rs,rowNum)->{
			                                                                	//copy RS object record EmployeeBO class obj
			                                                                	   EmployeeBO bo=new EmployeeBO();
			                                                                	   bo.setEmpNo(rs.getInt(1));
			                                                                	   bo.setEname(rs.getString(2));
			                                                                	   bo.setJob(rs.getString(3));
			                                                                	   bo.setSal(rs.getFloat(4));
			                                                                	   return  bo;
			                                                                }
		                                                              ,eno);
		return ebo;
	}
	
}//DAO class
