package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	  @Autowired
	private   IEmployeeDAO  dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		//use  DAO
		List<EmployeeBO> listBO=dao.getEmpsByDesgs(desg1, desg2, desg3);
		//convert ListBO to ListDTO
		List<EmployeeDTO> listDTO=new ArrayList();
		listBO.forEach(bo->{
			//copy each BO to each DTO
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSerialNo(listDTO.size()+1);
			//add  each DTO to  ListDTO
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method

}//class
