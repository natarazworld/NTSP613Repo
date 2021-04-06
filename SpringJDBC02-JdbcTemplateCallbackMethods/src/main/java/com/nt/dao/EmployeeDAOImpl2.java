package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDAOImpl2 implements IEmployeeDAO {
	private static final String  GET_EMP_BY_ENO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String  GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
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

	@Override
	public List<EmployeeBO> getEmployeesByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO1=jt.query(GET_EMPS_BY_DESG,
                         rs-> {
                        	  //copy RS object records to ListBO
                        	  List<EmployeeBO> listBO=new ArrayList();
                        	  while(rs.next()) {
                                     //retrive each record to BO class obj
                        		   EmployeeBO bo=new EmployeeBO();
                        		   bo.setEmpNo(rs.getInt(1));
                        		   bo.setEname(rs.getString(2));
                        		   bo.setJob(rs.getString(3));
                        		   bo.setSal(rs.getFloat(4));
                        		   //add each BO class obj to List collection
                        		   listBO.add(bo);
                        	  }//while
                          	return listBO;
                    }// LAMDA based anonymous inner class
                 ,
                desg1,desg2,desg3);
        return listBO1; //returns to service class	
	}// method
	
}//DAO class
