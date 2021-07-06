package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.WebRequestDataBinder;

import com.nt.model.CitizenDetails;
import com.nt.service.ICitizenMgmtService;
import com.nt.validator.CitizenDetialsValidator;

@Controller
public class CiitizenOperationsController {
	   @Autowired
	   private  ICitizenMgmtService service;
	   @Autowired
	   private CitizenDetialsValidator  validator;
	   
	@GetMapping("/register")
	public String  showHome(@ModelAttribute("citizen") CitizenDetails details) {
		return "citizen_register";
	}
	
	@PostMapping("/register")
	public   String  regiterCitizen(Map<String,Object>  map,
			                                           @ModelAttribute("citizen") CitizenDetails citizenDetails,
			                                           BindingResult errors,HttpServletRequest req) {
		System.out.println(req.getParameter("dom"));
		System.out.println("model object data::"+citizenDetails);
	//peform server side form validations only client side form validations are not done
		System.out.println(citizenDetails.getVflag());
	if(citizenDetails.getVflag().equalsIgnoreCase("no")) {
		if(validator.supports(CitizenDetails.class)) {
			  validator.validate(citizenDetails, errors);
				if(errors.hasErrors())
					return "citizen_register";  //LVN of form page 
		}
		else
			return "citizen_register";  //LVN of form page
		}
		
		//application logic errors
		 if(citizenDetails.getAddrs().equalsIgnoreCase("mumbai")) {
			    errors.rejectValue("addrs", "addrs.location.error");
			    //return LVN
			    return "citizen_register";
		 }
		
		//use service
		String result=service.vaccineRegistration(citizenDetails);
		
		//keep result in  model attribute
		map.put("resultMsg",result);
		//return LVN
		return "show_result";
	}
	
	
	@ModelAttribute("vaccinesBunch")
	public List<String>   gatherAllVaccines(){
		System.out.println("CiitizenOperationsController.gatherAllVaccines()");
		//use service
		List<String> vaccinesList=service.fetchAllVaccines();
		return vaccinesList;
	}
	
	
		@InitBinder
		public  void  myInitBinder(ServletRequestDataBinder binder) {
			System.out.println("CiitizenOperationsController.myInitBinder()");
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
			
		}
	
	
	
}
