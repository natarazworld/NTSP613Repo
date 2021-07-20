package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;


@Controller
public class FileUploadAndDowloadOpearationsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	@Value("${dest.store.path}")
	private  String destPath;
	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "home";
	}
	
	@GetMapping("/register")
	public String  showForm(@ModelAttribute("empForm") Employee emp) {
		//return  LVN
		return "employee_register";
	}
	
	@PostMapping("/register")
	public  String registerEmployee(@ModelAttribute("empForm") Employee emp,Map<String,Object> map)throws Exception {
		//use service
		String resultMsg=service.uploadFiles(destPath, emp);
		//keep the result in model attribute
		map.put("resultMsg",resultMsg);
		//return LVN
		return "show_results";
	}
	
	@GetMapping("/report")
	public  String  employeesReoport(Map<String,Object> map)throws Exception {
		//use serivce
		  List<String> fiesList=service.getAllFiles(destPath);
		  //add results to model attribute
		  map.put("listFiles",fiesList);
		  //return LVN
		  return "employee_report";
	}

}
