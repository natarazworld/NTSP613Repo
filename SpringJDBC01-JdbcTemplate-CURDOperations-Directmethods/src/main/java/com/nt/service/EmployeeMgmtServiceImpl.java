package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
	  this.dao=dao;
	}

	@Override
	public int fetchEmpsCount() {
	   //use DAO
		int count=dao.getEmployeesCount();
		return count;
	}

	@Override
	public float fetchEmpSalaryByEno(int eno) {
		//use DAO
		float salary=dao.getEmployeeSalaryByEno(eno);
		return salary;
	}
	
	@Override
	public Map<String, Object> fetchEmployeeDetailsByEno(int eno) {
		//use DAO
		Map<String,Object>  map=dao.getEmployeeDetailsByEno(eno);
		return map;
	}

	@Override
	public List<Map<String, Object>> fetchEmployeeDetailsByDesgs(String desg1, String desg2, String desg3) {
	   //use DAO
		List<Map<String,Object>> list=dao.getEmployeeDetailsByDesgs(desg1, desg2, desg3);
		return list;
	}
	
	@Override
	public SqlRowSet fetchEmployeeDetailsBySalRange(float startSalary, float endSalary) {
		//use DAO
		SqlRowSet rowset=dao.getEmployeeDetailsBySalaryRange(startSalary, endSalary);
		return rowset;
	}
	
	@Override
	public String registerEmployee(String name, String desg, float salary) {
	    //use DAO
		int count=dao.insertEmployee(name, desg, salary);
		return count==0?"Employee not registered":"Employee is registered";
	}
	
	@Override
	public String hikeEmployeeSalary(int eno, float percentage) {
	       // get current  salary of employee
		float salary=fetchEmpSalaryByEno(eno);
		//calculate new salary
		float newSalary=salary+ (salary*percentage/100.0f);
		//use dao
		int count=dao.updateEmployeeSalary(eno, newSalary);
		return count==1?"Employee Salary updated with ::"+newSalary:"Employee salary not updated";
	}
	
	@Override
	public String fireEmployeesBySalaryRange(float startSalary, float endSalary) {
		int count=dao.deleteEmployeeBySalaryRange(startSalary, endSalary);
		return count==0?"No employees found for deletion":count+"no.of employees are found and deleted";
	}

}//class
