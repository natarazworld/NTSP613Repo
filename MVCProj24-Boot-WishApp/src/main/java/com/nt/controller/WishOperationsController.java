package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishOperationsController {
	@Autowired
	 private IWishMessageService service;
	
	@GetMapping("/")
	public String showHome() {
		//return  LVN
		return "home";
	}
	
	@GetMapping("/wish")
	public String generateWishMessage(Map<String,Object> map) {
	     //use service
		String result=service.generateWishMessage();
		//keep the results in Model attributes
		map.put("resultMsg",result);
		//return LVN
		return "show_results";
		
	}

}
