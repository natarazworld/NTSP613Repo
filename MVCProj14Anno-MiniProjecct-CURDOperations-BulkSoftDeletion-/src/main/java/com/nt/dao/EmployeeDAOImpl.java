package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static  final String GET_ALL_EMPS_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP1";
	private static  final String GET_EMP_BY_ENO_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP1 WHERE EMPNO=?";
	private static  final String UPDATE_EMP_BY_ENO="UPDATE EMP1 SET ENAME=?,JOB=?,SAL=? WHERE EMPNO=?";
	private static  final String DELETE_EMP_BY_ENO="DELETE FROM EMP1  WHERE EMPNO IN ";
	
	@Autowired
	private  JdbcTemplate  jt;

	@Override
	public List<Employee> getAllEmployees() {
     List<Employee> listEmps=jt.query(GET_ALL_EMPS_QUERY,
    		                                                        rs->{
    		                                                        	List<Employee> empList=new ArrayList();
    		                                                        	while(rs.next()) {
    		                                                        		Employee emp=new Employee();
    		                                                        		emp.setEmpNo(rs.getInt(1));
    		                                                        		emp.setEname(rs.getString(2));
    		                                                        		emp.setJob(rs.getString(3));
    		                                                        		emp.setSal(rs.getFloat(4));
    		                                                        		empList.add(emp);
    		                                                        	}//while
                                                                    return empList;
          		                                                        }//anonymous inner class
    		                                                        );
		return listEmps;
	}

	@Override
	public Employee getEmployeeByEno(int eno) {
	       Employee emp=jt.queryForObject(GET_EMP_BY_ENO_QUERY,(rs,index)->{
	    	       Employee e=new Employee();
	    	       e.setEmpNo(rs.getInt(1));
	    	       e.setEname(rs.getString(2));
	    	       e.setJob(rs.getString(3));
	    	       e.setSal(rs.getFloat(4));
	    	      return e;
	                 },eno); 
		return emp;
	}//nethod
	
	@Override
	public int updateEmployeeByEno(Employee emp) {
		int count=jt.update(UPDATE_EMP_BY_ENO,
				                           emp.getEname(),emp.getJob(),emp.getSal(),emp.getEmpNo());
		return count;
	}

	@Override
	public int deleteEmployeesByEnos(String cond) {
		
		int count=jt.update(DELETE_EMP_BY_ENO+cond);
		return count;
	}
	
}//class
