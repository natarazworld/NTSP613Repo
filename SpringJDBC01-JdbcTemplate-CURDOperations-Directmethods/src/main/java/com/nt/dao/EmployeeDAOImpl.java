//EmployeeDAOImpl .java
package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private JdbcTemplate jt;
	
	public EmployeeDAOImpl(JdbcTemplate jt) {
		System.out.println("EmployeeDAOImpl:: 1-param constructor");
	  this.jt=jt;
	}

	@Override
	public int getEmployeesCount() {
		int count=jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

}
