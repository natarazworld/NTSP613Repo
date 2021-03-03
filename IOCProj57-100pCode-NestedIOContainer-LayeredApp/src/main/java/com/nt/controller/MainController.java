package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@Controller("controller")
public class MainController {
	@Autowired
	private  IEmployeeMgmtService  service;
	
	public List<EmployeeDTO>  showEmpsByDesgs(String desg1,String desg2,String desg3) throws Exception{
		//use serivce
		List<EmployeeDTO> listDTO=service.fetchEmpsByDesgs(desg1, desg2, desg3);
		return listDTO;
	}

}
