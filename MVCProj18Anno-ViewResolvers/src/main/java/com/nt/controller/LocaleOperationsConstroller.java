package com.nt.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ILocaleMgmtService;

@Controller
public class LocaleOperationsConstroller{
	@Autowired
  private ILocaleMgmtService  service;
	
	@RequestMapping("/welcome")
	public String showHomePage() {
	    //return LVN
		return "home";
	}
	
	
	
	@RequestMapping("/about")  //default mode is GET
	public  String  showAboutUsPage() {
		System.out.println("LocaleOperationsConstroller.showAboutUsPage()");
		//return LVN
		return "about_us";
	}
	
	
	@RequestMapping("/contact")
	public  String  showContactUsPage() {
		//return LVN
		return "contact_us";
	}

}
