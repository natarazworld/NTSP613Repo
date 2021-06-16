package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.StudentDTO;
import com.nt.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService service;
	
	//@RequestMapping("/test")
	@GetMapping("/test")
	public  String displayData(Map<String, Object> map) {
		//use service
		String val1=service.getData1();
		int val2[]=service.getData2();
		List<String> listVal3=service.getData3();
		Set<Long> setVal4=service.getData4();
		Map<String,Object> mapVal5=service.getData5();
		List<StudentDTO> listDTO=service.getData6();
		// added shared memory as model attributes
		map.put("data1",val1);
		map.put("data2",val2);
		map.put("data3",listVal3);
		map.put("data4",setVal4);
		map.put("data5",mapVal5);
		map.put("data6",listDTO);
		//return lvn
		//return "result";
		return "result1";
	}
	

}
