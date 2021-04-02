//EmployeeDAOImpl .java
package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_SALARY_BY_EMPNO="SELECT SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETTAILS_BY_EMPNO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETTAILS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private static final String GET_EMP_DETTAILS_BY_SALRANGE="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>=? AND SAL<=?";
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

	@Override
	public Float getEmployeeSalaryByEno(int eno) {
	    float salary=jt.queryForObject(GET_EMP_SALARY_BY_EMPNO,Float.class,eno);
		return salary;
	}
	
	@Override
	public Map<String, Object> getEmployeeDetailsByEno(int eno) {
		Map<String,Object> map=jt.queryForMap(GET_EMP_DETTAILS_BY_EMPNO,eno);
		return  map;
	}
	
	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesgs(String desg1,String desg2,String desg3) {
	   List<Map<String,Object>> list=jt.queryForList(GET_EMP_DETTAILS_BY_DESGS,desg1,desg2,desg3);
		return list;
	}

	@Override
	public SqlRowSet getEmployeeDetailsBySalaryRange(float startSalary, float endSalary) {
	   SqlRowSet rowset=jt.queryForRowSet(GET_EMP_DETTAILS_BY_SALRANGE, startSalary,endSalary);
		return rowset;
	}
	
	

}
