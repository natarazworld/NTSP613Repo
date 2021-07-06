package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.ICitizenDAO;
import com.nt.model.CitizenDetails;

@Service("ctznService")
public class CitizenMgmtServiceImpl implements ICitizenMgmtService {
	@Autowired
	private  ICitizenDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false,timeout = 30)
	public String vaccineRegistration(CitizenDetails details) {
		//write b.logic
		if(details.getAddrs().equalsIgnoreCase("delhi")) {
			details.setPrice(0.0);
			details.setRemarks("In Delhi corona vaccination is free");
		}
		else if(details.getIncome()<100000) {
			details.setPrice(0.0);
			details.setRemarks("For poor people  corona vaccination is free");
		}
		else if(details.getIncome()<200000) {
			details.setPrice(250.00);
			details.setRemarks("For less income people  corona vaccination fee is ::"+details.getPrice());
		}
		else {
			details.setPrice(1250.00);
			details.setRemarks("For normal people  corona vaccination fee is ::"+details.getPrice());
		}
	     //use DAO
		   int count=dao.insert(details);
		   return count==0?"Registration for Vaccination is failed":"Registration for Vaccination is completed with the remarks "+details.getRemarks();
	}//method

	@Override
	public List<String> fetchAllVaccines() {
		//use DAO
		List<String> vaccinesList=dao.getAllVaccineNames();
		return vaccinesList;
	}

	@Override
	public Set<String> getAllCountries() {
		Set<String>  countriesSet=new TreeSet();
		Locale locales[]=Locale.getAvailableLocales();
		for(Locale locale:locales) {
			countriesSet.add(locale.getDisplayCountry());
		}//for
		return countriesSet;
	}
	
	@Override
	public Set<String> getAllLanguages() {
		Set<String>  languagesSet=new TreeSet();
		Locale locales[]=Locale.getAvailableLocales();
		for(Locale locale:locales) {
			languagesSet.add(locale.getDisplayLanguage());
		}//for
		return languagesSet;
	}
	
	   @Override
	public Set<String> getAllHobies() {
		   Set<String>  hobiesSet=new TreeSet();
		   hobiesSet.add("Sleeping");
		   hobiesSet.add("Travelling");
		   hobiesSet.add("BookReading");
		   hobiesSet.add("surfing");
		   hobiesSet.add("watching movies");
		return hobiesSet;
	}
	   
	   private Map<String,Set<String>> countriesStatesInfo=new HashMap();
	   public CitizenMgmtServiceImpl() {
		 Set<String> indiaStates=Set.of("AP","TS","MP","MH","BH","UP","OR","WB","KL","KA","PU","DL","TN");
		 Set<String> usaStates=Set.of("FL","ARZ","TXS","HWIAI"," Alabama","Alaska","Arizona","Arkansas","Colorado","Georgia"," Illinois","Indiana","Kentucky");
		 countriesStatesInfo.put("India",indiaStates);
		 countriesStatesInfo.put("United States",usaStates);
	}
	 
	   
	   @Override
	public Set<String> getStatesOfACountry(String country) {
		return countriesStatesInfo.get(country);
	}
}//class
