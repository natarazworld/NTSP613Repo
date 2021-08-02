package com.nt.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ILocaleMgmtService;

@Controller("controller")
public class LocaleOperationsConstroller{
	@Autowired
  private ILocaleMgmtService  service;
	
	@RequestMapping("/welcome")
	public String showHomePage() {
	    //return LVN
		return "home";
	}
	
	
	
	
	/*@RequestMapping("/list_countries")
	public ModelAndView  fetchCoutries() {
		//use service
		List<String> countriesList=service.fetchAllCountries();
		//return MAV
		ModelAndView mav=new ModelAndView();  // This style allows to add multiple model attributes 
		mav.addObject("countriesInfo",countriesList);
		mav.addObject("sysDate",LocalDateTime.now());
		mav.setViewName("result");
		return mav;
	}*/
	
	/*@RequestMapping("/list_countries")
	public String fetchCoutries(Model model) {
		System.out.println("model attributes shared memory obj is::"+model.getClass());
		//use service
		List<String> countriesList=service.fetchAllCountries();
		//return MAV
		model.addAttribute("countriesInfo",countriesList);
		model.addAttribute("sysDate",LocalDateTime.now());
		//return LVN
		return "result";
	}*/
	
	/*@RequestMapping("/list_countries")
	public String fetchCoutries(ModelMap model) {
		System.out.println("model attributes shared memory obj is::"+model.getClass());
		//use service
		List<String> countriesList=service.fetchAllCountries();
		//return MAV
		model.addAttribute("countriesInfo",countriesList);
		model.addAttribute("sysDate",LocalDateTime.now());
		//return LVN
		return "result";
	}*/
	
	@RequestMapping("/list_countries")
	public String fetchCoutries(Map<String,Object> map) {
		System.out.println("model attributes shared memory obj is::"+map.getClass());
		//use service
		List<String> countriesList=service.fetchAllCountries();
		//return MAV
		map.put("countriesInfo",countriesList);
		map.put("sysDate",LocalDateTime.now());
		//return LVN
		return "result";
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
