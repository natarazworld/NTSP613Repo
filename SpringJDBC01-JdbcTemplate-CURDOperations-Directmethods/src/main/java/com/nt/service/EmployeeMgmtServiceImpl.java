package com.nt.service;

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

}
