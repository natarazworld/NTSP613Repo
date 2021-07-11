package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@Controller
public class CoronaVaccineReportGenerationController {
	@Autowired
	   private ICoronaVaccineMgmtService service;

	@GetMapping("/")
	public  String  showHomePage() {
		return "home";
	}
	
	@GetMapping("/report")
	public String  generateReport(@RequestParam("type") String type,
			                                            Map<String,Object> map) {
		//use service
		List<CoronaVaccine> listVaccines=service.fetchAllVaccines();
		//add to model attributes
		map.put("vaccineList",listVaccines);
		//return LVN
		 if(type.equalsIgnoreCase("pdf"))
			 return "pdf_view";
		 else
			 return "excel_view";
	}
}
