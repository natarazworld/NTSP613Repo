package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.CitizenDetails;
import com.nt.service.ICitizenMgmtService;

@Controller
public class CiitizenOperationsController {
	   @Autowired
	   private  ICitizenMgmtService service;
	   
	@GetMapping("/register")
	public String  showHome(@ModelAttribute("citizen") CitizenDetails details) {
		return "citizen_register";
	}
	
	@PostMapping("/register")
	public   String  regiterCitizen(Map<String,Object>  map, @ModelAttribute CitizenDetails citizenDetails) {
		//use service
		String result=service.vaccineRegistration(citizenDetails);
		//keep result in  model attribute
		map.put("resultMsg",result);
		//return LVN
		return "show_result";
	}

}
