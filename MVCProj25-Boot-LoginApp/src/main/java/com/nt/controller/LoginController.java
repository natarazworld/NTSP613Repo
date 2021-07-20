package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.UserDetails;
import com.nt.service.ILogjnManagementService;

@Controller
public class LoginController {
	
	@Autowired
	private ILogjnManagementService service;
	
	@GetMapping("/")
	public  String showHome() {
		//return LVN
		return "home";
	}
	
	@GetMapping(value="/login")
	public  String  showLoginPage(@ModelAttribute("userForm") UserDetails details) {
		//return LVN
		return "login_form";
		
	}
	
	@PostMapping(value="/login")
	public  String  PerformLogin(@ModelAttribute("userForm") UserDetails details,Map<String,Object> map) {
		// use service
      String result=service.doLogin(details.getUsername(),details.getPassword());
      //keep result in model attribute
      map.put("resultMsg",result);
      
      //retunr LNV
         return "login_form";
		
	}

}
