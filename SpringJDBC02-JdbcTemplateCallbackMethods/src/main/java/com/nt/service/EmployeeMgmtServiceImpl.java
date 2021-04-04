package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public EmployeeDTO fetchEmployeeByNo(int eno) {
	    //use DAO
		EmployeeBO bo=dao.getEmployeeByNo(eno);
		//convert BO to DTO
		EmployeeDTO dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}

}
