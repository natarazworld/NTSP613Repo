package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			                                           BindingResult errors) {
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
	
	@ModelAttribute("countriesInfo")
	public Set<String>   gatherCountries(){
		System.out.println("CiitizenOperationsController.gatherCountries()");
		//use service
		Set<String> countriesSet=service.getAllCountries();
		return countriesSet;
	}
	
	@ModelAttribute("languagesInfo")
	public Set<String>   gatherLangugaes(){
		System.out.println("CiitizenOperationsController.gatherLanguages()");
		//use service
		Set<String> languagesSet=service.getAllLanguages();
		return languagesSet;
	}
	
	@ModelAttribute("hobiesInfo")
	public Set<String> gatherHobies(){
		System.out.println("CiitizenOperationsController.gatherHobies()");
		//use service
				Set<String> hobiesSet=service.getAllHobies();
				return hobiesSet;
	}
	
	

	@PostMapping("/states")
	public String   ShowStatesByCountry(@RequestParam("country") String country,
			                                                         @ModelAttribute("citizen") CitizenDetails details,
			                                                         Map<String,Object> map) {
		System.out.println("CiitizenOperationsController.ShowStatesByCountry()");
       //use service
		Set<String> statesSet=service.getStatesOfACountry(country);
		map.put("statesInfo",statesSet);
          //return LVN		
		return "citizen_register";
		
	}
	
	
}
