package com.nt.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO  dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
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
	public String fireEmployeesByNos(int enos[]) {
		//convert enos[] into  (val1,val2,val3,...)
		StringBuffer cond=new StringBuffer();
		for(int i=0;i<enos.length;++i) {
		   if(i==0) //first element
		   cond.append("("+enos[i]+",");   //gives (10,
		   else if(i==enos.length-1) //last element
			   cond.append(enos[i]+")");  // gvies 30)
		   else  //other elements
			   cond.append(enos[i]+",");   //gives  20,
      	}
		System.out.println("condition data::"+cond); //gives (10,20,30)
		
		//use DAO
		int count=dao.deleteEmployeesByEnos(cond.toString());
		return count==0?"Employees not found for deletion":Arrays.toString(enos)+"--> Employees are found and deleted";
	}

	

}
