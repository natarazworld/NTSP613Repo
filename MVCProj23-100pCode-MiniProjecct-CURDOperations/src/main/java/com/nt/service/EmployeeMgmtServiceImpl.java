package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false,transactionManager = "dsTxMgmr")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO  dao;

	@Override
	public List<Employee> fetchAllEmps() {
	  //use dao
		List<Employee> listEmps=dao.getAllEmployees();
		return listEmps;
	}

	@Override
	public Employee fetchEmployeeById(int eno) {
		//use DAO
		Employee emp=dao.getEmployeeByEno(eno);
		return emp;
	}

	@Override
	public String modifyEmployeeById(Employee emp) {
	  //use DAO
		int count=dao.updateEmployeeByEno(emp);
		return count==1?"Employee Updated " : "Employee Not updated";
	}

	@Override
	public String fireEmployeeByNo(int eno) {
		//use DAO
		int count=dao.deleteEmployeeByEno(eno);
		return count==0?"Employee not found for deletion":eno+"--> Employee founda nd deleted";
	}

}
