package com.nt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	/*@PostMapping("/register")
	public   String  regiterCitizen(RedirectAttributes rAttrs,
			                                           @ModelAttribute("citizen") CitizenDetails citizenDetails,
			                                           BindingResult errors) {
		System.out.println("CiitizenOperationsController.regiterCitizen()");
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
		rAttrs.addFlashAttribute("resultMsg", result);
		//redirect the request to another handler method  that contains GET mode
		return "redirect:display";
	}*/
	
	
	@PostMapping("/register")
	public   String  regiterCitizen(HttpSession ses,
			                                           @ModelAttribute("citizen") CitizenDetails citizenDetails,
			                                           BindingResult errors) {
		System.out.println("CiitizenOperationsController.regiterCitizen()");
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
		ses.setAttribute("resultMsg", result);
		//redirect the request to another handler method  that contains GET mode
		return "redirect:display";
	}
	
	@GetMapping("/display")
	public  String   showResultPage() {
		System.out.println("CiitizenOperationsController.showResultPage()");
		//return LVN
		return "show_result";
	}

}
