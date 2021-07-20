package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  EMP_REGISTRATION_QUERY="INSERT INTO  EMPLOYEE_UPLOAD VALUES(ENO_SEQ.NEXTVAL,?,?,?,?)";
	@Autowired
	private JdbcTemplate  jt;

	@Override
	public int insert(Employee emp) {
       int count=jt.update(EMP_REGISTRATION_QUERY,emp.getEname(),emp.getAddrs(),emp.getResumeFileLocation(),emp.getPhotoFileLocation());
		return count;
	}
	
	

}
