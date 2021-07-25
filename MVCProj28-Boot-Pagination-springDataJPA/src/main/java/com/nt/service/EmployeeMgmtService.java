package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtService implements IEmployeeMgmtService {
	@Autowired
     private  IEmployeeRepo  empRepo;
	
	@Override
	public Page<Employee> getPageData(Pageable pageable) {
            //use  reop
		Page<Employee>  page=empRepo.findAll(pageable);
		return  page;
	}

}
