package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.CitizenDetails;

@Component
public class CitizenDetialsValidator  implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
         if(clazz==CitizenDetails.class)
		return true;   // executes  validate(-,-) to perform validations
         else
        	 return false;  //stop executing  validate(-,-) next to perform validations
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("CitizenDetialsValidator.validate():: server side form validation logic");
		//type casting
		CitizenDetails details=(CitizenDetails)target;
		if(details.getName()==null || details.getName().equals("") ||details.getName().length()==0)
			errors.rejectValue("name","citizen.name.required");
		else if(details.getName().length()<5)
			errors.rejectValue("name","citizen.name.minlen");
		
		if(details.getAddrs()==null || details.getAddrs().equals("") ||details.getAddrs().length()==0)
			errors.rejectValue("addrs","citizen.addrs.required");
		else if(details.getAddrs().length()<5)
			errors.rejectValue("addrs","citizen.addrs.minlen");
		
		if(details.getAadharNo()==null )
			errors.rejectValue("aadharNo","citizen.aadhar.required");
		else if(String.valueOf(details.getAadharNo()).length()!=12)
			errors.rejectValue("aadharNo","citizen.aadhar.length");
		
		
		if(details.getVaccineName()==null || details.getVaccineName().equalsIgnoreCase("") || details.getVaccineName().length()==0)
			errors.rejectValue("vaccineName","citizen.vaccine.required");
		
		if(details.getIncome()==null )
			errors.rejectValue("income","citizen.income.required");
		else if (details.getIncome()<1000.0 ||  details.getIncome()>1000000.0) 
			errors.rejectValue("income","citizen.income.range");	
		
		
		
		
	}

}
